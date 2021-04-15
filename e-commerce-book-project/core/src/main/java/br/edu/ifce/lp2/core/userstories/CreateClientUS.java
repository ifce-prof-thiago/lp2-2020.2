package br.edu.ifce.lp2.core.userstories;

import br.edu.ifce.lp2.core.domain.Client;
import br.edu.ifce.lp2.core.port.driven.ClientRepositoryPort;
import br.edu.ifce.lp2.core.port.driver.CreateClientPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class CreateClientUS implements CreateClientPort {

    private final ClientRepositoryPort repository;

    @Override
    public Client execute(Client client) {

        // 0. Verificar se o email já existe
        // 1. Gerar um link para habilitar o client
        // 2. Enviar o link para o email

        return repository.save(client);
    }

}
