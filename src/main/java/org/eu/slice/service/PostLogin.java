package org.eu.slice.service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

/**
 * 
 * @author shild 2014年7月9日
 */
public class PostLogin {
	/**
	 * 向指定 URL发送POST请求，内容为params。 Spring MVC controller对端不可通过输入流读取。
	 * 
	 * @param url
	 * @param param
	 *            请求参数，name1=value1&name2=value2 的形式。
	 * @return 远程响应结果
	 */
	public static String sendPost(String url, String data, String cookie) {
		return postBytes(url, data.getBytes(), cookie, false);
	}

	public static String postBytes(String url, byte[] bytes, String cookie) {
		return postBytes(url, bytes, cookie, true);
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
	public static String postBytes(String url, byte[] bytes, String cookie,
			boolean isBytes) {
		BufferedOutputStream out = null;
		BufferedReader in = null;
		HttpURLConnection connection = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			connection = (HttpURLConnection) realUrl.openConnection();
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(5000);

			connection.setRequestProperty("Cookie", cookie);
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestMethod("POST");
			// 发送POST请求必须设置如下两行
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

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

	public static void main(String[] args) {
		String url = "http://www.baiduyun.me/plugin.php?id=dsu_amupper&ppersubmit=true&formhash=83577b21&infloat=yes&handlekey=dsu_amupper&inajax=1&ajaxtarget=fwin_content_dsu_amupper";
		String params = "";
		String cookie = "__cfduid=d517647bd38e649a4c765fc18376004c01433481600; bdshare_firstime=1433481563769; NO6v_8a3b_saltkey=KSxc4fPN; NO6v_8a3b_lastvisit=1433665993; NO6v_8a3b_visitedfid=37; NO6v_8a3b_sendmail=1; NO6v_8a3b_seccodeSAI068930=1407Psj3oRHMw5SHXXPYdFRhEBxk96OUXiEJAofCR9KXH1IdBniHLcY2OXmnk74JFq3a7Vbc2ZAk3ZlUj2%2Fl; NO6v_8a3b_ulastactivity=3601n%2BGAVo87HaAP2FjYFST4J5bDlukXIxQF2nBddXiSRAekng72; NO6v_8a3b_auth=1609ma%2FMkCxCAK2PizVGKdrRVUavLxHsov%2BP9sbQyOtuwuowXW2qLRfhRc4tlETWYQ0PkbTokxRb0iFe5cuBEPzlIEU; NO6v_8a3b_lastcheckfeed=253223%7C1433669709; NO6v_8a3b_checkfollow=1; NO6v_8a3b_lip=115.239.235.188%2C1433669580; NO6v_8a3b_security_cookiereport=95a9M7ZStXaWOZpwNZWEwS3kfQuFqlcWKQ%2BUeH%2Ffzs0APKPqKEtX; NO6v_8a3b_study_baiduconnect_band=1314; NO6v_8a3b_viewid=tid_161440; NO6v_8a3b_sid=I06893; NO6v_8a3b_checkpm=1; NO6v_8a3b_lastact=1433669733%09plugin.php%09; NO6v_8a3b_connect_is_bind=0; NO6v_8a3b_dsu_amuppered=253223; NO6v_8a3b_dsu_amupper=DQo8c3R5bGU%2BDQoucHBlcndibSB7cGFkZGluZzo2cHggMTJweDtib3JkZXI6MXB4IHNvbGlkICNDRENEQ0Q7YmFja2dyb3VuZDojRjJGMkYyO2xpbmUtaGVpZ2h0OjEuOGVtO2NvbG9yOiMwMDMzMDA7d2lkdGg6MjAwcHg7b3ZlcmZsb3c6aGlkZGVufQ0KLnBwZXJ3Ym0gLnRpbWVze2NvbG9yOiNmZjk5MDA7fQ0KLnBwZXJ3Ym0gIGF7ZmxvYXQ6cmlnaHQ7Y29sb3I6I2ZmMzMwMDt0ZXh0LWRlY29yYXRpb246bm9uZX0NCjwvc3R5bGU%2BDQoNCjxkaXYgY2xhc3M9InBwZXJ3Ym0iIGlkPSJwcGVyd2JfbWVudSIgc3R5bGU9ImRpc3BsYXk6IG5vbmUiID4NCg0KPHN0cm9uZz7A27zGx6m1vTxzcGFuIGNsYXNzPSJ0aW1lcyI%2BMjQ8L3NwYW4%2BtM48L3N0cm9uZz48YnI%2BDQoNCjxBIEhSRUY9ImZvcnVtLnBocD9tb2Q9dmlld3RocmVhZCZhbXA7dGlkPTE2MTQ0MCZhbXA7YXV0aG9yaWQ9MjUzMjIzIiB0YXJnZXQ9Il9ibGFuayI%2Bsum%2FtMeptb272Mz7PC9BPg0KDQo8c3Ryb25nPsGs0PjHqbW9PHNwYW4gY2xhc3M9InRpbWVzIj43PC9zcGFuPrTOPC9zdHJvbmc%2BPGJyPg0KDQo8c3Ryb25nPsnPtM7HqbW9OiA8c3BhbiBjbGFzcz0idGltZXMiPjIwMTUtMDYtMDcgMTA6Mjc6NDg8L3NwYW4%2BPC9zdHJvbmc%2BDQo8L2Rpdj4NCg%3D%3D";
		try {
			// 发送 POST 请求
			String content = PostLogin.sendPost(url, params, cookie);
			System.out.println("succ!");
		} catch (Exception e) {
		}
	}
}
