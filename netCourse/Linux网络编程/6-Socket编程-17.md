# Socket编程-17

## 本章目标

- Socketpair
- sendmsg/recvmsg
- UNix套接字传输描述字符

## SocketPair

- 功能:创建一个全双工的流管道
- 原型
  - int socketpair(int domain, int type, int protocol, int sv|
- 参数
  - domain:协议家族
  - type:套接字类型
  -  protocol:协议类型
  - sv:返回套接字对
- 返回值:成功返回0;失败返回-1

```c
int main(void)
int sockfds [2] ;
if (socketpair(PF UNIX, SOCK STREAM, Q，sockfds) < Q)
ERR EXIT("socketpair");
pid_t pid;
pid = fork
9i
if (pid ==
ERR EXIT(C"fork");
if (pid➢0)
int val =.
is
Close(sockfdsf11);
whi le (1)
++va 1 ;
printf ("sending data: %d\n"， val)
write(sockfds[Q], &val，
sizeof [va
;
read(sockfds[Q]，&val ，sizeof(val)) ;
printf("data received: %d\n"， va1 ;
s11
}
else if (pid == 0)

```

![](https://i.loli.net/2020/05/31/rEhw86MuKgeSiZH.png)

## sendMsg/recvMsg

```c
ssize_ t sendmsg(int sockfd, const struct msghdr
*msg, int flags);
ssize_ t recvmsg(int sockfd, struct msghdr *msg,
int flags);
```

![](https://i.loli.net/2020/05/31/YftrolWmEuZhAy8.png)

![](https://i.loli.net/2020/05/31/sLmdke2Jut4vOZw.png)