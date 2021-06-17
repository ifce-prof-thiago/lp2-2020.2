package br.edu.ifce.lp2.controller.responses;

import br.edu.ifce.lp2.core.domain.Client;
import lombok.Getter;

@Getter
public class ClientResponse {

    private String id;

    public ClientResponse(Client client) {
        this.id = client.getId();
    }

}
