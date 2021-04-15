package br.edu.ifce.lp2.controller;

import br.edu.ifce.lp2.controller.requests.ClientRequest;
import br.edu.ifce.lp2.controller.responses.ClientResponse;
import br.edu.ifce.lp2.core.port.driver.CreateClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/clients")
@RestController
@RequiredArgsConstructor
public class ClientController {

    private final CreateClientPort createClientPort;

    @PostMapping
    public ClientResponse post(@RequestBody ClientRequest request) {
        var client = createClientPort.execute(request.toClient());
        return new ClientResponse(client);
    }

}
