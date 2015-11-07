package org.eu.slice.kgtest;

import org.eu.slice.util.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shild on 2015/7/13.
 */
public class Request {

    private static Logger logger = LoggerFactory.getLogger(Request.class);

    public static void main(String[] args) {
        String time = Util.getTime();
        String time2 = Util.getTime2();
        Request r = new Request();

//        r.queryQuestion(time);

//        r.regValid("黄晓伟", "350582197903050273", time);
        /*
        {"obj":{"idNo":"350582197903050273","category":300,"iuId":"20141021172851000015","name":"黄晓伟","answer":"3716e00840911225f38620dc8eeca023","parentid":1725,"question":"您的出生地是？"},"code":"000000","msg":"操作成功"}
         */

       // r.queryChildInfo("20141021172851000015", time);
        /*
        {"objlist":[{"id":2013110,"birthday":"2010-09-09","sex":0,"classId":101011011,"name":"黄子涵","className":"宝1班"}],"code":"000000","msg":"操作成功"}
         */

        r.getRequestHtml("20141021172851000015", "2013110", time2, "/message/parentsmess");
        /*
        http://app.nugget-nj.com/nugget/health/givemedic?c=2013110&dt=20150713165513&u=20141021172851000015&sign=64b9878cef09172873e864fe280d3e38
         */

        //r.pageQueryGrowthArchiveNew("2013110", "0", "10");
    }

    /**
     * 密保问题
     */
    public void queryQuestion(String time) {
        String body = "{\"dateTime\":\"" + time + "\"}";
        String sign = Util.getMD5Str(body + Variable.requestKey);
        String p = "{\"uid\":\"" + Variable.uid + "\",\"body\":" + body
                + ",\"sign\":\"" + sign + "\"}";
        String url = Variable.SERVER_SOFT_URL + "/system/queryQuestion";

        HttpRequest httpRequest = new HttpRequest();
        httpRequest.postBytes(url, p.getBytes());
    }

    /**
     * 注册验证
     */
    public void regValid(String name, String idNo, String time) {
        String body = "{\"name\":\"" + name + "\",\"idNo\":\"" + idNo
                + "\",\"dateTime\":\"" + time + "\"}";
        String sign = Util.getMD5Str(body + Variable.requestKey);
        String p = "{\"uid\":\"" + Variable.uid + "\",\"body\":" + body
                + ",\"sign\":\"" + sign + "\"}";
        String url = "";
        url = Variable.SERVER_SOFT_URL + "/parent/regValid";
//            url = Variable.SERVER_SOFT_URL + "/teacher/regValid";
        logger.info(url);

        HttpRequest httpRequest = new HttpRequest();
        httpRequest.postBytes(url, p.getBytes());
    }

    /**
     * 查询幼儿信息
     */
    public void queryChildInfo(String iuId, String time) {
        String body = "{\"iuId\":\"" + iuId + "\",\"dateTime\":\"" + time
                + "\"}";
        String sign = Util.getMD5Str(body + Variable.requestKey);
        String p = "{\"uid\":\"" + Variable.uid + "\",\"body\":" + body
                + ",\"sign\":\"" + sign + "\"}";
        String url = Variable.SERVER_SOFT_URL + "/parent/queryChildInfo";
        logger.info(url);
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.postBytes(url, p.getBytes());
    }

    public String getRequestHtml(String iuId, String cid, String time, String curl) {
        // body参数在sign之前必须要排序
        String body = "c=" + cid + "&dt=" + time + "&u=" + iuId;
        String sign = Util.getMD5Str(body + Variable.requestKey);
        //String sign = MD5.sign(body, Variable.requestKey, "utf-8");//结果同上
        String p = body + "&sign=" + sign;

//        String p = "{\"uid\":\"" + Variable.uid + "\",\"body\":" + body
//                + ",\"sign\":\"" + sign + "\"}";


        String url = Variable.SERVER_HTML_URL + curl + "?" + p;
        logger.info(url);
        return url;
    }

    /**
     * 查询成长记录
     */
    public void pageQueryGrowthArchiveNew(String id, String pageIndex,
                                          String pageSize) {
        String url = Variable.SERVER_SOFT_URL
                + "/parent/pageQueryGrowthArchiveNew";
        Map<String, Object> bodyMap = new HashMap<String, Object>();
        bodyMap.put("childId", id);
        bodyMap.put("pageIndex", pageIndex);
        bodyMap.put("pageSize", pageSize);
        String p = Util.setRequest(bodyMap);

        HttpRequest httpRequest = new HttpRequest();
        httpRequest.postBytes(url, p.getBytes());
    }
}
