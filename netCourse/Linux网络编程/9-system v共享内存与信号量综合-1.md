# system v共享内存与信号量综合

## 本章目标

- 用信号量解决生产消费问题
- 实现shfifo

## 用信号量解决生产消费问题

![image-20200624180549586](C:\Users\clee\AppData\Roaming\Typora\typora-user-images\image-20200624180549586.png)

## 实现shfifo

![image-20200624180642926](C:\Users\clee\AppData\Roaming\Typora\typora-user-images\image-20200624180642926.png)

![image-20200624180708074](C:\Users\clee\AppData\Roaming\Typora\typora-user-images\image-20200624180708074.png)

```c
struct shnfifo
shnhead t *p shn; 
1/共享内存头部指针.
char部p_ payload;
”有效负载的起始地址
int shmid;
1/共享内存ID
int sen_ nutex;
1用来互斤用的信号量
int sem_ _fu11;
1用来控制共享因存毫查满的信号量
int sen empty;
”用来控制其享内存是否空的信号量
};
shnf1f0_ _t￥ 5hMF1f0_ in1t(1nt key, int b1ks1ze, int b1ockS);
U010 ShMf1fD_ put(Shnf1f0_ t *f1f0, const v01d rDUf);
void shnfifD get(shnfifo_ t *fif0, char *buf);
uoid shmFD_ destroy(shnfifo _t *fif0);
#endif /* SHM FIF0 _H_的/
```

```c++
shnfifo t* shnfifD_ init(int key, int blksize, int blocks)
shnfifo_ t *fiFo■(shnfifo t *)nalloc(sizeof(shnfifo t));
assert(fifoHULL);
nenset(fifo, 0, sizeof(shnfifo_ t));
int shnid;
shnidshnget(key, 0, 0);
int size■sizeoF(shnhead t) * blksize*b1ocks;
if (shrid = -1)
fifo->shmidshnget(key, size, IPC_ CRERT | 0666);
1f (f1f0->5hm1d 中-1)
ERR_ EXIT("snnget'") ;
fifo->sen mutexsen create(key);
fifo->sen Fu11sed
}
return NULL;
}
void shnfifo_ put(shnFifo_ t *fifo, const void wbuf)
}
```

```c++
int shaid;
shmidshnget(key, 0, 0);
int size sizeoF(shnhead. t) + blksizexblocks;
if (shnid -- -1)
fifo->shmidshnget(key, size, IPC_ CREAT | 0666);
if (fifo->shmid 中-1)
ERR EXIT("shnget"");
fifo->p_ shn(shnhead_ t* )shnat( fiFo->shnid，NULL，0); .
if (fif0->p_ shm(shnhead t*)-1)
ERR EXIT("shnat");
f1f0->p_ pay1oad (char啡1f0->p. _shn + 1
fifo->sen nutexsen create(key);
fifo->sen_ full sen_ create(key+1);
fifo->sen enptysen create(key+2);
sen_ setual(fif0->sen_ nutex, 1);
sen_ setval(fif0->sen fu11, bIocks);
sen_ setual(fifo->sen_ enpty, 0);
else 
```

