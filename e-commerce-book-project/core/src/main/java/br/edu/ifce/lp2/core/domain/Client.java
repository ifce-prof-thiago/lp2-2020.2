package br.edu.ifce.lp2.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Client {

    private String id;
    private String name;
    private String email;
    private String password;
    private Token token;
    private boolean enabled;

}
