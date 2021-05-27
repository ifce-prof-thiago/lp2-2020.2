package br.edu.ifce.lp2.core.userstories;

import br.edu.ifce.lp2.core.port.driven.ClientRepositoryPort;
import br.edu.ifce.lp2.core.port.driven.GenerateJWTPort;
import br.edu.ifce.lp2.core.port.driver.LoginPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class LoginUs implements LoginPort {

    private final ClientRepositoryPort repository;
    private final GenerateJWTPort generateJWTPort;

    @Override
    public String execute(String username, String password, String fingerprint) {

        var client = repository.findByEmail(username);

        if (client == null || !client.getPassword().equals(password)) {
            throw new IllegalArgumentException("Usuário inválido!");
        }

        return generateJWTPort.execute(client, fingerprint);

    }
}
