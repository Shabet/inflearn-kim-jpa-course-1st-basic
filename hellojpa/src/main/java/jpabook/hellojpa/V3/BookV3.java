package jpabook.hellojpa.V3;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class BookV3 extends ItemV3 {

    private String author;
    private String isbn;
}
