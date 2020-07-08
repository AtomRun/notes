# Socket编程（十三）

## 本章目标

1. UDP特点
2. UDP客户/服务基本模型
3. UDP回射客户/服务器
4. UDP注意点

![](https://i.loli.net/2020/05/23/SM7LnpkWKvlh4bR.png)

## UDP特点

1. 无连接
2. 基于消息的数据传输服务
3. 不可靠
4. 一般情况下UDP更高效

![](https://i.loli.net/2020/05/23/qNtac9WZrEXePK4.png)

![](https://i.loli.net/2020/05/23/kWvtZEznw74JF9S.png)

```c
yoid echo_ srv int sock )
char recvbuf [1024]二
{Q} ;
struct sockaddr. in peeraddr;
sock len_ t peer len;
int n;
while (1)
{
peerlen = sizeof (peeraddr);
mems et (recvbuf, Q，sizeof (recvbuf));
n = recvf rom(sock, recvbuf ，sizeof(recvbuf) ，Q，(struct socka
ddr* &pecraddr，&pccr len) ;
if (n ==
1)
if (errno == EINTR )
cont inue ;
ERR_ EXII(" recvfrom"); 
}
elseif(n>0)
{
fputs (recvbuf, stdout);
sendto(sock, recvbuf, n, Q，(struct sockaddr&) &peerad
dr, peerlen);
close(sock) ;
}
```

## UDP注意点

1. UDP报文可能会丢失、重复
2. UDP报文可能会乱序
3. UDP缺乏流量控制
4. UDP协议数据报文截断
5. recvfrom返回0， 不代表连接关闭，因为udp是无连接的。
6. ICMP异步错误
7. UDP connect
8. UDP外出接口的确定

![](https://i.loli.net/2020/05/23/aDYBLnlmwXJyuCv.png)