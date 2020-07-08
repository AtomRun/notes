# System-v消息队列（三）

# 本章目标

- 消息队列实现回射客户、服务器

![](https://i.loli.net/2020/06/06/jnhIbEB2pcFNJ6W.png)

```c++
#inc lude <errno.h>
#define ERR EXIT(m) \
do
perror(m); \
exit(EXIT FALL URE): \
_whi le(0) ,
struct ms gbuf [
- long mtype
message type, must be > 0 */
char mtcxt
t1]; 
mcssagc data */
};
#define MSGMAX 8192
int main(int argc, char *argv[])
{
int msgid;
msgid = msgget(1234， 0);
if (msgid == -1)
ERR EXIT("msgget");
struct msgbuf *ptr;
ptr = (struct ms gbuf* )mal loc(sizeof(long) + MSGMAX) ;
ptr->mtype = type;
intn=Q;
if ((n = msgrcv(msgid, ptr, MSGMAX, type, flag)) < Q)
ERR_ EXIT("msgsnd");
printf(" read %d_ bytes type=%1d\n_， n, ptr->mtype) ; 
return Q;
```

```c++
#define MSGMAX 8192
struct ms gbuf {
long mtype ;
/* message type, must be > 0 */
char mtext [MSGMAX]; /* message data */
};
yoid echo_ cli(int msgid)
{
n;
pid;
pid三getpido;
struct msgbuf ms g ;
memset(&msg, Q，sizeof (msg));
msg. mtype =
CCint msg. mtext) = pid;
whi le (fgets (msg. mtext+4, MSGMAX, stdin) != NULL)
{
if (ms gsnd(msgid,. &msg, 4+strlen(msg. mtext+4), 0)
ERR EXIT("msgsnd");
if C(n = msgrcv(msgid, Ramsg, MSGMAX, 1，0)) < Q)
ERR EXIT ("'msgsneD;
}
struct msgbuf *ptr;
ptr = (struct msgbuf* )malloc (sizeof(long) + len);
ptr->mtype = type;
}
int main(int argc, char ★argv[])
{
int msgid;

```

![](https://i.loli.net/2020/06/06/oKfTBr5NAVlJYq8.png)

![](https://i.loli.net/2020/06/06/kdSZX4slMNyh9e6.png)