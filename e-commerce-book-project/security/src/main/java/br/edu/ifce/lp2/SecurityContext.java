package br.edu.ifce.lp2;

import br.edu.ifce.lp2.core.domain.Client;
import br.edu.ifce.lp2.core.port.driven.ClientRepositoryPort;
import br.edu.ifce.lp2.core.port.driven.GetIdByUserLoggedPort;
import br.edu.ifce.lp2.core.port.driven.SecurityContextPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.NoSuchElementException;

@Named
@RequiredArgsConstructor
public class SecurityContext implements SecurityContextPort {

    private final GetIdByUserLoggedPort getIdByUserLoggedPort;
    private final ClientRepositoryPort repository;

    @Override
    public SecurityContextPort isAdmin() {

        var userLogged = repository.findById(getIdByUserLoggedPort.execute()).orElseThrow(() -> new NoSuchElementException("Usuário logado não existe"));

        if (!userLogged.getPermissions().contains(Client.Permission.ROLE_ADMIN)) {
            throw new IllegalArgumentException("User not is ADMIN");
        }

        return this;

    }

    @Override
    public SecurityContextPort isUser() {

        var userLogged = repository.findById(getIdByUserLoggedPort.execute()).orElseThrow(() -> new NoSuchElementException("Usuário logado não existe"));

        if (!userLogged.getPermissions().contains(Client.Permission.ROLE_USER)) {
            throw new IllegalArgumentException("User not is USER");
        }

        return this;

    }


}
