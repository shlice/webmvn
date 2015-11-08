package org.eu.slice.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.mail.MessagingException;

import org.eu.slice.util.MySinaMail;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/***
 * 采用Jsoup发送请求，解析html
 * 
 * @author shild
 * 
 */
public class AmazonJob implements Job {
	private static Logger logger = LoggerFactory.getLogger(AmazonJob.class);

	public AmazonJob() {
	}

	public static interface AmazonItem {
		String getName();

		void setName(String name);

		String getEmail();

		void setEmail(String email);

		String getUrl();

		void setUrl(String url);

		float getPrice();

		void setPrice(float price);
	}

	public static List<AmazonItem> readItemsFromFile() {
		String content = "";
		try {
			// 定义BufferedReader输入流来读取URL的响应
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream(AmazonJob.class.getResource("/")
							.getPath() + "amazonitems.json")));
			String line;

			while ((line = in.readLine()) != null) {
				content += line;
			}

            in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<AmazonItem> list = new ArrayList<AmazonItem>();

		try {
			JSONObject jsonObj = JSON.parseObject(content);
			JSONArray items = jsonObj.getJSONArray("items");
			for (int i = 0; i < items.size(); i++) {
				AmazonItem item = items.getObject(i, AmazonItem.class);
				list.add(item);
			}
		} catch (Exception e) {
			logger.error("cannot parse amazon items config json string!");
		}

		return list;
	}

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		logger.info("do amazon job");

		List<AmazonItem> items;
		if (context != null)
			items = (List<AmazonItem>) context.getJobDetail().getJobDataMap()
					.get("items");
		else
			items = readItemsFromFile();

		for (AmazonItem item : items) {
			Document doc;
			String text = "";
			try {
				doc = Jsoup.connect(item.getUrl()).userAgent("Mozilla")
						.cookies(AmazonJob.transStringToMap("")).timeout(10000)
						.get();

				Element body = doc.select("span#priceblock_ourprice").first();
				if (body == null)
					continue;

				text = body.text();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
			if (text.isEmpty())
				continue;

			if (text.contains("$"))
				text = text.substring(1);

			float price = Float.parseFloat(text);
			if (price != item.getPrice()) {
				if (item.getPrice() == -1) {
					// do nothing
				} else if (price < item.getPrice()) {
					logger.info("get lower price: " + price);
					// send email
					String content = "<html><body><h3>New Price Is: " + price
							+ "<br />Last Price Is: " + item.getPrice()
							+ "</h3></body></html>";
					try {
						MySinaMail.sendFileMail(item.getEmail(),
								"Lower Price! - [" + item.getName() + "]",
								content);
						logger.info("send email to: " + item.getEmail()
								+ " success.");
					} catch (MessagingException me) {
						logger.error("send mail error" + me.getMessage());
					}
				} else {
					logger.info("get higer price: " + price);
				}

				// update jobdatamap
				item.setPrice(price);
			}
		}
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
			String key = items.nextToken();
			String value = items.hasMoreTokens() ? ((String) (items.nextToken()))
					: null;
			map.put(key, value);
		}

		return map;
	}

	public static void main(String[] args) throws Exception {
		AmazonJob job = new AmazonJob();
		job.execute(null);
	}
}
