package br.edu.ifce.lp2.core.userstories;

import br.edu.ifce.lp2.core.domain.Client;
import br.edu.ifce.lp2.core.port.driver.UpdateClientPort;

import java.util.HashMap;

public class UpdateClientUS implements UpdateClientPort {

    private static HashMap<String, Client> repository;

    static {

        repository = new HashMap<>();

        repository.put("1", new Client());
        repository.put("2", new Client());
        repository.put("3", new Client());
        repository.put("4", new Client());

    }

    @Override
    public Client execute(String id, Client client) {
        var clientDatabase = repository.get(id);
        clientDatabase.setName(client.getName());

        return clientDatabase;
    }

}
