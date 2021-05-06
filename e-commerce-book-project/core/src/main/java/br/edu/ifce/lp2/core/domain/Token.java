package br.edu.ifce.lp2.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Token {

    private String value;
    private LocalDateTime expireAt;

    public Token() {
        this.expireAt = LocalDateTime.now().plusDays(1);
    }

    public boolean hasExpired() {
        return expireAt.isBefore(LocalDateTime.now());
    }

    public boolean notHasExpired() {
        return !hasExpired();
    }

}
