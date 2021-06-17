package br.edu.ifce.lp2.core.port.driver;

import br.edu.ifce.lp2.core.domain.Client;

public interface UpdateClientPort {

    Client execute(String id, Client client);

}
