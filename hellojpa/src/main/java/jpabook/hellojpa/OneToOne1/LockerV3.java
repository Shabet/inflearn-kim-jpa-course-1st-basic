package jpabook.hellojpa.OneToOne1;

import jakarta.persistence.*;

@Entity
@Table(name = "locker")
public class LockerV3 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
