package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Properties;

public interface MailTools {

    String SEND_MAIL_USER="2738397224@qq.com";
    String SEND_MAIL_PASSWORD="hnrepsskhdgqdgjh";
    String RECEIVE_MAIL_USER="rred@vip.qq.com";

    static void sendMessages(@NotNull String title,@NotNull String content){
        try {
            Properties properties=new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.host", "smtp.qq.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.user", SEND_MAIL_USER);
            properties.put("mail.password", SEND_MAIL_PASSWORD);
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(properties.getProperty("mail.user"), properties.getProperty("mail.password"));
                }
            };
            Session mailSession = Session.getInstance(properties, authenticator);
            MimeMessage message = new MimeMessage(mailSession);
            InternetAddress form = new InternetAddress(properties.getProperty("mail.user"));
            message.setFrom(form);
            InternetAddress to = new InternetAddress(RECEIVE_MAIL_USER);
            message.setRecipient(MimeMessage.RecipientType.TO, to);
            message.setSubject(title);
            message.setSentDate(new Date());
            message.setContent(content, "text/html;charset=UTF-8");
            Transport.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
