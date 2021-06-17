package br.edu.ifce.lp2;

import br.edu.ifce.lp2.core.port.driven.GetClientLoggedPort;
import br.edu.ifce.lp2.core.port.driven.SecurityContextPort;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class SecurityContext implements SecurityContextPort {

    private final GetClientLoggedPort getClientLogged;

    @Override
    public boolean isAdmin() {
        return getClientLogged.execute().isAdmin();
    }

    @Override
    public boolean isUser() {
        return getClientLogged.execute().isUser();
    }

    @Override
    public boolean isEnabled() {
        return getClientLogged.execute().isEnabled();
    }

    @Override
    public boolean isNotAdmin() {
        return !isAdmin();
    }

    @Override
    public boolean isNotUser() {
        return !isUser();
    }

    @Override
    public boolean isNotEnabled() {
        return !isEnabled();
    }

}
