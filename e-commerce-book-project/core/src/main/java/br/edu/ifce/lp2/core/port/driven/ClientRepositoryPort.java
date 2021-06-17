package br.edu.ifce.lp2.core.port.driven;

import br.edu.ifce.lp2.core.domain.Client;

import java.util.Optional;

public interface ClientRepositoryPort {

    Client save(Client client);

    boolean existsByEmail(String email);

    Optional<Client> findById(String id);

    Client findByEmail(String username);

    Client findByTokenValue(String value);

}
