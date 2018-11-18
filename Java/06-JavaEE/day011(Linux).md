### 第1章	操作系统概念
操作系统作用:管理硬件,服务软件
 
硬件: 电路,写驱动程序,写应用程序
操作系统: 微软(windows) /Linux,Unix/苹果(mac)
Linux操作系统(世界巨头计算机,各个行业软件服务器系统)
系统开发人员,运维人员,程序开发人员

第2章	安装虚拟机
虚拟机(软件):通过调用系统接口模拟出一台机器

服务器(硬件/软件)
硬件:网吧一台公共机器,硬件服务器
软件服务器:WebServer(Tomcat) ,邮件,DNS服务器
参照笔记day21--01.VMware使用.pdf

第3章	安装Linux(CentOS版本)
参照笔记day21--02.Linux(CentOS)安装.pdf

第4章	Linux历史介绍
了解Linux发展史
了解Linux应用/版本
第5章	Linux目录结构介绍
Linux目录结构: 只有1个目录,根目录
usr:相当于program files
etc:存放系统配置文件
root:系统管理员默认目录
home:存放其他用户的目录


pwd: 打印当前目录
cd / : 切换到根目录
ll : 查看当前目录下的内容



第6章	利用CRT连接linux
*_在linux获取ip:     ifconfig
*_打开绿色版本的CRT: 点击SecureCRT.exe
*_点击文件--->连接--->快速连接
 
 
 
依次输入用户名,密码,连接到linux机器上.

解决CRT编码问题:
*_关闭CRT,重新打开
*_选中待连接的IP,右击--->属性
 


 


第7章	Linux核心命令学习
linux有2种用户,一种管理员root,另外一种普通: zhangsan lisi
Root用户登录到linux默认所在的目录是  /root/
其他用户zhangsan登录到linux默认所在的目录是 /home/zhangsan/


7.1	查看目录结构
list :列出
ll        :列出当前目录下的文件信息
ls -al     :列出当前目录下的文件信息(包括隐藏文件,特殊目录)
ll  /bin/  :列出根目录下bin目录下的文件信息
7.2	切换目录命令cd
touch  1.txt   :在当前目录创建一个文件1.txt
clear :清除屏幕

cd  ~
cd  /
cd  -
cd  ..
cd 

7.3	创建目录
pwd:打印工作目录
mkdir: 创建目录
mkdir   a :当前目录下创建文件夹a
mkdir  /root/b  :在根目录下的root下创建目录b
mkdir  -pv  /root/c/e/d :在根目录下的root下创建目录结构c/e/d

7.4	文件浏览命令
cat命令:  如果文件中的内容很少,一页之内可以显示完毕
cat  /root/文件名称  

more命令: 如果文件中内容比较多,一页之内显示不完
more  文件名称

less 命令: 如果文件中内容比较多,一页之内显示不完
less -mN 文件名称

less比more多了搜索功能

tail 命令: 查看文件末尾内容
tail -10 /root/install.log 查看install.log文件中后10行内容

7.5	文件管理
cd  /root/

复制文件
cp   install.log  install02.log
cp -b  install.log  install02.log  :如果覆盖文件时,可以将源文件做一个备份
cp  ./install.log   ../   : 将当前目录下的install.log复制到父级目录
cp  /root/install.log   /bin/1.txt  
   :将/root下的install.log文件复制到根目录下的bin目录下的1.txt中

复制目录(无论是单层目录还是多层目录都可以复制):
cp  -r  ./a  ./b
cp  -r  /root/a  /root/z

mv剪切文件
mv  /root/install.log  /root/a/
重命名文件
mv  /root/install.log  /root/test.log
删除文件
rm -f  文件名称
rm -f  /root/文件名称
删除目录
rm -rf 目录名称
rm -rf  /root/目录名称

在某个目录下搜索文件/目录
find  /root/   -name   ‘in*’  :
  在根目录下的root目录下寻找名称中包含in而且是以in开头的文件/目录

7.6	Vim编辑器
vim /root/1.txt  :利用vim编辑器打开文件 ====>  录入 i  (从一般模式转变为插入模式)
===>录入各种信息 ===>esc(从插入模式转换为一般模式)====>:wq(保存并退出)

7.7	系统命令
grep: 过滤任务 经常和其他命令联合使用
grep -i 名称
cat  /root/install.log
cat  /root/install.log  |  grep  -i   mysql :查看install.log文件中包含mysql内容信息
ps -ef :相当于任务管理器,对进程的一次查看
ps -ef  | grep -i crond  : 查看系统中crond的进程信息

管道命令: 命令的一种使用方式
命令1  |  命令2
命令1的输出是命令2的输入
cat  /root/install.log  |  grep  -i   mysql 
ps -ef | grep -i crond

杀死进程  kill -9 进程id
查看IP: ifconfig
查看机器是否连接通畅:  ping 对方机器ip




要求: 虚拟机___>linux ___>镜像____>crt__>练习Linux命令













