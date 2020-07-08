# Socket编程（十一）

## 本章目标

- 套接字I/O超时设置方法
- 用select实现超时
  - read_ timeout函 数封装
  - write_ timeout函数封装
  - accept_ timeout函数封装
  - connect_ timeout函数封装

## 套接字I/O超时设置方法

- alarm 
- 套接字选项
- OSO SNDT IMEO
- SO_ _RCVTIMEO
- select

```c
STC-AI RM
void k.andler(int sig)
{
return 0;
si snal (SIGALRM, handler);
slarm(5);
int ret = read(td, bu;, sizeof(tuf));
if (ret = -1 ba exrno == EINT)
errno = ETIMEDOUT; 
else if (ret
0)
alarm(0) ;
```

```c
int read tineout(int fd, unsigned int wait_ seconds)
{
int ret = 0;
if (wait seconds > 0)
{
fd_ set read_ fdset;
struct ti neual tineout;
FD_ ZER0( Gread_ fdset);
FD_ SET(fd, Grcead fdset);
tineout.tu_ sec = uait_ seconds;
tineout.tu_ usec = 0;
d0
ret = select(fd + 1。&read_ fdset, NULL, NULL, &tineout);
》while (ret < 0最& errno == EINTR);
if (ret == 0)
ret =-1;
errno = ETIMEDOUT;
else if (ret
== 1)
ret = 0;
```

![](https://i.loli.net/2020/05/16/q2eoYCFRPV7ciM4.png)