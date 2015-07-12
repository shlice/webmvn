package org.eu.slice.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author shild 2014年7月9日
 */
public class HttpRequest {
	private static Logger logger = LoggerFactory.getLogger(HttpRequest.class);

	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public String sendGet(String url, String param, String cookie, Map<String, List<String>> respHds) {
		String result = "";
		BufferedReader in = null;
		HttpURLConnection connection = null;
		try {
			String urlNameString = url;
			if (param.length() > 0)
				urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			connection = (HttpURLConnection) realUrl.openConnection();
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			// 设置请求属性
			connection.setRequestMethod("GET");
			connection.setUseCaches(false);

			// connection.setRequestProperty("Accept-Charset", "UTF-8");
			// connection.setRequestProperty("ContentType", "UTF-8");
			connection.setRequestProperty("Cookie", cookie);
			connection
					.setRequestProperty(
							"User-Agent",
							"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.93 Safari/537.36");

			// 建立实际的连接
			connection.connect();

			// 获取所有响应头字段
			// printResponseHeader(connection);
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                respHds.put(key, map.get(key));
            }

			// parse contenttype
			String contentType = connection.getContentType().toLowerCase();
			int i = contentType.indexOf("charset=", 0);
			String type = "text/html";
			String charset = "UTF-8";
			if (i == -1)
				type = trimNonAlphabet(contentType);
			else {
				if (i >= 2)
					type = trimNonAlphabet(contentType.substring(0, i - 1));
				charset = trimNonAlphabet(contentType.substring(i + 8));
			}
			if (type.isEmpty())
				type = "text/html";
			if (charset.isEmpty())
				charset = "UTF-8";

			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), charset));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			logger.error("发送GET请求出现异常！" + e);
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null)
					in.close();
				if (connection != null)
					connection.disconnect();
			} catch (Exception e2) {
				// e2.printStackTrace();
			}
		}

		return result;
	}

	private static void printResponseHeader(HttpURLConnection http)
			throws UnsupportedEncodingException {
		Map<String, List<String>> map = http.getHeaderFields();
		// 遍历所有的响应头字段
		for (String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}
	}

	private static Map<String, String> getHttpResponseHeader(
			HttpURLConnection http) throws UnsupportedEncodingException {
		Map<String, String> header = new LinkedHashMap<String, String>();
		for (int i = 0;; i++) {
			String mine = http.getHeaderField(i);
			if (mine == null)
				break;
			header.put(http.getHeaderFieldKey(i), mine);
		}
		return header;
	}

	private String trimNonAlphabet(String input) {
		input = input.toLowerCase();
		int i = input.length();
		while (i > 0) {
			char c = input.charAt(i - 1);
			if (c >= 'a' && c <= 'z')
				break;
			i--;
		}

		return input.substring(0, i);
	}

	/**
	 * 向指定 URL发送POST请求，内容为params。 Spring MVC controller对端不可通过输入流读取。
	 * 
	 * @param url
	 * @param param
     *             请求参数，name1=value1&name2=value2 的形式。
	 * @return 远程响应结果
	 */
	public String sendPost(String url, String params) {
		return postBytes(url, params.getBytes(), false);
	}

	public String postBytes(String url, byte[] bytes) {
		return postBytes(url, bytes, true);
	}

	/**
	 * 向指定 URL发送POST请求，内容为bytes。
	 * 
	 * @param url
	 *            发送请求的 URL。
	 * @param bytes
	 *            请求内容。
	 * @param isBytes
	 *            设置为true，对端可以通过输入流读取。
	 * 
	 * @return 所代表远程资源的响应结果
	 */
	public String postBytes(String url, byte[] bytes, boolean isBytes) {
		BufferedOutputStream out = null;
		BufferedReader in = null;
		HttpURLConnection connection = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			connection = (HttpURLConnection) realUrl.openConnection();
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(1000);
			// 设置通用的请求属性
			// conn.setRequestProperty("accept", "*/*");
			// conn.setRequestProperty("connection", "Keep-Alive");
			// conn.setRequestProperty("user-agent",
			// "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			// 发送POST请求必须设置如下两行
			connection.setDoOutput(true);
			connection.setDoInput(true);
			// 长度
			// connection.setRequestProperty("Content-Length",
			// String.valueOf(bytes.length));
			if (isBytes)// 如果不设置，Spring mvc的POST controller无法读取输入流
				connection.setRequestProperty("Content-Type",
						"application/octet-stream");

			// 获取URLConnection对象对应的输出流
			out = new BufferedOutputStream(connection.getOutputStream());
			// 发送数据
			out.write(bytes);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}

            logger.info(result);
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			// e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
				if (connection != null)
					connection.disconnect();
			} catch (IOException ex) {
				// ex.printStackTrace();
			}
		}
		return result;
	}

    /**
     * 方法名称:transStringToMap 传入参数:mapString 形如 username=chenziwen;password=1234
     * 返回值:Map<String, String>
     */
    public static Map<String, String> transStringToMap(String mapString) {
        Map<String, String> map = new HashMap<String, String>();
        java.util.StringTokenizer items;
        StringTokenizer entrys = new StringTokenizer(mapString, ";");
        for (; entrys.hasMoreTokens();) {
            items = new StringTokenizer(entrys.nextToken(), "=");
            String key = items.nextToken().trim();
            String value = items.hasMoreTokens() ? ((String) (items.nextToken()).trim())
                    : null;
            map.put(key, value);
        }

        return map;
    }

	public static void main(String[] args) {
		// 发送 GET 请求
		// String s = HttpRequest.sendGet("http://www.baidu.com", "");
		// System.out.println(s);

		// 发送 POST 请求
		// String sr =
		// HttpRequest.sendPost("http://198.87.91.122:8080/pcs9000/common/savenode",
		// new String("path=/a&neeSync=true&value=234"));
		// System.out.println(sr);

		String sp = new HttpRequest().postBytes(
				"http://198.87.91.122:8080/pcs9000/common/savenode",
				new String("path=/a&neeSync=true&value=234").getBytes());
		System.out.println(sp);
	}
}
