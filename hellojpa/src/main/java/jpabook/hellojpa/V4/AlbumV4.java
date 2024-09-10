package jpabook.hellojpa.V4;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class AlbumV4 extends ItemV4 {

    private String artist;
}
