package br.edu.ifce.lp2.core.userstories;

import br.edu.ifce.lp2.core.domain.Client;
import br.edu.ifce.lp2.core.port.driven.ClientRepositoryPort;
import br.edu.ifce.lp2.core.port.driver.CreateClientPort;
import br.edu.ifce.lp2.core.util.GenerateTokens;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateClientUS implements CreateClientPort {

    private final ClientRepositoryPort repository;

    @Override
    public Client execute(Client client) {

        if (repository.existsByEmail(client.getEmail()))
            throw new IllegalArgumentException("User Already Exists");

        client.setToken(GenerateTokens.execute(6));

        // 2. Enviar o link para o email

        return repository.save(client);
    }

}
