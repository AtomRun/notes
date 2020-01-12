## Redis

### 1. NoSQL简介
1. NoSQL泛指非关系型的数据库，NoSQL数据库的四大分类：
    1. 键值(key-value)存储数据库：这一类数据库主要会使用到哈希表，这个表中有一个特定的键和一个指针指向特定的数据，如redis、Voldemort、Oracle BDB
    2. 列存储数据库：这部分数据库通常是用来应对分布式存储的海量数据，键仍然存在，但是他们的特点是指向了多个列。如HBase、Riak
    3. 文档型数据库：该类型的数据模型是版本化的文档，半结构化的文档以特定的格式存储，比如JSON。文档型数据库可以看作是键值数据库的升级版，允许之间嵌套键值。而且文档数据库比键值数据库的查询效率更高。如：CouchDB,MongoDB
    4. 图形数据库：图形结构的数据库同其他行列以及刚性结构的SQL数据库不同，它是使用灵活的图形模型，并且能够扩展到多个服务器上。NoSQL数据库没有标准的查询语言(SQL)，因此进行数据库查询需要制定数据模型。许多NoSQL数据库都有REST式的数据接口或者查询API，如Neo4J,InfoGrid,Infinite Graph

### 2. 非关系型数据库的特点
1. 数据模型比较简单
2. 需要灵活性更强的IT系统
3. 对数据库性能要求较高
4. 不需要高度的数据一致性
5. 对于给定key，比较容易映射复杂值得环境 

### 3. Redis简介
1. 是以key-value形式存储，和传统的关系型数据库不一样，不一定遵循传统数据库的一些基本要求(非关系型的，分布式得，开源的，水平可扩展的)
2. 优点：
    1. 对数据高并发读写
    2. 对海量数据的高效率存储和访问
    3. 对数据得可扩展性和高可用性
3. 缺点：redis(ACID处理非常简单)
    1. 无法做到太复杂的关系数据库模型
4. Redis是以key-value sotre存储，data structure service 数据结构服务器。键可以包含：(String)字符串，哈希，(list)链表，(set)集合，(zset)有序集合。这些数据集合都支持push/pop、add/remove及取交集以及更丰富的操作，redis支持各种不同的方式排序。为了保证效率，数据都是缓存在内存中，他也可以周期性的把更新的数据写入磁盘或者修改操作写入追加到文件里

### 4. Redis Linux下的安装
1. 不做赘述，自行百度

### 5. String类型(一)
1. redis一共分为五种基本数据类型：String、Hash、List、Set、ZSet
2. String类型是包含很多类型的特殊类型，并且是二进制安全的。比如序列化的对象进行存储，比如一张图片进行二进制存储，比如一个简单的字符串，数值等等。
3. set和get方法
    1. 设置值 set name li 取值 get name (说明 设置name多次会覆盖)
    2. 删除值 del name
4. 使用setnx (not exist)
    1. bame如果不存在进行设置，存在就不需要进行设置了，返回0。
5. 使用setex (expired)
    1. setex color 10 red 设置color得有效期为10秒，10秒后返回nil(在redis里nil表示空)
6. 使用setrange 替换字符串
    1. set email 123124@qq.com
    2. setrange email 10 ww (10 表示从第几位开始替换，后面跟上替换的字符串)
    3. 
### 5. String类型(二)
1. 使用一次性设置和获取多个值得mest、mget方法
    1. mset key1 xxx key2 yyy key3 zzz； 对应的mget key1 key2 key3 方法
    2. 对应的也有msetnx 和mget方法
2. 一次性设置和取值的getset方法
    1. set key4 cc
    2. getset key4 changchun 返回旧的值并设置新的值的方法
3. incr和decr方法：对某一个值进行递增和递减
4. incrby和decrby方法：对某个值进行指定长度的递增和递减
5. append[name]方法：字符串追加方法
6. strlen[name]方法：获取字符串长度的方法

