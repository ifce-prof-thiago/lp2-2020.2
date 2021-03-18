package br.edu.ifce.lp2.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hello {

    private String msg;

    public void print() {
        System.out.println(msg);
    }
}
