# System V信号量（三）

![](https://i.loli.net/2020/06/14/t6FGQO1lYZKjrSq.png)

```c
int main(int argc, char *argv[] )
semid = semget(IPC PRIVATE 5，IPC CREAT | 0666);
f (semid == -1)
ERR EXIT("'semget") ;
union semun su;
su.val = 1;
int
for
(i=0;
i<5; i++)
semctl(semid, i，SETVAL, su);
}
intno=Q;
pid_t pid;
for (-1; i<5; i++) 
{
rida.fork(i
if (pid ==
ERR EXIT("fork");
if (pid = 0)
no =. i;
break;
}
Phi losophere
return Q;
}

```

![](https://i.loli.net/2020/06/14/5le2O94AGFcwvBk.png)

![](https://i.loli.net/2020/06/14/XpSsT9QlbMCzYq6.png)