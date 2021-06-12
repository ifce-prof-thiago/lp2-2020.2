package br.edu.ifce.lp2.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

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

    private Set<Permission> permissions = new HashSet<>();

    public enum Permission {
        ROLE_ADMIN,
        ROLE_USER
    }

}