### 6.Hash类型
1. Hash类型是Strinhg类型的field和value映射表，或者说一个String集合。它的特别适合存储对象，相比较而言，将一个对象类型存储在Hash类型要比存储在String类型中占用更少的内存空间，并方便存取整个对象
2. 例如： hset myhash field1 hello(含义是hset是hash集合，myhash是集合名字 field1 是字段名 hello为其值) 使用hget myhash field1 获取内容，也可以存储多个值。hmset可以进行批量存储多个键值对：hmset myhash sex man addr beijing，也可使用hmget进行批量获取多个键值对。同样也有hsetnx 和setnx大同小异。
3. hincrby和hdecrby 集合递增和递减
4. hexists 是否存在key如果存在返回，不存在返回0
5. hlen 返回hash集合中所有的健数值
6. hdel 删除指定hash中的field
7. hkeys 返回hash中的所有字段
8. hvals 返回hash中的所有的value
9. hgetall 返回hash中所有的key和value

### 7. List类型(一)
1. List类型是一个链表结构的集合，其主要功能有push、pop、获取元素等。更详细地说，List类型是一个双端链表的结构，我们可以通过相关操作来进行集合的头部或者尾部添加删除元素，list的设计非常简单精巧，即可以做为栈，可以作为队列。满足绝大多数需求。
2. lpush方法：从头部加入元素(栈)先进后出
    1. 形如：lpush list1 "hello" lpush list1 "world"
    2. lrange list1 0 -1 (表示从头取到末尾)
3. rpush方法：从尾部加入元素(队列)先进先出
    1. 形如：rpush list2 "beijing" rpush list2 "sxt"
    2. lrange list2 0 -1
4. linsert方法：插入元素
    1. 形如：linsert list3 before [集合的元素][插入的元素]

### 8. List类型(二)
1. lset方法：将指定下标的元素替换掉
    1. lset list4 0 "b" 
2. lrem方法：删除元素，返回删除的个数
    1. lrem list4 2 "b"
    2. 2 是删除的个数，即删除2个"b"

### 9. List类型(三)
1. ltrim方法：保留指定key的值范围内的数据
    1. ltrim list6 2 3 
2. lpop方法：从list的头部删除元素，并返回删除的元素
    1. lpop list7
3. rpop方法：从list的尾部删除元素，并返回删除的元素
    1. rpop list7 

### 10. List类型(四)
1. rpoplpush方法：第一步从尾部删除元素，然后第二步从头部加入元素
2. index方法：返回名称为key的list中index位置的元素
    1. lindex list8 1
3. llen 方法：返回元素的个数
    1. llen list8

### 11. Set类型和Zset类型(一)
1. Set集合是String类型的无序集合，Set是通过hashtable实现的，对集合我们可以取交集，并集，差集
2. sadd 方法：向名称为key的set中添加元素
    1. 小结：set集合不允许重复元素 smembers查看set集合的元素
3. srem 方法：删除set集合元素
4. spop 方法：随机返回删除的key
5. sdiff 方法：返回两个集合的不同元素(哪个集合在前面就以哪个集合为标准)
6. sdiffstore方法：将返回的不同元素存储到另外一个集合中
    1. 小结：这里是把set1和set2的不同元素(以set1为准)存储到set3集合中

### 12. Set类型和Zset类型(二)
1. sinter 方法：返回集合的交集
    1. sinter set1 set2
2. sinterstroe 方法：返回交集结果，存入set3中
    1. sinterstroe set3 set1 set2
3. sunion 方法：取并集
    1. sunion set1 set2 
4. sunionstore 方法：取得并集，存入set3中
    1. sunionstore set3 set1 set2

### 13. Set类型和Zset类型(三)
1. smove 方法：从一个set集合移动到另一个set集合中
    1. 小结：将set1中的元素移动到set2中(相当于剪切赋值)
    2. smove set1 set2 a
2. scard 方法：查看集合中元素的个数
    1. scard set2 
3. sismember方法：判断某元素是否为集合中的元素
    1. 小结：返回1代表是集合中的元素，0则不是
4. srandmember方法：随即返回一个元素
    1. srandmember set2 a

### 14. Set类型和Zset类型(四)(重点)
1. zset在redis原有的set集合的基础上做了一个有顺序的调整，即增强版
2. zadd向有序集合中添加一个元素，该元素如果存在，则更新顺序
    1. 小结:在重复插入的时候，会根据顺序属性更新
    2. zadd zset1 5 five 
    3. [zadd 表示添加一个元素]
    4. [zset1 集合的名字]
    5. [5 序号，即在集合中的顺序]
    6. [five 值]
