# Socket编程（九）

## 本节目标

- select
- 读、写、异常事件发生条件
- 用select改进回射服务器程序。

## 读、写、异常事件发生条件

- 可读
  - 套接C缓冲区有数据可读
  - 连接的读一半关闭，即接收到FIN段，读操作将返回0
  - 如果是监听套接口，已完成连接队列不为空时。
  - 套接C.上发生了一个错误待处理，错误可以通过getsockopt指定SO_ ERROR选项来获取。
- 可写
  - 套接C发送缓冲区有空间容纳数据。
  - 连接的写一半关闭。即收到RST段之后，再次调用write操作。
  - 套接C上发牛了一个错误待处理，错误可以通过getsockopt指定SO_ ERROR选项来获取。
- 异常
  - 套接C存在带外数据

![](https://i.loli.net/2020/05/16/dvlnDw2aHuo3c1P.png)

![](https://i.loli.net/2020/05/16/s9LNpASPbg1qu3K.png)