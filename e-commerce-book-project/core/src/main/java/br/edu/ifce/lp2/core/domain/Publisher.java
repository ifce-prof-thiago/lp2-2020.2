package br.edu.ifce.lp2.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Publisher extends AbstractEntity {

    private String name;
    private String phone;

}