3. zrange zset1 0 -1 withscores 查看所有集合中的元素 withscores 将索引也展示出来
4. zset可以做一个数据的排行，与搜索引擎相结合

### 15. Set类型和Zset类型(五)
1. zrem删除名称为key的zset元素member
    1. zrem zset1 one
2. zincrby 以指定值取自动递增或者减少，用法和之前的incrby类似
3. zrangebyscore 找到指定区间范围的数据进行返回
4. zremrangebyrank 删除1到1(只删除索引1)
5. zremrangebyscore 删除指定序号

### 16. Set类型和Zset类型(六)
1. zrank 返回排序索引 从小到大排序(升序排序之后再找索引)
    1. 注意一个是顺序号，一个是索引 zrank返回的是索引
    2. zrank zset1 four
2. zrevrank 返回排序索引 从大到小排序(降序排序之后再找索引)
3. zrangebyscore zset1 2 3 withscores 找到指定区间范围的数据进行返回

### 17. Set类型和Zset类型(七)
1. zcard 返回集合中的所有元素的个数
    1. zrange zset1 0 -1 withscores
2. zcount 返回集合中score在给定区间内中的数量
    1. zcount zset1 0 -1 withscores

### 18. Set类型和Zset类型(八)
1. zremrangebyrank zset [from][to](删除索引)
    1. zremrangebyrank zset 0 1
2. zremrangebyscore zset[from][to](删除指定序号)
    1. zremrangebyscore zset 5 5 

### 19. Redis高级命令及特性(一)
1. 返回满足的所有键 keys* (刻意模糊匹配)
2. exists 是否存在指定的key
3. expire 设置某个key的过期时间，使用ttl查看剩余时间
4. persist 取消过期时间
5. select 选择数据库 数据库为0到15(一共1个数据库) 默认进入的是0数据库
6. move[key][数据库下标] 将当前数据中的key转移到其它数据库中
7. randomkey 随即返回数据库中的一个key
8. rename重命名key

### 20. Redis高级命令及特性(二)
1. echo 打印命令
2. dbsize 查看数据库中的key数量
3. info 获取数据库信息
4. config get 实时存储收到的请求(返回相关的配置信息)
    1. config get *
5. flushdb 清空当前数据库，flushall清空所有数据库

### 21. Redis的安全性
1. 因为redis速度相当快，所以在一台比较好的服务器下，一个外部用户在一秒内可以进行15W次的密码尝试，这意味着你需要设定非常强大的密码来防止暴力破解
2. vi编辑redis.conf文件 找到下面进行保存修改
    1. #requiorepass foobared
    2. requirepass **** 
3. 重启服务器pkill redis-server 
    1. 再次进入127.0.0.1:6379> keys * 
    2. (error)NOAUTH Authentication reqired.
    3. 会发现没有权限进行查询127.0.0.1:6379>auth xx
    4. OK 输入密码则成功进入
4. 每次进入的时候都要输入密码，还有种简单的方式： 
    1. 还有种方式是直接登陆授权的，[root@atom~]# /usr/local/redis/bin/redis-cli -a xxx

### 22. 主从复制
1. 主从复制：
    1. Master可以拥有多个slave
    2. 多个slave可以连接统一个Master外，还可以连接到去他的slave
    3. 主从复制不会阻塞master在同步数据时 master可以继续处理client请求
2. 主从复制过程：
    1. slave与master建立连接，发送sync同步命令
    2. master会开启一个后台进程，将数据库快照文件保存到文件中，同时master主进程会开始收集新的写命令并缓存
    3. 后台完成保存后就将文件发送给slave
3. 主从复制配置
    1. clone服务器之后修改slave的IP地址
    2. 修改配置文件：/usr/local/redis/etc/redis.conf
    3. 第一步：slaveof<masterip><masterport>
    4. 如果主服务器有密码还要设置下面的1选项即主服务器的密码
        1. 第二步: masterauth<master-password>
4. 使用info查看role角色即可知道是主服务还是从服务

