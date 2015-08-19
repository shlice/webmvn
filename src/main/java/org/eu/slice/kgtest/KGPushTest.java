package org.eu.slice.kgtest;

import org.eu.slice.util.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shild on 2015/7/13.
 */
public class KGPushTest {

    private static Logger logger = LoggerFactory.getLogger(KGPushTest.class);

    public static void main(String[] args) {
        String time = Util.getTime();
        KGPushTest r = new KGPushTest();

        r.pushmsg("aaa", "Hello,world!", time);
    }

    public void pushmsg(String iuId, String msg, String time) {
        String body = "{\"user_id\":\"" + iuId + "\",\"msg\":\"" + msg + "\",\"dateTime\":\"" + time
                + "\"}";
        String sign = Util.getMD5Str(body + Variable.requestKey);
        String p = "{\"type\":\"" + "PUSHMSG" + "\",\"body\":" + body
                + ",\"sign\":\"" + sign + "\"}";
        String url = "http://localhost:8080/pushservice/api";
        logger.info(url);
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.postBytes(url, p.getBytes());
    }

}
