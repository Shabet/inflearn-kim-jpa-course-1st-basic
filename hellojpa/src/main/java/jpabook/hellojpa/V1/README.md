```
Hibernate: 
    /* insert for
        jpabook.hellojpa.V1.MovieV1 */insert 
    into
        ItemV1 (name, price, actor, director, DTYPE, id) 
    values
        (?, ?, ?, ?, 'MovieV1', ?)
Hibernate: 
    select
        mv1_0.id,
        mv1_0.name,
        mv1_0.price,
        mv1_0.actor,
        mv1_0.director 
    from
        ItemV1 mv1_0 
    where
        mv1_0.DTYPE='MovieV1' 
        and mv1_0.id=?
```