package br.edu.ifce.lp2.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document
public class Todo {

    private String id;
    private String todo;
    private String description;
    private boolean completed;
    private Date createdAt;
    private Date updatedAt;

}
