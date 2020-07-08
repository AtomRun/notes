# Socket编程（十二）

## 本章目标

- select限制
- poll

## Select限制 

1. 用select实现的并发服务器，能达到的并发数，受两方面限制
2. 一个进程能打开的最大文件描述符限制。这可以通过调整内核参数。select中的fd set集 合容量的限制(FD SETSIZE)，这需要重新编译内核。

```c
int main(void)
{
ruct rlimit r1;
(getrlimit(RLIMIT_ NOFILE, &r1) < 0) 
ERR EXIT("getrlimit");
printf("%d\n"，(int)url.rlim_ max);
return Q;
}
```

```c
int main(yoid)
{
struct rlimit r1 ;
if (getrlimit(RL IMTT_ NOFILE, &r1) < 0)
ERR_ EXIT( getrl imit");
printf("%d\n"，(int)rl.rlim_ max);
rl.rlim_ cur = 2048; 
r.rlim_ max = 2048;
if (setrlimit(RL IMIT_ NOFILE, &r1) < Q)
ERR EXIT("getrlimit") ;
return 0;
}
```

![](https://i.loli.net/2020/05/23/XaNC4qRZEdyDc1V.png)

## POLL

- #include <poll.h>
- int poll(struct pollfd *fds, nfds_ t nfds, int timeout); 

![](https://i.loli.net/2020/05/23/kP7MNKxtYRJwbCv.png)

![](https://i.loli.net/2020/05/23/tZjlbnUQ7BdOIKa.png)