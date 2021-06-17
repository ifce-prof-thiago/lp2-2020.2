package br.edu.ifce.lp2.core.userstories;

import br.edu.ifce.lp2.core.port.driven.ClientRepositoryPort;
import br.edu.ifce.lp2.core.port.driven.SecurityContextPort;
import br.edu.ifce.lp2.core.port.driver.EnableOrDisableClientByIdPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.NoSuchElementException;

@Named
@RequiredArgsConstructor
public class EnableOrDisableClientByIdUS implements EnableOrDisableClientByIdPort {

    private final ClientRepositoryPort repository;
    private final SecurityContextPort securityContextPort;

    @Override
    public void execute(String id, boolean enable) {

        restrictions();

        var client = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));

        client.setEnabled(enable);

        repository.save(client);

    }

    private void restrictions() {
        if (securityContextPort.isNotAdmin() || securityContextPort.isNotEnabled())
            throw new IllegalArgumentException("Usuário não tem permissão para executar esta ação");
    }
}
