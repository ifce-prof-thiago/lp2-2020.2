package br.edu.ifce.lp2;

import br.edu.ifce.lp2.core.domain.Client;
import br.edu.ifce.lp2.core.port.driven.ClientRepositoryPort;
import br.edu.ifce.lp2.core.port.driven.GetClientLoggedPort;
import br.edu.ifce.lp2.core.port.driven.GetIdByClientLoggedPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.NoSuchElementException;

@Named
@RequiredArgsConstructor
public class GetClientLogged implements GetClientLoggedPort {

    private final GetIdByClientLoggedPort getIdByClientLoggedPort;
    private final ClientRepositoryPort repository;

    @Override
    public Client execute() {
        // TODO Otimizar a obtenção do usuário logado com o cache ou REDIS
        return repository.findById(getIdByClientLoggedPort.execute()).orElseThrow(() -> new NoSuchElementException("Usuário logado não existe"));
    }

}
