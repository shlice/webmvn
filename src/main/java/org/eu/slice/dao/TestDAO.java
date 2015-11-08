package org.eu.slice.dao;

import org.eu.slice.base.common.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.LobRetrievalFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import javax.annotation.Resource;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by shild on 2015/8/19.
 */
@Repository("testDAO")
public class TestDAO {
    private static final Logger logger = LoggerFactory
            .getLogger(TestDAO.class);

    @Resource
    private LobHandler lobHandler;

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void addPost(final String uid, final String title, final String text, final byte[] data) {
        String sql = " INSERT INTO post(userid,title,text,attach)"
                + " VALUES(?,?,?,?)";
        jdbcTemplate.execute(sql,
                new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
                    protected void setValues(PreparedStatement ps, LobCreator lobCreator)
                            throws SQLException {
                        ps.setString(1, uid);
                        ps.setString(2, title);
                        lobCreator.setClobAsString(ps, 3, text);
                        lobCreator.setBlobAsBytes(ps, 4, data);
                    }
                });
    }

    /**
     * DAO不应该写文件，仅测试用
     * @param uid
     * @param title
     * @param textFile
     * @param file
     */
    public void addPost2(final String uid, final String title, final File textFile, final File file){
        try {
            final Reader reader = new FileReader(textFile);
            final InputStream is = new FileInputStream(file);

        String sql = " INSERT INTO post(userid,title,text,attach)"
                + " VALUES(?,?,?,?)";
        jdbcTemplate.execute(sql,
                new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
                    protected void setValues(PreparedStatement ps, LobCreator lobCreator)
                            throws SQLException {
                        ps.setString(1, uid);
                        ps.setString(2, title);
                        lobCreator.setClobAsCharacterStream(ps, 3, reader, (int) textFile.length());
                        lobCreator.setBlobAsBinaryStream(ps, 4, is, (int) file.length());
                    }
                });
        } catch (FileNotFoundException e) {
            throw new DaoException("File Not Found!");
        }
    }

    public List getAttachsAsBytes(final String userId) {
        String sql = "SELECT id,attach FROM post where userid =? and attach is not null ";
        return jdbcTemplate.query(
                sql, new Object[]{userId},
                new RowMapper() {
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                        int postId = rs.getInt(1);
                        // 以二进制数组方式获取 BLOB 数据。
                        byte[] attach = lobHandler.getBlobAsBytes(rs, 2);
                        return attach;
                    }
                });
    }

    public void getAttachAndText(final String uid,final OutputStream aos, final OutputStream tos, final FileWriter out){
    // 用于接收 LOB 数据的输出流
        String sql = "SELECT attach,text,id FROM post WHERE userid=? ";
        // 本接口只取一个记录，多个会报错
        jdbcTemplate.query(
                sql, new Object[]{uid},
                new AbstractLobStreamingResultSetExtractor() {
                    //匿名内部类
                    //处理未找到数据行的情况
                    protected void handleNoRowFound() throws LobRetrievalFailureException {
                        System.out.println("Not Found result!");
                    }

                    //以流的方式处理 LOB字段
                    public void streamData(ResultSet rs) throws SQLException, IOException {
                        String id = rs.getString("id");

                        InputStream ais = lobHandler.getBlobAsBinaryStream(rs, 1);
                        InputStream tis = lobHandler.getClobAsAsciiStream(rs, 2);
                        Reader in = lobHandler.getClobAsCharacterStream(rs, 2);
                        if (ais != null) {
                            FileCopyUtils.copy(ais, aos);
                        }
                        if(tis != null) {
                            FileCopyUtils.copy(tis, tos);
                        }
                        if(in != null) {
                            FileCopyUtils.copy(in, out);
                        }
                    }
                }
        );
    }

    public void removePost(String userid) {
        String sql = "delete from post where userid = ?";
        jdbcTemplate.update(sql, userid);
    }

    public void testException() {
        try {
//            String a = null;
//            a.length();
            final Reader reader = new FileReader("a.txt");
        }catch(NullPointerException e) {
            logger.error(e.getMessage());
            throw new DaoException("string is null", e);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            throw new DaoException("File not found", e);
        }
    }
}
