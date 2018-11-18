## Linux

### 第1章	操作系统概念
    1. 操作系统作用:管理硬件,服务软件
![image](https://github.com/AtomRun/notes/blob/master/noteimages/javaee-images/day11/%E6%93%8D%E4%BD%9C%E7%B3%BB%E7%BB%9F%E5%8E%9F%E7%90%86%E4%BB%8B%E7%BB%8D.png)
    2. 硬件: 电路,写驱动程序,写应用程序
    3. 操作系统: 微软(windows) /Linux,Unix/苹果(mac)
    4. Linux操作系统(世界巨头计算机,各个行业软件服务器系统)
    5. 系统开发人员,运维人员,程序开发人员

### 第2章	安装虚拟机
    1. 虚拟机(软件):通过调用系统接口模拟出一台机器
    2. 服务器(硬件/软件)
    3. 硬件:网吧一台公共机器,硬件服务器
    4. 软件服务器:WebServer(Tomcat) ,邮件,DNS服务器
    5. 参照笔记day21--01.VMware使用.pdf

### 第3章	安装Linux(CentOS版本)
    1. 参照笔记day21--02.Linux(CentOS)安装.pdf

### 第4章	Linux历史介绍
    1. 了解Linux发展史
    2. 了解Linux应用/版本


### 第5章	Linux目录结构介绍
    1. Linux目录结构: 只有1个目录,根目录
    2. usr:相当于program files
    3. etc:存放系统配置文件root:系统管理员默认目录
    4. home:存放其他用户的目录
    5. pwd: 打印当前目录
    6. cd / : 切换到根目录
    7. ll : 查看当前目录下的内容



### 第6章	利用CRT连接linux
    1. *_在linux获取ip:     ifconfig
    2. *_打开绿色版本的CRT: 点击SecureCRT.exe
    3. *_点击文件--->连接--->快速连接
 ![image](https://github.com/AtomRun/notes/blob/master/noteimages/javaee-images/day11/1.png)
 ![image](https://github.com/AtomRun/notes/blob/master/noteimages/javaee-images/day11/2.png)
    4. 依次输入用户名,密码,连接到linux机器上.
    5. 解决CRT编码问题:
        1. *_关闭CRT,重新打开
        2. *_选中待连接的IP,右击--->属性
![image](https://github.com/AtomRun/notes/blob/master/noteimages/javaee-images/day11/3.png)
![iamge](https://github.com/AtomRun/notes/blob/master/noteimages/javaee-images/day11/4.png)

### 第7章	Linux核心命令学习
    1. linux有2种用户,一种管理员root,另外一种普通: zhangsan lis
    2. Root用户登录到linux默认所在的目录是  /root/
    3. 其他用户zhangsan登录到linux默认所在的目录是 /home/zhangsan/

####  7.1	查看目录结构
    1. list :列出
    2. ll        :列出当前目录下的文件信息
    3. ls -al     :列出当前目录下的文件信息(包括隐藏文件,特殊目录)
    4. ll  /bin/  :列出根目录下bin目录下的文件信息
#### 7.2	切换目录命令cd
    1. touch  1.txt   :在当前目录创建一个文件1.txt
    2. clear :清除屏幕
    3. cd  ~
    4. cd  /
    5. cd  -
    6. cd  ..
    7. cd 

#### 7.3	创建目录
    1. pwd:打印工作目录
    2. mkdir: 创建目录
    3. mkdir   a :当前目录下创建文件夹a
    4. mkdir  /root/b  :在根目录下的root下创建目录b
    5. mkdir  -pv  /root/c/e/d :在根目录下的root下创建目录结构c/e/d

#### 7.4	文件浏览命令
    1. cat命令:  如果文件中的内容很少,一页之内可以显示完毕
    2. cat  /root/文件名称  
    3. more命令: 如果文件中内容比较多,一页之内显示不完
    4. more  文件名称
    5. less 命令: 如果文件中内容比较多,一页之内显示不完
    6. less -mN 文件名称
    7. less比more多了搜索功能
    8. tail 命令: 查看文件末尾内容
    9. tail -10 /root/install.log 查看install.log文件中后10行内容

#### 7.5	文件管理
    1. cd  /root/
    2. 复制文件
        1. cp   install.log  install02.log
        2. cp -b  install.log  install02.log  :如果覆盖文件时,可以将源文件做一个备份
        3. cp  ./install.log   ../   : 将当前目录下的install.log复制到父级目录
        4. cp  /root/install.log   /bin/1.txt  
        5. :将/root下的install.log文件复制到根目录下的bin目录下的1.txt中
    3. 复制目录(无论是单层目录还是多层目录都可以复制):
        1. cp  -r  ./a  ./b
        2. cp  -r  /root/a  /root/z
    4. mv剪切文件
        1. mv  /root/install.log  /root/a/
    5. 重命名文件
        1. mv  /root/install.log  /root/test.log
    6. 删除文件
        1. rm -f  文件名称
        2. rm -f  /root/文件名称
    7. 删除目录
        1. rm -rf 目录名称
        2. rm -rf  /root/目录名称
    8. 在某个目录下搜索文件/目录
        1. find  /root/   -name   ‘in*’  :
        2. 在根目录下的root目录下寻找名称中包含in而且是以in开头的文件/目录

#### 7.6	Vim编辑器
    1. vim /root/1.txt  :利用vim编辑器打开文件 ====>  录入 i  (从一般模式转变为插入模式)
    2. ===>录入各种信息 ===>esc(从插入模式转换为一般模式)====>:wq(保存并退出)

### 7.7	系统命令
    1. grep: 过滤任务 经常和其他命令联合使用
    2. grep -i 名称
    3. cat  /root/install.log
    4. cat  /root/install.log  |  grep  -i   mysql :查看install.log文件中包含mysql内容信息
    5. ps -ef :相当于任务管理器,对进程的一次查看
    6. ps -ef  | grep -i crond  : 查看系统中crond的进程信息
    7. 管道命令: 命令的一种使用方式
        1. 命令1  |  命令2
        2. 命令1的输出是命令2的输入
        3. cat  /root/install.log  |  grep  -i   mysql 
        4. ps -ef | grep -i crond
    8. 杀死进程  kill -9 进程id
    9. 查看IP: ifconfig
    10. 查看机器是否连接通畅:  ping 对方机器ip

要求: 虚拟机___>linux ___>镜像____>crt__>练习Linux命令













