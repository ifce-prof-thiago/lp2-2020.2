package br.edu.ifce.lp2.controller;

import br.edu.ifce.lp2.controller.requests.ClientRequest;
import br.edu.ifce.lp2.controller.responses.ClientResponse;
import br.edu.ifce.lp2.core.port.driver.CreateClientPort;
import br.edu.ifce.lp2.core.port.driver.EnableOrDisableClientByIdPort;
import br.edu.ifce.lp2.core.port.driver.EnableClientByTokenPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/clients")
@RestController
@RequiredArgsConstructor
public class ClientController {

    private final CreateClientPort createClientPort;
    private final EnableClientByTokenPort enableClientByTokenPort;
    private final EnableOrDisableClientByIdPort enableClientByIdPort;

    @PostMapping
    public ClientResponse post(@RequestBody ClientRequest request) {
        var client = createClientPort.execute(request.toClient());
        return new ClientResponse(client);
    }

    @PatchMapping("check-by")
    public void checkByToken(@RequestParam String token) {
        enableClientByTokenPort.execute(token);
    }

    @PatchMapping("{id}/enable")
    public void enableById(@PathVariable("id") String id) {
        enableClientByIdPort.execute(id, true);
    }

    @PatchMapping("{id}/disable")
    public void disableById(@PathVariable("id") String id) {
        enableClientByIdPort.execute(id, false);
    }


}
