# Socket编程（十六）

## 本章目标

- UNIX域协议特点
- UNIX域协议结构
- UNIX域字节流回射客户/服务
- UNIX域套接字编程注意点

## UNIX域协议特点

- UNIX域套接字与TCP套接字相比较，在同一台主机的传输速度前者是后者的两倍
- UNIX域套接字可以在同一台主机上各进程之间传递描述符
- UNIX域套接字与传统套接字的区别是用路径名来表示协议族的描述。

## UNIX域地址结构

```c
#define UNIX_ PATH_ _MAX 108
struct sockaddr_ _un {
sa_ family. _t sun_ family;
/* AF_ UNIX */
char
sun_ path[UNIX_ PATH_ _MAX]; /* pathname */
};
```

![](https://i.loli.net/2020/05/31/5ZrAJ46DwveyO1R.png)

## UNIX域字节流回射客户/服务

```c
int main(void)
int listenfd;
if (Cistenfd = socket(PF UNIX, SOCK.... STREAM, 0)) < Q)
ERR EXIT("socket");
struct sockaddr un servaddr ;
memset (&servaddr; 0，sizeof (servaddr));
servaddr. sun_ fami Ty = AF UNIX;
str cpy( scrvaddr .sun_ path,” tcst sockct" ) ;
if (bind(listenfd, (struct sockaddr* )&servaddr, s izeof (servaddr)) < 0 
)
ERR EXITC"bind");
if (listen(listenfd, SOMAXCONN) < 0)
ERR EXIT("] isten"D);
int conn;
while①
conn = accept(listenfd, NULL, NULL) ;
if (conn == -D)
{
if (Conn == EINTR)
continue ;
ERR EXIT("accept") ;
}
}
return Q;
}
```

![](https://i.loli.net/2020/05/31/ZQHBOTIRsYlygLq.png)

## UNIX域套接字编程注意点

- bind成功将会创建一个文件，权限为0777 & umask
- Sun path最好用一个绝对路径UNIX域协议支持流式套接口与报式套接口
- UNIX域流式套接字connect发现监听队列满时，会立刻返回一个ECONNREFUSED， 这和TCP不同，如果监听队列满，会忽略到来的SYN，这导致对方重传SYN

![](https://i.loli.net/2020/05/31/IRWQ78jJgdtPOED.png)

