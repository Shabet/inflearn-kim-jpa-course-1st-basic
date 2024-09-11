```
Hibernate: 
    /* insert for
        jpabook.hellojpa.V3.TeamV3 */insert 
    into
        TeamV3 (name, team_id) 
    values
        (?, ?)
Hibernate: 
    /* insert for
        jpabook.hellojpa.V3.MemberV3 */insert 
    into
        MemberV3 (team_id, username, member_id) 
    values
        (?, ?, ?)
Hibernate: 
    select
        mv1_0.member_id,
        t1_0.team_id,
        t1_0.name,
        mv1_0.username 
    from
        MemberV3 mv1_0 
    left join
        TeamV3 t1_0 
            on t1_0.team_id=mv1_0.team_id 
    where
        mv1_0.member_id=?
m = class jpabook.hellojpa.V3.TeamV3
=====================================
teamName = teamA
=====================================
```