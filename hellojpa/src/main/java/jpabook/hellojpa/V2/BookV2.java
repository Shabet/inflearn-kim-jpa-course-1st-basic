package jpabook.hellojpa.V2;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
public class BookV2 extends ItemV2 {

    private String author;
    private String isbn;
}
