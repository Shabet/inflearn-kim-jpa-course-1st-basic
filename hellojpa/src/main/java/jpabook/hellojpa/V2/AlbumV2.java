package jpabook.hellojpa.V2;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
public class AlbumV2 extends ItemV2 {

    private String artist;
}
