package jpabook.hellojpa.V1;

import jakarta.persistence.Entity;

@Entity
public class BookV1 extends ItemV1 {

    private String author;
    private String isbn;
}
