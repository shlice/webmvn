package org.eu.slice.util;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

//import org.junit.org.eu.slice.kgtest.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MySinaMail {

	/**
	 * 用spring mail 发送邮件,依赖jar：spring.jar，activation.jar，mail.jar
	 */
	public static void sendFileMail(String toEmail, String title, String content)
			throws MessagingException {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

		// 设定mail server
		senderImpl.setHost("smtp.sina.com");
		senderImpl.setUsername("s_ld@sina.com");
		senderImpl.setPassword("Ems123456");
		// 建立HTML邮件消息
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		// true表示开始附件模式
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,
				true, "utf-8");

		// 设置收件人，寄件人
		messageHelper.setTo(toEmail);
		messageHelper.setFrom("s_ld@sina.com");
		messageHelper.setSubject(title);
		// true 表示启动HTML格式的邮件
		messageHelper.setText(content, true);

		// FileSystemResource file1 = new FileSystemResource(new File(
		// "d:/logo.jpg"));
		// FileSystemResource file2 = new FileSystemResource(new
		// File("d:/读书.txt"));
		// // 添加2个附件
		// messageHelper.addAttachment("logo.jpg", file1);

		// try {
		// // 附件名有中文可能出现乱码
		// messageHelper
		// .addAttachment(MimeUtility.encodeWord("读书.txt"), file2);
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// throw new MessagingException();
		// }
		// 发送邮件
		senderImpl.send(mailMessage);
		//System.out.println("邮件发送成功.....");
	}

	public void sendTest() {
		try {
			MySinaMail.sendFileMail("licesh@gmail.com", "测试邮件", "<html><head></head><body><h1>你好：附件！！</h1></body></html>");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