### 23. 哨兵
1. 有了主从复制的实现之后，如果我们想对朱从服务器进行监控，那么在redis2.6之后提供了一个"哨兵"的机制，在2.6版本中的哨兵为1.0版本，并不稳定，会出现各种各样的问题，在2.8之后的版本哨兵功能才稳定起来
2. 顾名思义：哨兵的含义就是监控redis系统的运行状况，其主要功能有两点：
    1. 监控主数据库和从数据库是否正常运行
    2. 主数据库出现故障时，看可以自动将从数据库转换为主数据库，实现自动切换。
    3. 实现步骤：在其中一台从服务器配置sentinel.conf
        1. copy 文件sentinel.conf 到/usr/local/redis/etc 中
        2. 修改sentinel.conf文件：
            1. sentinel moniter mymaster 192.168.1.112 6379 1 # 名称、IP、端口、投票选举次数
            2. sentinel down-after-milliseconds mymaster 5000 # 默认1s检测一次，这里配置超时5000毫秒为宕机
            3. sentinel failover-timeout mymaster 900000
            4. sentinel parallel-syncs mymaster 2
            5. sentinel can-failover mymaster yes
        3. 启动sentinel哨兵
            1. /usr/local/redis/bin/redis-server /usr/local/redis/etc/sentinel.conf --sentinel & 
        4. 查看哨兵相关信息命令
            1. /usr/local/redis/bin/redis-cli -h 192.168.1.175 -p 26379 info Sentinel 
        5. 关闭主服务器查看集群信息
            1. /usr/local/redis/bin/redis-cli -h 192.168.1.174 -p 6379 shutdown 

### 24. Redis的简单事务(一)
1. redis的事务非常简单，使用方法如下
    1. 首先是使用multi方法打开事务，然后进行设置，这是设置的数据都会放入队列中进行保存，最后使用exec执行，把数据依次存储到redis中。使用discard方法取消事务
        1. multi
        2. set p1 1
        3. set p2 2 
        4. set p3 3
        5. exec 
    2. -----------
        1. multi 
        2. set p4 4 
        3. set p5 5 
        4. discard  [相当于回滚]

### 25. Redis的简单事务(二)
1. redis的事务不能保证同时成功或者失败进行提交或回滚，所以redis的事务目前还是比较简单的’

### 26. 持久化机制
1. redis是一个支持持久化的内存数据库，也就是说redis需要经常将内存中的数据同步到硬盘来保证持久化。
2. redis持久化的两种方式
    1. snapshotting(快照)默认方式，将内存中的数据以快照的方式写入到二进文件中，默认为dump.rdb。可以通过匹配置自动做快照持久化的方式。我们可以配置redis在n秒内如果超过m个key则自动做快照。
    2. snapshotting设置：
        1. save 900 1 # 900秒内如果超过1个key被修改，则发起快照保存
        2. save 300 10 # 300秒内如果超过10个key被修改，则发起快照保存
        3. save 60 10000
    3. append-only file(缩写)的方式，(有点类似于oracle日志)由于快照方式，是在一定时间间隔中做一次，所以可能发生redis意外down的情况就会丢失最后一次快照后所有修改的数据、aof比快照方式有更好的持久化性，是由于在使用aof时，redis会将每个收到的命令都通过write函数追加到命令中，当redis重新启动时会重新执行文件中保存的写命令来内存中重建这个数据库的内容，这个文件在bin目录下：appendonly.aof aof不是立即写到硬盘上，可以通过配置文件修改强制写到硬盘中。
    4. aof设置：
        1. appendonly yes //启动aof持久化方式 有三种修改方式：
            1. #appendfsync always //收到写命令就立即写入到磁盘，效率最慢，但是保证完全的持久化
            2. #appendfsync everysec //每秒钟写入磁盘一次，在性能和持久化方面做了很好的折中
            3. #appendfsync no //完全依赖os 性能最好 持久化没保证

### 27. 发布与订阅消息
1. redis提供了简单的发布订阅频道
2. shiyongsubscrible[频道]进行订阅监听
3. 使用publish[频道][发布内容]进行发布消息广播

