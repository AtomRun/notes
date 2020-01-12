### Nginx概述
1. Nginx是一 款轻量级的Web服务器/反向代理服务器及电子邮件( IMAP/POP3 )代理服务器,并在一个BSD-like 协议下发行。由俄罗斯的程序设计师IgorSysoev所开发,供俄国大型的入口网站及搜索引擎Rambler (俄文: Pam6nep )使用。其特点是占有内存少,并发能力强,事实上nginx的并发能力确实在同类型的网页服务器中表现较好,中国大陆使用nginx网站用户有:百度、新浪、网易、腾讯等。

### 负载均衡策略
1. 使用硬件均衡策略实现，如F5、Array等负载均衡器
2. 使用软件进行负载均衡
   1. 如使用阿里云服务器均衡负载SLB
   2. 使用Nginx+Keepalived
   3. 使用软件负载均衡如LVS(Linux Virtual Server)、haproxy等技术。

###  Nginx优点
1. Nginx可以在大多数Unix like OS 上编译运行，并有Windows移植版。Nginx的1.4.0稳定版已经与2013年4月24日发布，一般情况下，对于新建站点，建议使用最新稳定版作为生产版本，已有站点的急迫性不高。Nginx的源代码使用2-clause BSD-like licene
2. Nginx是一个强大的高性能WEB和反向代理服务器，它拥有非常优越的性能
3. 在高连接并发的情况下，Nginx是Apache服务器不错的替代品：Nginx在美国是做虚拟机生意的老爸呢经常选择的软件平台之一，能够高达50000个并发连接数的响应，感谢Nginx为我们选择了 epoll and kquenue作为开发模型。

### Nginx环境搭建(不赘述，自行百度)

### Nginx配置文件说明
1. nginx虚拟主机配置 :
2. #虚拟主机配置:
    server {
        listen 1234;
        server_ name bhz.com;
        location/ {
        root bhz.com;
        index index.html;
    }
}

3. root即根文件夹在哪里
4. index即默认的欢迎界面是什么
5. error_page 即报错了之后的页面
6. location = /50x.html 精准匹配

### Nginx配置文件说明(三)
1. nginx日志管理:
2. nginx访问日志放在logs/host.alccess.log下,并且使用main格式(还可以自定义格式)
3. 对于main格式如下定义:
   1. 日志文件输出格式这个位置相于全局设置
   2. #log_ format main '$remote_ addr - $remote_ _user [$time_ local] "$request" '
   3. #  '$status $body_ bytes_ sent "$http_ referer"'
   4. #  "$http_ user_ agent" "$http_ x_ forwarded_ for"";
   5. 查看 日志内容命令: tail -n 100 -f nginxlogs/access.log
   6. 我们在日常生活照，对nginx日志的分析非常的重要，通常需要运维去对nginx的日志进行切割和分析处理。比如实现-一个定时任务，去处理nginx日志等。
   7. 第一步:分析如何去实现日志切分，编写shell脚本。
   8. 第二步:定时任务对脚本进行调度: crontab -e
   9. */1**** sh /usr/local/nginx/sbin/log.sh

### Nginx配置文件说明(四)
1. location语法：表示uri方式定位
2. 基础语法有三种：
   1. location = pattern {} 精准匹配
   2. location pattern {} 一般匹配
   3. location ~ pattern {} 正则匹配

### Nginx配置文件说明(五)
1. Nginx语法：
   1. if(条件为：= ~ ~*)、return、break、rewrite
   2. -f是否为文件，-d是否为目录，-e是否存在
   3. nginx可以对数据进行压缩，对一些图片，html，css，js等文件进行缓存，从而实现动静分离等优化功能，在网站做优化的时候非常的有用

### Nginx配置文件说明(六)
1. Nginx 反向代理proxy与负载均衡upstream
2. 配置反向代理proxy: proxy_ pass  url地址
3. 配置负载均衡upstream: upstream
4. 官方配置: http://nginx.org/en/docs
5. 注意:反向代理之后获取客户端IP地址为nginx服务器地址，这里需要nginx进行forward,设置真实的ip地址:
   1. #设置客户端真实ip地址
   2. proxy_ set healder X-real-ip $remote_ addr;



