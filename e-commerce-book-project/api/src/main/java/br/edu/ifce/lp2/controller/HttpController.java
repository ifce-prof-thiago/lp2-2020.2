package br.edu.ifce.lp2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("http")
@RestController
@RequiredArgsConstructor
public class HttpController {

    private final HttpServletRequest request;

    @GetMapping
    public void get() {
        String remoteIp = "";

        remoteIp = request.getHeader("X-FORWARDED-FOR");
        if (remoteIp == null || "".equals(remoteIp)) {
            remoteIp = request.getRemoteAddr();
        }

        System.out.println(remoteIp);
    }

}
