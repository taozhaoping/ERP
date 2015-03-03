package com.zh.base.util;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

/**
 * 邮件工具
 * @author zxj 2014-4-24 下午4:14:53
 * 
 */
public class MailUtil {

	private static String SMTPSERVER = "mail.smtpServer";
	private static String USERNAME = "mail.username";
	private static String PASSWORD = "mail.password"; 
	private static String FROMEMAIL = "mail.fromEmail"; 
	private static String ISAUTH = "mail.isAuth"; 
	
	
	static {
		PropertyResourceBundle prb = (PropertyResourceBundle) PropertyResourceBundle.getBundle("jdbc");
		
		SMTPSERVER = prb.getString(SMTPSERVER);
		USERNAME = prb.getString(USERNAME);
		PASSWORD = prb.getString(PASSWORD);
		FROMEMAIL = prb.getString(FROMEMAIL);
		ISAUTH = prb.getString(ISAUTH);
		
	}
	
	/**
	 * @param mail
	 * @return
	 */
	public static String getMails(List<String> mail) {
		if (mail == null || mail.isEmpty())
			return null;
		StringBuilder sb = new StringBuilder();
		int size = mail.size();
		for (int i = 0; i < size; i++) {
			sb.append(mail.get(i));
			if (i != (size - 1)) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	/**
	 * 发送邮件
	 * @param toEmail_TO 主送
	 * @param toEmail_CC 抄送
	 * @param subject
	 * @param text
	 * @throws MessagingException
	 * @throws UnsupportedEncodingException 
	 */
	public static void sendMail(String toEmail_TO, String toEmail_CC, String subject,
			String text) throws MessagingException, UnsupportedEncodingException {
		final String username = USERNAME; // 发件人的邮件帐户
		final String password = PASSWORD; // 发件人的邮件密码

		// 创建Properties 对象
		Properties props = System.getProperties();

		// 添加smtp服务器属性
		props.put("mail.smtp.host", SMTPSERVER);
		
		props.put("mail.smtp.auth", ISAUTH); // 163的smtp不是免费的也不公用的，需要验证

		// 创建邮件会话
		Session session = Session.getInstance(props, new Authenticator() { // 验账账户
					public PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		String args_to[] = toEmail_TO.split(",");

		InternetAddress[] adds_to = new InternetAddress[args_to.length];
		for (int i = 0; i < args_to.length; i++) {
			adds_to[i] = new InternetAddress(args_to[i].trim());
		}
		
		toEmail_CC = toEmail_CC == null ? "" : toEmail_CC;
		String args_cc[] = toEmail_CC.split(",");
		if ("".equals(toEmail_CC)) {
			args_cc = new String[0];
		}

		InternetAddress[] adds_cc = new InternetAddress[args_cc.length];
		for (int i = 0; i < args_cc.length; i++) {
			adds_cc[i] = new InternetAddress(args_cc[i].trim());
		}

		// 定义邮件信息
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(FROMEMAIL));
		message.addRecipients(Message.RecipientType.TO, adds_to);
		message.setSentDate(new java.util.Date());
		message.setSubject(MimeUtility.encodeText(subject,"utf-8","B"));
		message.setContent(text, "text/html;charset=utf-8");
		
		// 抄送人员不存在则不抄送
		if (null != adds_cc && adds_cc.length > 0) {
			message.addRecipients(Message.RecipientType.CC, adds_cc);
		}

		//message.setSubject(subject);
		//message.setText(text);

		// 发送消息
		// session.getTransport("smtp").send(message); //也可以这样创建Transport对象
		Transport.send(message);
	}
	
	/**
	 * 是否是合法邮箱地址
	 * @param str
	 * @return
	 */
	public static boolean isMailAddress(String str) {
		boolean result = false;
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher = pattern.matcher(str);
		result = matcher.matches();
		return result;
	}
	
	
}
