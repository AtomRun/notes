# Posix消息队列

## 本章目标

- Posix消息队列相关函数
- Posix消息队列示例

## mq_open函数

- 功能:用来创建和访问-一个消息队列
- 原型
  - mqd_ t mq_ open(const char *name, int oflag); 
  - mqd_ _t mq_ open(const char *name, int oflag, mode_ t mode,struct mq_ attr *attr);
- 参数
  - name:某个消息队列的名字
  - oflag:与open函数类似，可以是O_ RDONLY、O_ _WRONLY、O_ RDWR，还可以按位或上O_ _CREAT、O__EXCL、O_ NONBLOCK等。
  - mode:如果oflag指定了0_ _CREAT,需要设置mode。
- 返回值:成功返回消息队列文件描述符;失败返回-1

![image-20200624181214523](C:\Users\clee\AppData\Roaming\Typora\typora-user-images\image-20200624181214523.png)

## mq_getattr/mq_setattr

- 功能:获取/设置消息队列属性
- 原型
  - mqd_ _t mq_ getattr(mqd_ t mqdes, struct mq_ attr *attr);
  - mqd_ _t mq_ setattr(mqd_ t mqdes, struct mq_ attr *newattr, structmq_ attr *oldattr);-
- 返回值:成功返回0;失败返回-1

![image-20200624181823140](C:\Users\clee\AppData\Roaming\Typora\typora-user-images\image-20200624181823140.png)

```c++
do
perror(m); \
exit(EXIT FATU URED; 
子whi 1e0
typedef struct stu
{
char name [32] ;
} STU;
int age;
int main(int argc, char * argv[] )
mqd t mqid;
mqid = mq open("/abc", 0_ RDONLY);
if (mqid == (mqd_ t)-1)
EKR EXI C"mq open") ;
STU stu;
uns igned prio;
f (mq_ receive(mgid, (char* )&stu, sizeof(stu), &prio) = (mqd t)-1)
ERR EXIT("'mq_ receive" ) ;
printf("name=%s_ age=%d_ prio_%u\n"， stu. name, stu.age, prio);
mq_ close (mqid);
return Q;
```

```c++
union sigval{
/* Data passed with notification */
int
sival_ _int;
/* Integer value */
void *sival_ ptr;
/* Pointer value */
};
struct sigevent {
int
sigev_ notify; /* Notification method */
int
sigev_ signo; /* Notification signal */
union sigval sigev_ value; /* Data passed with notification */
void
(*sigev_ notify function) (union sigval);
/* Function for thread notification */
void
*sigev_ notify_ attributes;
/^ Thread function attributes ^/
}
```

![image-20200624182125615](C:\Users\clee\AppData\Roaming\Typora\typora-user-images\image-20200624182125615.png)

![image-20200624182210219](C:\Users\clee\AppData\Roaming\Typora\typora-user-images\image-20200624182210219.png)