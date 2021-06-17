package br.edu.ifce.lp2.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class AbstractEntity {

    private String id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy;

    @Version
    private int version;

}
