package com.segware.upvote.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post  extends AbstractEntity implements Serializable {

    @NotBlank
    private String texto;

    @NotNull
    private Integer voto = 0;

    public void adicionarVoto() {
        this.voto++;
    }

    public void removerVoto() {
        this.voto--;
    }
}
