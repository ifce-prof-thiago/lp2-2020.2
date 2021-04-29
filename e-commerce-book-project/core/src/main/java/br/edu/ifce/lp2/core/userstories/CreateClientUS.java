package br.edu.ifce.lp2.core.userstories;

import br.edu.ifce.lp2.core.domain.Client;
import br.edu.ifce.lp2.core.port.driven.ClientRepositoryPort;
import br.edu.ifce.lp2.core.port.driven.SmtpSendEmailPort;
import br.edu.ifce.lp2.core.port.driver.CreateClientPort;
import br.edu.ifce.lp2.core.util.GenerateTokens;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.Set;

@Named
@RequiredArgsConstructor
public class CreateClientUS implements CreateClientPort {

    private final ClientRepositoryPort repository;
    private final SmtpSendEmailPort emailPort;

    @Override
    public Client execute(Client client) {

        if (repository.existsByEmail(client.getEmail()))
            throw new IllegalArgumentException("User Already Exists");

        client.setToken(GenerateTokens.execute(6));

        client = repository.save(client);

        var message = new SmtpSendEmailPort.Message();
        message.setReceivers(Set.of("lp2.ifce@gmail.com", client.getEmail()));
        message.setBody("Link: localhost:8080/clients/check-by?token=" + client.getToken());
        message.setSubject("Lp2 <noresponse@gmail.com>");

        emailPort.execute(message);

        return client;
    }

}
