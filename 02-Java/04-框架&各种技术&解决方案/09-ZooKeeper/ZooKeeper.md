## 注册中心Zookeeper
### Zookeeper 介绍
    1. 官方推荐使用 zookeeper 注册中心。注册中心负责服务地址的注册与查找，相当于目录服务，服务提供者和消费者只在启动时与注册中心交互，注册中心不转发请求，压力较小。
    2. Zookeeper 是 Apacahe Hadoop 的子项目，是一个树型的目录服务，支持变更推送，适合作为Dubbox 服务的注册中心，工业强度较高，可用于生产环境。

### Zookeeper 在Linux系统的安装
#### 安装步骤
    1. 安装 jdk（此步省略，我给大家提供的镜像已经安装好JDK）
    2. 把 zookeeper 的压缩包上传到 linux 系统。
    3. 解压缩压缩包
        tar -zxvf zookeeper-3.4.6.tar.gz
    4. 进入 zookeeper-3.4.6 目录，创建 data 文件夹。
        mkdir data
    5. 进入conf目录 ，把 zoo_sample.cfg 改名为 zoo.cfg
        cd conf
        mv zoo_sample.cfg zoo.cfg
    6. 打开zoo.cfg ,  修改 data 属性：dataDir=/root/zookeeper-3.4.6/data

### Zookeeper 服务启动
    1. 进入bin目录，启动服务输入命令
        ./zkServer.sh start
        输出以下内容表示启动成功
![image](https://github.com/AtomRun/notes/blob/master/noteimages/%E6%A1%86%E6%9E%B6%26%E5%90%84%E7%A7%8D%E6%8A%80%E6%9C%AFimages/2.png)
    2. 关闭服务输入命令
        ./zkServer.sh stop
![image](https://github.com/AtomRun/notes/blob/master/noteimages/%E6%A1%86%E6%9E%B6%26%E5%90%84%E7%A7%8D%E6%8A%80%E6%9C%AFimages/3.png)
    3. 查看状态：
        ./zkServer.sh status
        如果启动状态，提示
![image](https://github.com/AtomRun/notes/blob/master/noteimages/%E6%A1%86%E6%9E%B6%26%E5%90%84%E7%A7%8D%E6%8A%80%E6%9C%AFimages/4.png)
        如果未启动状态，提示：
![image](https://github.com/AtomRun/notes/blob/master/noteimages/%E6%A1%86%E6%9E%B6%26%E5%90%84%E7%A7%8D%E6%8A%80%E6%9C%AFimages/4.5.png)

### Zookeeper简介
1. 什么是Zookeeper?
   1. Zookeeper是一个高效的分布式协调服务,它暴露了一些公用服务，比如命名/配置管理/同步控制/群组服务等。我们可以使用ZK来实现比如达成共识/集群管理/leader选举等。
   2. Zookeeper是一一个高可用的分布式管理与协调框架，基于ZAB算法(原子消息广播协议)的实现。该框架能够很好地保证分布式环境中数据的一致性。也正是基于这样的特性，使得Zookeeper成为 了解决分布式一致性问题的利器。
   3. 顺序-致性:从一个客户端发起的事务请求，最终将会严格地按照其发起的顺序被应用到zookeeper中去。
   4. 原子性: 所有事务请求的处理结果在整个集群中所有机器上的应用情况是一致的，也就是说，要么整个集群所有的机器都成功应用了某一事务， 要么有没有应用，一定不会出现部分机器应用了该事务，而另一部分没有应用的情况。
   5. 单一 视图:无论客户端连接的是哪一个zookeeper服务器，其看到的服务器端数据模型都是一致的。
   6. 可靠性: 一旦服务器成功地应用了-个事务，并完成对客户端的响应，那么该事务所引起的服务器端状态将会被一致保留 下来。除非有另外一个事务对其更改。
   7. 实时性: 通常所说的实时性就是指一-旦事务被成功应用，那么客户端就能立刻从服务器上获取变更后的新数据，zookeeper仅 仅能保证在一段时间内， 客户端最终一定能从服务器端读取最新的数据状态。

