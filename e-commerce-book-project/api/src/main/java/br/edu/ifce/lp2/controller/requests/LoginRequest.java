package br.edu.ifce.lp2.controller.requests;

import br.edu.ifce.lp2.core.domain.Client;
import lombok.Value;

@Value
public class LoginRequest {

    private String username;
    private String password;

    public Client toClient() {
        var client = new Client();

        client.setPassword(password);
        client.setEmail(username);

        return client;

    }

}
