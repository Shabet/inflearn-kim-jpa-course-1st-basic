package jpabook.jpashop.domain;

import jakarta.persistence.Entity;

@Entity
public class Movie extends Item {

    private String diretor;
    private String actor;

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
