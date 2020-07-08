# SystemV信号量（一）

## 本章目标

- 信号量
- 信号量级结构
- 信号量集函数
- 信号量示例

## 信号量

- 信号量和P、V原语由Djkstra(迪杰斯特拉)提出
- 信号量
  - 互斥: P、V在同一个进程中
  - 同步: P、V在不同进程中
- 信号量值含义
  - S>0: S表示可用资源的个数
  - S=0:表示无可用资源，无等待进程
  - S<0: |S|表示等 待队列中进程个数

![](https://i.loli.net/2020/06/14/fjPVmMdqkZS5Jra.png)

## 信号量集函数

```c
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>
int semget(key_ t key, int nsems, int semflg);
int semctl(int semid, int semnum, int cmd, ..); 
int semop(int semid, struct sembuf * sops,
unsigned nsops); 
```

## shmctl函数

- 功能:用于控制信号量集
- 原型
  - int semctl(int semid
-  int semnum, int cmd,
- 参数
  - semid:由semget返回的信号集标识码
  - semnum:信号集中信号量的序号
  - cmd:将要采取的动作(有三个可取值)
  - 最后一个参数根据命令不同而不同
  - 返回值:成功返回0;失败返回-1 

![](https://i.loli.net/2020/06/14/fNphe7gaOBLsZoW.png)

## semop函数

```c
sembuf结构体:
struct sembuf {
short sem_ num;
short sem op;
short sem flg; 
};
sem_ num是信号量的编号。
sem_ op是信号量一次PV操作时加减的数值，一般只会用到两个值，
一一个是"-1"，也就是P操作， 等待信号量变得可用;另一个是“+1"，也
就是我们的V操作，发出信号量已经变得可用
sem_ flag的 两个取值是IPC. .NOWAIT或SEM_ UNDO
```

```c
int sem open(key_t key)
{
int. semid;
semid = semget(key, Q, 0);
f (semid == -1)
ERR EXIT("semget");
return semid; 
}
int sem setval(int semid, int va1)
union scmun su; ]
su.val = val; |
int ret;
ret = semctl(semid, 0，SETVAL, sU);
f (ret == -1)
ERR EXITC"sem_ setva"H
return Q;
int sem getvalCint semi d)
{
int ret;
ret一semctl(semid, Q，GETVAL, 0);
f (ret == -D)
ERR EXIT("sem getval");
return ret;
}
int sem d(int semi d)
```

![](https://i.loli.net/2020/06/14/H46VKwGXy8NCWMh.png)