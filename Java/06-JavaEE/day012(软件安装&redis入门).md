## 软件安装&Redis入门
### 第1章	复习
### Linux:
    1. OS操作系统(operation system): 
    作用:控制硬件,服务软件 (3本书籍)
    2. 虚拟机概念:(软件):虚拟出一台计算机环境
    安装虚拟机(vmware)____>配置       2个虚拟网卡
    3. 在虚拟机上安装操作系统Linux(CentOS)
    4. Linux历史知识  
    应用:安装在各种服务器之上,用于嵌入式   
    版本: 内核版本,发行版本
    5. 目录介绍  (1个目录)
    root  home  usr   etc
    6. 核心命令
        切换目录:cd     cd /    cd -       cd ../   cd  ~
        查看目录下的文件/目录:list     ll     ls -al    ls /root/
        创建目录:  mkdir ./b    mkdir -pv /root/a/b/c/d
        创建文件:  touch  /root/1.txt 
        复制目录:  cp  -r   ./a    /root/b
        复制文件:  cp  ./install.log  /root/
        删除文件:  rm /root/install.log    rm  -f  /root/install.log
        删除目录:  rm  -rf /root/a
        剪切文件/目录:   mv  ./aaa/   /root/
        重命名文件/目录:   mv  -f  ./install.log   ./test.log
        查看文件: cat  more   less  tail
        搜索指定文件:  find  /root/  -name  ‘test*’
        编辑文件: vim ./1.txt____>IAO(iao)___>录入内容___>ESC___>:wq
        过滤:  grep -i ‘sss’
        管道: 不是具体的命令,而是命令组合使用的一种方式
        cat 1.txt | grep  -i   'test'
        ps -ef | grep -i 'crond'
        系统命令: ps ifconfig ping kill
### 第2章	Linux剩余核心命令
### 2.1	解压缩命令:
    1. tar  -zcvf  /root/xxx.tar   /root/a/
    2. tar  -zxvf  ./xxx.tar
    3. 关机/重启:   reboot  halt
### 2.2	更改目录/文件权限
    1. 权限:
        用户/组/权限:
        root管理员用户: 
        安装好Linux操作系统,同时在系统上安装QQ,火狐浏览器,快播,QQ游戏,eclipse
        zhangsan:经常使用QQ,火狐浏览器,快播
        root管理员在linux系统上为zhangsan创建一个用户名和密码 zhangsan<===>zhangsan
        为张三分配QQ,火狐浏览器,快播三个软件的使用权限

        zhangsan:经常使用QQ,火狐浏览器,快播
        root管理员在linux系统上为lisi创建一个用户名和密码 lisi<===>lisi
        为李四分配QQ,火狐浏览器,快播三个软件的使用权限

        wangwu:经常使用QQ游戏,eclipse,快播
        root管理员在linux系统上为wangwu创建一个用户名和密码 wangwu<===>wangwu
        为王五分配QQ,火狐浏览器,快播三个软件的使用权限

        root用户建立组: A组 ,为A组分配了QQ,火狐浏览器,快播三个软件的使用权限
        tom申请使用linux系统,经常使用QQ,火狐浏览器,快播三个软件的使用权限
        root为tom创建用户名和密码,创建用户的同时说明tom是属于A组

    2. 更改目录/文件用户权限
        chmod  u-rwx   ./1.txt   取消当前用户对1.txt的”读写执行”权限
        chmod  g-rwx   ./1.txt   取消当前组用户对1.txt的”读写执行”权限
        chmod  o-rwx   ./1.txt   取消其他用户对1.txt的”读写执行”权限
        chmod  777  ./1.txt  设置当前用户,当前组用户以及其他所有用户对文件1.txt的权限
        以数字形式更改目录/文件权限的规则如下:
 
            0:不具有任何权限    1: 可以执行    2:可以写　　　３(1+2):可以执行,可以写
            4:可以读  5:(1+4):可以执行,可以读   6:(2+4):可以写可以读 7:(1+2+4):可以读,写,执行

    3. Linux下网络配置
        如果虚拟机安装完毕之后,看不到对应的2个虚拟网卡:通过vim修改网卡的相关配置项
 

    4. 如何查看各个命令的参数
        Linux命令
        内部命令:Linux系统核心命令 , 等价于windows<===>dir
        外部命令:后来加入的命令  , 等价于windows<===>java
        如果查看内部命令帮助文档方式:  help + 命令
        如果查看外部命令帮助文档方式:  man + 命令

### 第3章	在linux安装jdk,tomcat,mysql
    1. 安装jdk,mysql,gcc相关的依赖包

    1.1 在linux安装jdk

        1. 利用Filezillar.exe在linux /usr/local/src/ 建立3个目录java,mysql,tomcat
        2. 利用Filezillar.exe将windows上的3个软件jdk,mysql,tomcat上传到linux


    严格参照文档

### 第4章	Redis
    1. 6天案例 SSH框架6天案例 oralce  16项目 ssm lucuen solor 16项目
# 重要:


### 4.1	NoSQL: not only sql
    1. 为什么有NOSql:  互联网项目:特点: 数据库高并发读写,海量数据高效率存储,可扩展
    2. NOSQL主流:
        键值对(redis),列式存储,文档类型,图形数据库
    3. NoSql特点:
        特点: 数据库高并发读写,海量数据高效率存储,可扩展
### 4.2	Redis简介
    1. 什么是实时系统: 瞬时可以实现某些数据的统计或者是功能的实现
    2. Redis由来: 
    3. 什么是redis? 
        由C语言实现的直接操作内存的开源的高性能的数据库软件
    4. redis应用场景
 
### 4.3	安装redis
    1. redis安装包: 源码形式提供   .c文件
    2. 将.c编译为.o文件  需要安装: gcc
    3. 将编译后的文件安装在linux系统上

    等价于 希望在当前的系统安装JAVA版本的QQ,下载到的安装文件以.java源码形式提供.
    需要:
    1. 下载GCC 在系统上有JDK(GCC),
    2. 编译: 通过JDK将源码编译为字节码
    3. 安装: 将字节码进行打包设置 .bat

  
     
    4. 获取安装包 redis-3.0.7.tar.gz
    5. 利用filezilla.exe 将安装包上传到/root/
    6. cd /root/  ___>   tar -zxvf redis-3.0.7.tar.gz
    7. 编译  将源码翻译为.o文件
    cd  /root/redis-3.0.7  ___> make
    1. 创建一个目录  /usr/loca/redis  (安装目录)
    2. 安装reids
    cd /root/redis-3.0.7
    make PREFIX=/usr/local/redis install
    

    1. 由于redis启动需要一个配置文件,将配置文件复制到 /root/redis/
    cp   /root/redis-3.0.7/redis.conf   /root/redis
    1. 修改/usr/local/redis/redis.conf
    
    2. 启动服务端   ./bin/redis-server   ./redis.conf
    3.  启动客户端   ./bin/redis-cli
    4.  测试redis是否正确安装成功
    向服务器发送 ping 命令,服务器返回 pong
    向服务器发送  set name tom
                    get name 命令可以看到可以获取到tom的信息 
    向服务器发送keys *   
        可以查看服务器中一共有多少键值对的数据,可以查看到各个键值类型数据
    
    












