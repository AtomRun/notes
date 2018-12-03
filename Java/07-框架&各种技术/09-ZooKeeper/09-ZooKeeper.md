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
![image]()
        如果未启动状态，提示：
![image]()
