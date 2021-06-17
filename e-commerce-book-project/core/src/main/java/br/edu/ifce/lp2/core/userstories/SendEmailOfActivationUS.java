package br.edu.ifce.lp2.core.userstories;

import br.edu.ifce.lp2.core.domain.Client;
import br.edu.ifce.lp2.core.port.driven.SmtpSendEmailPort;
import br.edu.ifce.lp2.core.port.driver.SendEmailOfActivationPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.Set;

@Named
@RequiredArgsConstructor
public class SendEmailOfActivationUS implements SendEmailOfActivationPort {

    private final SmtpSendEmailPort emailPort;

    @Override
    public void execute(Client client) {
        var message = new SmtpSendEmailPort.Message();
        message.setReceivers(Set.of("lp2.ifce@gmail.com", client.getEmail()));
        message.setBody("Link: localhost:8080/clients/check-by?token=" + client.getToken().getValue());
        message.setSubject("Lp2 <noresponse@gmail.com>");

        emailPort.execute(message);
    }

}
