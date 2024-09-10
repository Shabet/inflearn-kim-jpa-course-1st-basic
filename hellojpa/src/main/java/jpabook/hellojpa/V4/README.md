```
Hibernate: 
    /* insert for
        jpabook.hellojpa.V4.MovieV4 */insert 
    into
        MovieV4 (name, price, actor, director, id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    select
        mv1_0.id,
        mv1_0.name,
        mv1_0.price,
        mv1_0.actor,
        mv1_0.director 
    from
        MovieV4 mv1_0 
    where
        mv1_0.id=?
```