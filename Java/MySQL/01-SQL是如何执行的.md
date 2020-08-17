# SQL是如何执行的

MySQL流程图如下

![](https://i.loli.net/2020/08/04/nFuT6JUOjxEvP4W.png)

MySQL由三层组成

1. 连接层：客户端和服务器端建立连接，客户端发送 SQL 至服务器端；
2. SQL 层：对 SQL 语句进行查询处理；
3. 存储引擎层：与数据库文件打交道，负责数据的存储和读取。