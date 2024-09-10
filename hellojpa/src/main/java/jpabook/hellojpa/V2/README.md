```
Hibernate: 
    /* insert for
        jpabook.hellojpa.V2.MovieV2 */insert 
    into
        ItemV2 (name, price, id) 
    values
        (?, ?, ?)
Hibernate: 
    /* insert for
        jpabook.hellojpa.V2.MovieV2 */insert 
    into
        MovieV2 (actor, director, id) 
    values
        (?, ?, ?)
Hibernate: 
    select
        mv1_0.id,
        mv1_1.name,
        mv1_1.price,
        mv1_0.actor,
        mv1_0.director 
    from
        MovieV2 mv1_0 
    join
        ItemV2 mv1_1 
            on mv1_0.id=mv1_1.id 
    where
        mv1_0.id=?
```