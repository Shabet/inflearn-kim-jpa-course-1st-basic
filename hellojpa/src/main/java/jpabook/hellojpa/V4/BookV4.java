package jpabook.hellojpa.V4;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class BookV4 extends ItemV4 {

    private String author;
    private String isbn;
}
