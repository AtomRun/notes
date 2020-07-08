# System-v消息队列（一）

# 本章目标

- 消息队列
- IPC对象数据结构
- 消息队列结构
- 消息队列在内核中的表示
- 消息队列函数

# 消息队列

消息队列提供了一个从一个进程向另外一-个进程发送一块数据的方法每个数据块都被认为是有一个类型，接收者进程
接收的数据块可以有不同的类型值消息队列也有管道一样的不足，就是每个消息的最大长度是有。上限的( MSGMAX)，
每个消息队列的总的字节数是有.上限的( MSGMNB)，系统 上消息队列的总数也有一个上限(MSGMNI)、

# IPC对象数据结构

- 内核为每个IPC对象维护--个数据结构

```c
struct ipc_ _perm {
key_ _t
key;
/* Key supplied to xxxget(2) */
uid_ t
uid;
/* Effective UID of owner */
gid_ _t
gid;
/* Effective GID of owner */
uid_ _t
cuid;
/* Effective UID of creator */
gid_ _t
cgid;
/* Effective GID of creator */
unsigned short mode;
|* Permissions */
unsigned short
__seq;
/* Sequence number */
};
```

![](https://i.loli.net/2020/06/06/UKYqgM9f7Xv3p1o.png)

```c
struct msqid_ _ds {
struct ipc_ _perm msg_ perm;
/* Ownership and permissions */
time_ _t
msg_ stime; /* Time of last msgsnd(2) */
time_ t
msg_ itime; !* Time of last msgrcv(2) */
time_ t
msg_ ctime; /* Time of last change */
unsigned long__ _msg_ cbytes; /* Current number of bytes in
queue (nonstandard) */
msgqnum_ t
msg_ qnum; /* Current number of messages
in queue */
msglen_ t
msg_ qbytes; /* Maximum number of bytes
allowedin queue */
pid_ t
msg_ lspid;
/* PID of last msgsnd(2) */
pid_ t
msg_ Irpid; /* PID of last msgrcv(2) */
};

```

# 消息队列在内核中的结构

![](https://i.loli.net/2020/06/06/x3VCzsT5M1PFW8Z.png)

# 消息队列函数

```c
#include <sys/types. h>
#include <sys/ipc. h>
#include <sys/msg.h>
int msgget(key_ _t key, int msgflg);
int msgctl(int msqid, int cmd, struct msqid_ ds *buf);
int msgsnd(int msqid, const void *msgp, size_ t msgsz,
int msgflg);
ssize_ t msgrcv(int msqid, void *msgp, size_ t msgsz, long 
msgtyp, int msgflg);

```

## messaget函数

- 功能:用来创建和访问一个消息队列
- 原型
  - int msgget(key_ t key, int msgflg);
- 参数
  - key:某个消息队列的名字
  - msgflg:由九个权限标志构成，它们的用法和创建文件时使用的mode模式标志是-样的
- 返回值:成功返回一个非负整数，即该消息队列的标识码;失败返回-1

```c
int main(yoid)
int msgid;
msgid = msgget(1234， 0400
IPC CREAT)
//msgid = msgget(1234
0666
IPC CREAT
1 IPC_ EXCL);
/ /msgid 
ms gget(IPC PRIVATE 
0666 I IPC CREAT I IPC EXCL);
/msgid = ms gget(IPC PRIVATE
0666) ;
//msgid = msgget(1234, 0666
IPC_ CREAT) ;
msgid = msgget(1234, 0600);
if (msgid == -1)
ERR EXIT("msgget") ;
printf(" msaget succ\n"); 
printf( msai d-%d\n_，msgid) ;
r eturn
Q;
```

![](https://i.loli.net/2020/06/06/j329wvOeXV1Zix6.png)

![](https://i.loli.net/2020/06/06/QvsMeKS9J3gymEj.png)