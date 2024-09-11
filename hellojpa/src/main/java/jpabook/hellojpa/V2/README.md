```
Hibernate: 
    /* insert for
        jpabook.hellojpa.V2.TeamV2 */insert 
    into
        TeamV2 (name, team_id) 
    values
        (?, ?)
Hibernate: 
    /* insert for
        jpabook.hellojpa.V2.MemberV2 */insert 
    into
        MemberV2 (team_id, username, member_id) 
    values
        (?, ?, ?)
Hibernate: 
    select
        mv1_0.member_id,
        mv1_0.team_id,
        mv1_0.username 
    from
        MemberV2 mv1_0 
    where
        mv1_0.member_id=?
m = class jpabook.hellojpa.V2.TeamV2$HibernateProxy$RTYD6COk
=====================================
Hibernate: 
    select
        tv1_0.team_id,
        tv1_0.name 
    from
        TeamV2 tv1_0 
    where
        tv1_0.team_id=?
=====================================
```