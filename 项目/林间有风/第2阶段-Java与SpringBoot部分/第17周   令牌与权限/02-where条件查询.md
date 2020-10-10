# where条件查询

1. 我们的删除是逻辑删除，只是放置了`delete_time`标识标志删除
2. 一条已经被删除的数据一定不能被删除，但是jpa仍然可以查询
3. 我们可以想到的是，就是写sql加上where条件，where delete_time = null
4. `@Where(clause = "delete_time is null and online = 1")`标注在实体上，那么对该实体的查询都会多一个where条件，并且查看online等于1

这样的方式很不方便，这属于硬编码并且，如果我们就是要查询下架的或者被删除的数据，就要写其他的代码。

 