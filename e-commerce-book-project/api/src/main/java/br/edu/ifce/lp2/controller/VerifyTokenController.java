package br.edu.ifce.lp2.controller;

import br.edu.ifce.lp2.core.port.driven.VerifyJWTPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/tokens")
@RestController
@RequiredArgsConstructor
public class VerifyTokenController {

    private final VerifyJWTPort verifyJWTPort;
    private final HttpServletRequest http;

    @GetMapping
    public boolean post(@RequestParam String token) {
        var userAgent = http.getHeader("User-Agent");
        return verifyJWTPort.execute(token, userAgent);
    }

}
