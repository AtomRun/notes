# Socket编程（二）

![](https://i.loli.net/2020/05/01/gDofHS6PU5FkCmI.png)

## ICP客户/服务器模型

![](https://i.loli.net/2020/05/01/k5OEuLPTQxtogi2.png)



## 回射客户/服务器

![](https://i.loli.net/2020/05/01/98WxOLh1GBUJM6T.png)

![](https://i.loli.net/2020/05/01/w98UCheuVjYvdmN.png)

## socket. bind. listem. accept， conmeet

![](https://i.loli.net/2020/05/01/79BrOAoMuQk8ldg.png)

- 包含头文件<sys/socket. h>
- 功能:创建-一个套接字用于通信
- 原型
  - int socket(int domain, int type, int protocol);
- 参数
  - domain:指定通信协议族(protocol family)
  - type:指定socket类型， 流式套接字SOCK_ STREAM，数据报套
    接字SOCK_ DGRAM，原始套接字SOCK_ _RAW
  - protocol :协议类型
- 返回值:成功返回非负整数，它与文件描述符类似，我们把它称为套接口描述字，简称套接字。失败返回-1





