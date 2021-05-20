package br.edu.ifce.lp2.controller;

import br.edu.ifce.lp2.controller.requests.LoginRequest;
import br.edu.ifce.lp2.core.port.driver.LoginPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginPort loginPort;

    @PostMapping
    public String post(@RequestBody LoginRequest request) {
        var client = request.toClient();

        return loginPort.execute(client.getEmail(), client.getPassword());
    }

}
