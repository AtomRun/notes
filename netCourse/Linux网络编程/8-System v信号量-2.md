# System V信号量（二）

## 本章目标

- 用信号量实现进程互斥

![](https://i.loli.net/2020/06/14/YiOR5pjoyaEGFJg.png)

```c
struct sembuf sb三{Q, -1，Q};
int ret;
ret = semop(semid, &sb, 1);
if (ret ==
ERR EXIT("semop");
return ret;
}
int sem v(int semid) 
struct scmbuf sb = [Q, 1, 0};
int rct ;
ret = semop(semid, &sb, 1);
if (ret = -1
ERR EXIT("'semop");
return ret;
}
int semi d;
int main(int argc, char *argvf 1)
{
semid = sem_ create(IPC_ PRIVATE);
pid_t pid;
pid = forkO
计
(pid ==
ERR EXITC" fork");
(pid > 0)
return 0;

```

![](https://i.loli.net/2020/06/14/sMXSGn4i9gJ52tv.png)