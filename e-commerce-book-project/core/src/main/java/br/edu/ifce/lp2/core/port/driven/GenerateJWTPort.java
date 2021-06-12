package br.edu.ifce.lp2.core.port.driven;

import br.edu.ifce.lp2.core.domain.Client;

public interface GenerateJWTPort {
    String execute(Client client, String fingerprint);
}