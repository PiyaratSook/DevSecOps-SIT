package helper;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
  
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {
    public static void sendEmail(String host, String port,
            final String senderEmail, String senderName, final String password,
            String recipientEmail, String subject, String message) throws AddressException,
            MessagingException, UnsupportedEncodingException {
  
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", host);

        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        };
  
        Session session = Session.getInstance(properties, auth);
  
        Message msg = new MimeMessage(session);
  
        msg.setFrom(new InternetAddress(senderEmail, senderName));
        InternetAddress[] toAddresses = { new InternetAddress(recipientEmail) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setContent(message, "text/html");
  
        Transport.send(msg);
  
    }
}