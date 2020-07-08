# Socket编程（一）

![](https://i.loli.net/2020/05/01/4xq3V6gX5csGwyF.png)

## 什么是socket

![](https://i.loli.net/2020/05/01/EY3VwyqHbc4nXuz.png)

1. socket可以看成是用户进程与内核网络协议栈的
   编程接口
2. socket不仅可以用于本机的进程间通信，还可以
   用于网络.上不同主机的进程间通信
3. 可以异构通信，即两个机器结构不同，即手机QQ和PCQQ进行通信。

![](https://i.loli.net/2020/05/01/KWQyvhTur7Yknba.png)

## IPv4套接口地址结构

![](https://i.loli.net/2020/05/01/4fzFcd3qCTL78Uo.png)

- IPv4套接口地址结构通常也称为“网际套接字地址结构”，它以“sockaddr_ in"命名， 定义在头文件<netinet/n.h>中

  ```c
  struct sockaddr _in {
  uint8_ _t sin_ len;
  sa_ family_ t sin_ family;
  in_ .port. t sin_ _port;
  structin_ _addr
  sin_ _addr; 
  char sin_ zero[8];
  };
  ```

- sin_ len: 整个sockaddr _in结构体的长度，在4.3BSD-Reno版本之前
  的第一个成员是sin_ _family.

- _sin_ _family: 指定该地址家族，在这里必须设为AF_ 

- sin_ _port:端口_

- sin_addr: IPv4的 地址

- sin_zero:暂不使用，一般将其设置为0

### 通用地址结构

![](https://i.loli.net/2020/05/01/J1SUCBV9E2ZLNcf.png)

- 0通用地址结构用来指定与套接字关联的地址

  ```c
  struct sockaddr {
  uint8_ _t sin_ len; 
  sa_ _family. _t sin_ _family;
  char sa_ _data[14];
  };
  ```

- sin_ len: 整个sockaddr结构体的长度

- sin_ _family: 指定该地址家族

- sa_ _data: 由sin_ _family 决定它的形式。

## 网络字节序

![](https://i.loli.net/2020/05/01/UM1vRtFgJWO6NSh.png)

- 字节序
  - 大端字节序(Big Endian)
    最高有效位(MSB: Most Significant Bit)存储于最低内存地址
    处，最低有效位(LSB: Lowest Significant Bit)存储于最高内存
    地址处。
  - 公端字节序(I,itt]e Fndian) 
    最高有效位T(MSB: Most Significant Bit)存储于最高内存地址
    处，最低有效位(LSB: Lowest Significant Bit)存储于最低内存
    地址处。
- 主机字节序
  - 不同的主机有不同的字节序，如x:86为小端字节序，Motorola 6800为
    大端字节序，ARM字节序是可配置的。
- 网络字节序
  - 网络字节序规定为人端字节序

![](https://i.loli.net/2020/05/01/JHZYV8hn5f2OPLq.png)

## 字节序转换函数

![](https://i.loli.net/2020/05/01/CEz1ZxOUtH4vr3B.png)

- uint32_ t htonl(uint32_ t hostlong);
- uint16_ ↑htons(uint16_ _t hostshort);
- uint32_ ↑ntohl(uint32 t netlong);
- uint16_ t ntohs(uint16_ t netshort);

>  说明:在上述的函数中，h代表host: n代表notwork s代表short:代表long

## 地址转换函数

![](https://i.loli.net/2020/05/01/UBi8bEsC9dGc7It.png)

- #include <netinet/in.h>
- #include <arpa/inet.h>
- int inet_ _aton(const char *cp, struct in_ addr *inp);
- in_ addr_ _t inet_ addr(const charcp);
- char *inet_ ntoa(struct in_ addr in);

## 套接字类型

![](https://i.loli.net/2020/05/01/pyCQXigBb1m89SD.png)

- 流式套接字(SOCK_ STREAM)
  - 对应的TCP协议，提供面向连接的、可靠的数据传输服务，数据无差错，无重复的发送，且按发送顺序接收。
- 数据报式套接字(SOCK_ _DGRAM)
  提供无连接服务。不提供无错保证，数据可能丢失或重复，并且接收顺序混乱。
- 原始套接字(SOCK_ RAW)



