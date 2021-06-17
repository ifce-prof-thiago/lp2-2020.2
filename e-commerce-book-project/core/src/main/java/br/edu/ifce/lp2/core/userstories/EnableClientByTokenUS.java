package br.edu.ifce.lp2.core.userstories;

import br.edu.ifce.lp2.core.port.driven.ClientRepositoryPort;
import br.edu.ifce.lp2.core.port.driver.EnableClientByTokenPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class EnableClientByTokenUS implements EnableClientByTokenPort {

    private final ClientRepositoryPort repository;

    @Override
    public void execute(String token) {

        var client = repository.findByTokenValue(token);

        if (client != null && client.getToken().notHasExpired()) {
            client.setEnabled(true);
            client.setToken(null);
        }

        repository.save(client);

    }
}
