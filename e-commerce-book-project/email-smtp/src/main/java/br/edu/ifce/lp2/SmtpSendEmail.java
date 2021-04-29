package br.edu.ifce.lp2;

import br.edu.ifce.lp2.core.port.driven.SmtpSendEmailPort;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;

import javax.inject.Named;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Named
@RequiredArgsConstructor
public class SmtpSendEmail implements SmtpSendEmailPort {

    private final JavaMailSender mailSender;

    @Override
    public void execute(Message message) {

        var props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");

        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

//        props.put("spring.mail.properties.mail.smtp.auth", true);
//        props.put("spring.mail.properties.mail.smtp.starttls.enable", true);
//        props.put("spring.mail.properties.mail.smtp.starttls.required", true);
//        props.put("spring.mail.properties.mail.smtp.ssl.enable", true);

        var session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("lp2.ifce@gmail.com",
                                "Abcd1234@");
                    }
                });

        try {

            var helper = new MimeMessage(session);
            helper.setFrom(new InternetAddress("lp2.ifce@gmail.com"));


            Address[] toUser = InternetAddress.parse("lp2.ifce@gmail.com, matheus.matias.viana07@aluno.ifce.edu.br");

            helper.setRecipients(MimeMessage.RecipientType.TO, toUser);
            helper.setSubject(message.getSubject());
            helper.setText(message.getBody());

            Transport.send(helper);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }


}
