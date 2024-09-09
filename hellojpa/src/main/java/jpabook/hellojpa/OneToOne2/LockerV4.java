package jpabook.hellojpa.OneToOne2;

import jakarta.persistence.*;

@Entity
@Table(name = "locker")
public class LockerV4 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // 추가
    @OneToOne(mappedBy = "locker")
    private MemberV4 member;

    public void setName(String name) {
        this.name = name;
    }

    public MemberV4 getMember() {
        return member;
    }

    public String getName() {
        return name;
    }

    public void setMember(MemberV4 member) {
        this.member = member;
    }
}
