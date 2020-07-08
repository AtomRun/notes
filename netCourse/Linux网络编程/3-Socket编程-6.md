# Socket网络编程（六）

## TCP回射客户/服务器

![](https://i.loli.net/2020/05/09/RyDbvNcXgAMkauj.png)

![](https://i.loli.net/2020/05/09/T2sGZ4qSWirvzIX.png)

## TCP是个流协议

- TCP是基于字节流传输的，只维护发送出去多少，确认了
  多少，没有维护消息与消息之间的边界，因而可能导致粘
  包问题。
- 粘包问题解决方法是在应用层维护消息边界。

## 僵进程与SIGCHLD信号

- signal(SIGCHLD, SIG_ IGN)
- signal(SIGCHLD, handle_ _sigchld);

![](https://i.loli.net/2020/05/09/4nvsRdiLVjGOcCu.png)

![](https://i.loli.net/2020/05/09/BmKDAQwV8ZTFpSe.png)

![](https://i.loli.net/2020/05/09/7kpwBEO6iylhG3q.png)