package br.edu.ifce.lp2.core.port.driven;

import br.edu.ifce.lp2.core.domain.Client;

public interface ClientRepositoryPort {

    Client save(Client client);

    boolean existsByEmail(String email);

    Client findByEmail(String username);

    Client findByTokenValue(String value);

}
