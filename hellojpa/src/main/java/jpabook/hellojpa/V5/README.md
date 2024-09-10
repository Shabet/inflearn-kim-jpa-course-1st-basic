```
Hibernate: 
    create table MemberV5 (
        createdDate timestamp(6),
        lastModifiedDate timestamp(6),
        member_id bigint not null,
        team_id bigint,
        insert_member varchar(255),
        update_member varchar(255),
        username varchar(255),
        primary key (member_id)
    )
Hibernate: 
    create table TeamV5 (
        createdDate timestamp(6),
        lastModifiedDate timestamp(6),
        team_id bigint not null,
        insert_member varchar(255),
        name varchar(255),
        update_member varchar(255),
        primary key (team_id)
    )
```