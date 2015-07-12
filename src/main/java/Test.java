import org.eu.slice.util.HttpRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		int a = 1;
//		switch (a) {
//
//		case 1:
//			System.out.println("1");
//		case 2:
//			System.out.println("2");
//		default:
//			System.out.println("default");
//		case 9:
//			System.out.println("9");
//		case 10:
//			System.out.println("10");
//		}


        //matchYYYYMMDD("2014-12-21 123");

        String data = "{'body': {'dateTime': '2015-07-06 08:00:00'}, 'uid': 'nugget', 'sign': '85f5be315df31b1253fe57b82a0882dc'}";
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.postBytes("http://app.nugget-nj.com/kindergarten_index/queryKindergarten", data.getBytes());
    }

    public static String matchYYYYMMDD(String date) {
        date = date.trim();
        if (date.length() < 10) return null;
        else
            date = date.substring(0, 10);

        String eL = "[0-9]{4}-[0-9]{2}-[0-9]{2}.*";
        Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(date);
        boolean dateFlag = m.matches();
        if (!dateFlag)
            return null;

        return date;
    }

    public void calDevSec() {
        int curDevSeconds = -3599;
        int sec = 0;
        int min = 0;
        if (curDevSeconds < 0) {
            int t = Math.abs(curDevSeconds) % 60;
            sec = t == 0 ? 0 : 60 - t;
            min = (int) (60 - Math.ceil((double) Math.abs(curDevSeconds) / 60));
            while (min < 0)
                min += 60;
        } else {
            sec = curDevSeconds % 60;
            min = curDevSeconds / 60;
            while (min >= 60)
                min -= 60;
        }
        System.out.println(sec);
        System.out.println(min);
    }

}