### 28. 虚拟内存的使用
1. redis会暂时把不经常访问的数据从内存交换到磁盘中，腾出宝贵的空间，用于其他需要访问的数据，这需要对vm相关进行配置(3.0版本是不带VM特性的，配置无效！)
2. 修改配置文件：redis.conf
    1. vm-enabled yes #开启vm功能
    2. vm-swap-file /tmp/redis.swap #交换处理的value保存的文件路径
    3. vm-max-memory 1000000 #redis使用的最大内存上限
    4. vm-page-size 32 #每个页面的大小32个字节
    5. vm-pages 134217728 #最多使用多少页面
    6. vm-max-threads 4 #用于执行value对象换入缓存的工作线程数量
    7. 重新启动服务，会提示是否启用虚拟内存
    8. 把提示信息really-use-vm yes 粘贴到redis.conf中，粘贴到redis.conf下面即可，然后重新启动服务

### 29. Java$Redis
1. Jedis就是redis支持java的第三方类库，我们可以使用Jedis类库操作redis数据库。大体上在3.0之前，我们使用Jedis操作redis数据库的api比较全面，但是目前java第三方可用库更新比较慢，不太全面支持，目前最新的jedis2.7版本才支持集群操作，不过有些方法也不支持。

### 30. redis集群的搭建(一)
1. 在redis3.0以前，提供了Sentinel工具来监控各个Master的状态，如果Master异常，则会做主从切换，将Slave切换为Master,将master作为slave。其配置也是稍微的复杂，并且各方面表现一般，现在redis3.0已经支持集群的容错功能，并且非常简单。下面我们来进行学习redis3.0下如何搭建集群
2. 集群搭建：至少要三个master
3. 第一步：创建一个文件夹redis-cluster，然后再其下面分别创建6个文件夹如下：
    1. mkdir -p /usr/local/redis-cluster
    2. mkdir 7001、mkdir 7002、mkdir 7003、mkdir 7004、mkdir 7005、mkdir 7006
4. 第二步：把之前的redis.conf配置文件分别copy到700*下面，进行修改各个文件内容，也就是对700*下的每一个copy的redis.conf文件进行修改！如下：
    1. daemonize yes
    2. port 700*(分别对每个机器的端口号进行设置)
    3. bind 192.168.1.171(必须要绑定当前机器的ip!!!!!!!)
    4. dir /usr/local/redis-cluster/700*(指定数据文件存放位置，必须要指定不同的目录位置，不然会丢失数据，深坑勿入！)
    5. cluster-enabled yes(启动集群模式，开始玩耍)
    6. cluster-config-file nodes700*.conf(这里700x最好和port对应上)
    7. cluster-node-timeout 5000
    8. appendonly yes
5. 第三步：把修改后的配置文件，分别copy到各个文件夹下，注意每个文件要修改端口号，并且modes文件也要不相同！
6. 第四步：由于redis集群需要ruby命令，所以我们要安装ruby
    1. yum install ruby 
    2. yum install rubygems
    3. gem install redis (安装redis和ruby的接口)
7. 第五步：分别启动六个redis实例，然后检查启动是否成功
    1. usr/local/redis/bin/redis-server /usr/local/redis-cluster/700*/redis.conf
    2. ps -ef|grep redis
8. 第六步：首先到redis3.0的安装目录下，然后执行redis-trib.rb命令
    1. cd /usr/local/redis3.0/src
    2. ./redis-trib.rb create --replicas 1 192.168.1.171:7001 192.168.1.171:7002 192.168.1.171:7003 192.168.1.171:7004 192.168.1.171:7005 192.168.1.171:7006
9. 第七步：到此为止我们的集群搭建成功，进行验证：
    1. 连接至任意一个客户端即可：./redis-cli -c -h -p(-c表示集群模式，指定ip地址和端口号)如： /usr/local/redis/bin/redis-cli -c -h 192.168.1.171 -p 700*
    2. 进行验证：cluster info(查看集群信息)、cluster nodes(查看节点列表)
    3. 进行数据操作验证
    4. 关闭集群则需要逐个关闭，使用命令：
        1. usr/local/redis/bin/redis-cli -c -h 192.168.1.171 -p 700* shutdown
10. 第八步：(补充)
    1.  友情提示：当出现集群无法起动时，删除临时的数据文件，再次重新启动每一个redis服务，然后重新构造集群环境
    2.  redis-trib.rb 官方操作命令：http://redis.io/topics/cluster-tutorial
    3.  推荐博客：http://blog.51yip.com/nosql/1726.html/comment-page-1