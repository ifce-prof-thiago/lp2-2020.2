package br.edu.ifce.lp2.controller;

import br.edu.ifce.lp2.controller.requests.LoginRequest;
import br.edu.ifce.lp2.controller.responses.TokenResponse;
import br.edu.ifce.lp2.core.port.driver.LoginPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/login")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginPort loginPort;
    private final HttpServletRequest http;

    @PostMapping
    public TokenResponse post(@RequestBody LoginRequest request) {

        var client = request.toClient();
        var userAgent = http.getHeader("User-Agent");
        var token = loginPort.execute(client.getEmail(), client.getPassword(), userAgent);

        return new TokenResponse(token);
    }

}
