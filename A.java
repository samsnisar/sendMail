import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class A {
public static void main(String[] args) {
		
		final String fromEmail="#@gmail.com";
		final String password="#";
		final String toEmail="#@gmail.com";
		
		Properties props=new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		Authenticator auth=new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
				
			}
			};
			Session session=Session.getInstance(props, auth);
			
			MimeMessage message=new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress(fromEmail));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
				
				message.setSubject("#");
				message.setText("hello");
				
				
				
				Transport.send(message);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			
	}

}
