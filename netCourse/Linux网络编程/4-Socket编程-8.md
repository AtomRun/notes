# Socket编程（八）

## 本章目标

1. 五种I/O模型
2. select
3. 用select改进回射客户端程序

## IO模型

1. 阻塞I/O

![](https://i.loli.net/2020/05/16/yzWqZBUD2ETNPfi.png)



![](https://i.loli.net/2020/05/16/AfdzLcoVRqx2BbI.png)

1. 非阻塞I/O

![](https://i.loli.net/2020/05/16/2T9BXl87yt1vzUR.png)

1. I/O复用( select和poll)

![](https://i.loli.net/2020/05/16/3taLgDy1frd86TR.png)

![](https://i.loli.net/2020/05/16/DL7Trp3P5J6Q2FV.png)

1. 信号驱动I/O

![](https://i.loli.net/2020/05/16/AFlxXtq39TVc4Gy.png)

![](https://i.loli.net/2020/05/16/Nm5rbwlTMtv4aie.png)

1. 异步I/O

![](https://i.loli.net/2020/05/16/GZF6JiMLtay7Tcm.png)

![](https://i.loli.net/2020/05/16/8oNmSpWgxbc1GPH.png)

## SELECT

用select管理多个IO一旦其中的一个I/0或者多个I/0检测到我们所感法趣的事件，
select函故返回，返回值力检测到的事件个数并且返回哪些I/0发生了 事件遍历这些事件，进而处理事件

```C
int select(int nfds, fd_ set *readfds, fd_ _set
*writefds, fd_ set * exceptfds, struct timeval
*timeout);

void FD_ CLR(int fd, fd_ set *set);
int FD_ ISSET(int fd, fd_ _set *set);
void FD_ SET(int fd, fd_ set *set); 
void FD_ ZERO(fd_ set *set);

```

![](https://i.loli.net/2020/05/16/7da9ohPilO2kZCM.png)