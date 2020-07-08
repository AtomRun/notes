# System-v消息队列（二）

# 本章目标

- mesgsend
- msgrcv

## msgsend

- 功能:

  - 把一条消息添加到消息队列中

- 原型

  - Q int msgsnd(int msqid, const void *msgp, size_ t msgsz, intmsgflg);

- 参数

  - msgid:由msgget函数返回的消息队列标识码
  - msgp:是一个指针，指针指向准备发送的消息，
  - msgsz:是msgp指向的消息长度，这个长度不含保存消息类型的那个long int长整型msgflg:控制着当前消息队列病或到达系统上限时将要发生的事情

- 返回值:成功返回0; 失败返回-1

- msgflg=IPC_ NOWAIT表示队列满不等待，返回EAGAIN错误。

- 消息结构在两方面受到制约。首先，它必须小于系统规定的上限值:其次，它必须以一个long int长整数开始，接收者函数将利用这个长整数确定消息的类型

- 消息结构参考形式如下:

  ```c
  struct msgbuf {
  long mtype;
  char mtext[1];
  ```

  ```c
  int main(int argc, char★argv[])
  {
  f (argc != 3)
  fprintf(stderr, "usage: %s <bytes> <typex\n", argv[01);
  exit(EXIT FAILURE) ;
  }
  int len-atoi(argv[1i.
  int type 
  atoi (argvt2
  int msgid;
  msgid = msgget(1234, 0);
  if (msgid == -1)
  ERR EXITC msgget”);
  return Q;
  
  ```

  ![](https://i.loli.net/2020/06/06/lV8vmfB1d5UxILA.png)

## msgrecv

- 功能:是从一个消息队列接收消息
- 原型
  - Q ssize. t msgrcv(int msqid. void *msgp, size_ t msgsz, long msgtyp,
    int msgflg);
- 参数
  - msgid:由msgget函数返回的消息队列标识码
  - msgp:是一个指针，指针指向准备接收的消息，
  - msgsz:是msgp指向的消息长度，这个长度不含保存消息类型的那个long int长整型
  - msgtype:它可以实现接收优先级的简单形式
  - msgflg:控制着队列中没有相应类型的消息可供接收时将要发生的事
- 返回值:成功返回实际放到接收缓冲区里去的字符个数，失败返回-1

```c++
int main(int argc, char ★ argv[] )
{
f (argc != 3)
fprintf (stderr, "usage: %s_ <bytes> < type2\n", argv[Q]);
exit(EXIT FATLURE);
}
int len =
atoi(argv[11i
int type
atoi (argv[2] )
int msgid;
msgid二msgget(1234, 0);
if (msgid■-1) I
ERR EXI TC "msgget");
struct ms gbuf *ptr;
ptr = (struct ms gbuf )mal loc (sizeof(long) + len) ;
ptr->mtype = type ;
if (ms gsnd(msgid,. ptr, len, IPC NOWAIT) < 0)
ERR EXITC"ms gsnd") ;
return Q;
```

- msgtype=0返回队列第一条信息
- msgtype>0返回队列第一条 类型等于msgtype的消息
- msgtype<0返回队列第一条 类型小于等于msgtype绝对值的消息
- msgflg= IPC_ _NOWAIT, 队列没有可读消息不等待，返回ENOMSG错误。_
- _msgflg=MSG_ NOERROR，消息大小超过msgsz时被截断
- msgtype>0且.msgflg=MSC_ EXCEPT，接收类型不等于
- msgtype的第一条 消息。

![](https://i.loli.net/2020/06/06/o5Z4uUd3LmYpl6r.png)