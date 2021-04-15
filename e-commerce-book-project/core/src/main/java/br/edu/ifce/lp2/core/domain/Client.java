package br.edu.ifce.lp2.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Client {

    private String id;
    private String name;
    private String email;
    private String password;
    private boolean enabled;

    @Indexed
    private ObjectId teste;

}
