package org.eu.slice.service;

import org.eu.slice.dao.TestDAO;
import org.eu.slice.util.web.ContextUtility;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;

/**
 * Created by shild on 2015/8/19.
 */
@Service("testService")
public class TestService {
    @Resource(name = "testDAO")
    private TestDAO testDAO;

    public void insertLobPost(String uid) throws IOException {
            ClassPathResource res = new ClassPathResource("temp.jpg");
            byte[] mockImg = FileCopyUtils.copyToByteArray(res.getFile());
            testDAO.addPost(uid, "title", "测试内容", mockImg);

//            throw new RuntimeException("test");//roll back
//            throw new IOException("test");//no roll back
    }

    public void getByteLobPostByUid(String uid) {
        List list = testDAO.getAttachsAsBytes(uid);
        if (list.size() > 0) {
            byte[] arr = (byte[]) list.get(0);

            File file = new File(ContextUtility.webAppPath + "temp" + File.separator + "temp_read_db_bytes_1.jpg");

            //仅有FileSystemResource具有Writable接口
            WritableResource res = new FileSystemResource("d:/temp_read_db_bytes_2.jpg");

            try {
                FileCopyUtils.copy(arr, file);
                FileCopyUtils.copy(arr, res.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getOSLobPostByPid(String uid) {
        try {
            final OutputStream os=new FileOutputStream(new File(ContextUtility.webAppPath + "temp" + File.separator + "temp_read_db_os.jpg"));
            final OutputStream tos=new FileOutputStream(new File(ContextUtility.webAppPath + "temp" + File.separator + "temp_read_db_os.txt"));
            final FileWriter fw = new FileWriter(new File(ContextUtility.webAppPath + "temp" + File.separator + "temp_read_db_fw.txt"));
            testDAO.getAttachAndText(uid, os, tos, fw);

            os.close();
            tos.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
    }

    public void removePost(String userid) {
        Assert.hasText(userid,"userid is empty!");
        testDAO.removePost(userid);
    }
}
