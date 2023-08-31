package mailV.MailK;

import java.io.File;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Appmail {

	public static void main(String args[]) {
		System.out.println("preparing to send message");
		String message="moshi mosh";
		String subject="ore wa Monkey D Luffy kaizouku orewa ni naru otokoda";
		String to="paprasad.8.66@gmail.com";
		String from="kulkarnivinayak2000@gmail.com";
		
		SendEmail(message, subject, to, from);
		SendAttach(message,subject, to, from);
	}
	

	private static void SendAttach(String message, String subject, String to, String from) {
		String host="smtp.gmail.com";
		
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES="+properties);
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
	Session session=Session.getInstance(properties, new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("kulkarnivinayak2000@gmail.com","jirycligqomxbczq");
		}
	})	;
	try {
	session.setDebug(true);
	MimeMessage m = new MimeMessage(session);
	m.setFrom(from);
	m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	m.setSubject(subject);
	//attachment
	String path="C:\\Users\\KULKARNI\\OneDrive\\Pictures\\wallpaper\\532559.jpg";
	
	MimeMultipart mimeMultipart = new MimeMultipart();
	MimeBodyPart textMime = new MimeBodyPart();
	MimeBodyPart fileMime = new MimeBodyPart();
	
	try {
		textMime.setText(message);
		File file=new File(path);
		fileMime.attachFile(file);
		
		mimeMultipart.addBodyPart(textMime);
		mimeMultipart.addBodyPart(fileMime);
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	m.setContent(mimeMultipart);
	Transport.send(m);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	System.out.println("Sent Success");
	}


	private static void SendEmail(String message, String subject, String to, String from) {
		String host="smtp.gmail.com";
		
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES="+properties);
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
	Session session=Session.getInstance(properties, new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("kulkarnivinayak2000@gmail.com","jirycligqomxbczq");
		}
	})	;
	try {
	session.setDebug(true);
	MimeMessage m = new MimeMessage(session);
	m.setFrom(from);
	m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	m.setSubject(subject);
	m.setText(message);
	Transport.send(m);
	System.out.println("send success");

	}
	catch(Exception e) {
		e.printStackTrace();
		
	}
}
}
