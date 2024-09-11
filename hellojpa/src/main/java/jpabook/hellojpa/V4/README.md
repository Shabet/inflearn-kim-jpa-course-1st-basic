```
Hibernate: 
    /* select
        m 
    from
        MemberV4 m */ select
            mv1_0.member_id,
            mv1_0.team_id,
            mv1_0.username 
        from
            MemberV4 mv1_0
Hibernate: 
    select
        tv1_0.team_id,
        tv1_0.name 
    from
        TeamV4 tv1_0 
    where
        tv1_0.team_id=?
Hibernate: 
    select
        tv1_0.team_id,
        tv1_0.name 
    from
        TeamV4 tv1_0 
    where
        tv1_0.team_id=?
```