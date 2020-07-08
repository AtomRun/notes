# Socket编程（十）

## 本章目标

- close与shutdown区别
- 进一步改进回射客户程序。

## close与shutdown区别

- close终止了数据传送的两个方向。
- shutdown可以有选择的终止某个方向的数据传送或者终止数据传送的两个方向。
- shutdown how= 1就可以保证对等方接收到一个EOF字符，而不管其他进程是否已经打开了套接字。而close不能保证，直到套接字引用计数减为0时才发送。也就是说直到所有的进程都关闭了套接字。

![](https://i.loli.net/2020/05/16/RklEgZXuoWOavh7.png)