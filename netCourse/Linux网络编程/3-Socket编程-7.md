# Socket编程（七）

## TCP 11种状态

![](https://i.loli.net/2020/05/09/1buIU9NHx6eyiBO.png)

## 连接建立三次握手、连接终止四次握手

## TIME_ WAIT与SO_ REUSEADDR

## SIGPIPE

- 往一个已经接收FIN的套接中写是允许的，接收到
  FIN仅仅代表对方不再发送数据。
- 在收到RST段之后，如果再调用write就会产生
  SIGPIPE信号，对于这个信号的处理我们通常忽略
  即可。
  si gnal (SIGPIPE,SIG_ IGN) ;

![](https://i.loli.net/2020/05/09/Mv129VDAak8ZbHl.png)