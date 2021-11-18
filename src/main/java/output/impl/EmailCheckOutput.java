package output.impl;

import exeption.OutputException;
import output.CheckOutput;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static constant.Constants.*;

public class EmailCheckOutput implements CheckOutput {
    private String to;

    public EmailCheckOutput(String to) {
        this.to = to;
    }

    @Override
    public void output(String check) throws OutputException {
        if (to.equals(NO)) {
            return;
        }
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        try {
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(EMAIL_NAME, EMAIL_PASSWORD);
                        }
                    });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_FROM));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Check " + new SimpleDateFormat(DATE_REG).format(new Date()));
            message.setText(check);

            Transport.send(message);
        } catch (javax.mail.MessagingException e) {
            throw new OutputException(e);
        }
    }
}
