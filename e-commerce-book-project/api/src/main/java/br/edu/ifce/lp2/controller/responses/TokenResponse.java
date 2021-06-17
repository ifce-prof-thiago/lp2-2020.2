package br.edu.ifce.lp2.controller.responses;


import lombok.Getter;

@Getter
public class TokenResponse {

    private String accessToken;

    public TokenResponse(String token) {
        this.accessToken = token;
    }
}
