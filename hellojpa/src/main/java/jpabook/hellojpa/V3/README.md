```
Hibernate: 
    /* insert for
        jpabook.hellojpa.V3.MovieV3 */insert 
    into
        ItemV3 (name, price, DTYPE, id) 
    values
        (?, ?, 'MovieV3', ?)
Hibernate: 
    /* insert for
        jpabook.hellojpa.V3.MovieV3 */insert 
    into
        MovieV3 (actor, director, id) 
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
        MovieV3 mv1_0 
    join
        ItemV3 mv1_1 
            on mv1_0.id=mv1_1.id 
    where
        mv1_0.id=?
```