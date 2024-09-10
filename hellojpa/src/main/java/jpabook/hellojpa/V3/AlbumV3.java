package jpabook.hellojpa.V3;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class AlbumV3 extends ItemV3 {

    private String artist;
}
