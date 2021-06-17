package br.edu.ifce.lp2;

import br.edu.ifce.lp2.core.port.driven.SmtpSendEmailPort;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import javax.inject.Named;
import javax.mail.MessagingException;

@Named
@RequiredArgsConstructor
public class SmtpSendEmail implements SmtpSendEmailPort {

    private final JavaMailSender mailSender;

    @Async
    @Override
    public void execute(Message message) {

        var mime = mailSender.createMimeMessage();
        var helper = new MimeMessageHelper(mime, "UTF-8");

        try {
            System.out.println(message.getReceivers().toArray(new String[0]));

            helper.setFrom("LP II <noresponse@lp2.ifce.edu.br>");
            helper.setTo(message.getReceivers().toArray(new String[0]));
            helper.setSubject(message.getSubject());
            helper.setText("<b>" + message.getBody() + "</b>", true);

            mailSender.send(mime);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
