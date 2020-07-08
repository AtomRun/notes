# Posix共享内存

## 本章目标

- POSIX共享内存相关函数
- POSIX共享内存示例

## shm_open函数

- 功能:用来创建或打开一个共享内存对象
- 原型
  - int shm_ open(const char *name, int oflag, mode_ t mode);
- 参数
  - name:共享内存对象的名字
  - oflag:与open函数类似，可以是O_ RDONLY、O_ RDWR，还可以按位或.上O_ CREAT、O_ _EXCL、 O_ TRUNC等。
  - mode:此参数总是需要设置，如果oflag没有指定了O_ _CREAT, 可以指定为
- 返回值:成功返回非负整数文件描述符;失败返回-1

![image-20200624182909495](C:\Users\clee\AppData\Roaming\Typora\typora-user-images\image-20200624182909495.png)

## 获取共享内存对象信息

- 功能：获取共享内存对象信息
- 原型
  - int fastat(int fd ,struct stat *buf)
- 参数
  - fd：文件描述符
  - buf：返回共享内存状态
- 返回值
  - 成功返回0，失败返回-1

![](https://i.loli.net/2020/06/24/6XDldgxWJepk2LF.png)

![](https://i.loli.net/2020/06/24/6lHawuzAjv5P8dM.png)

![image-20200624183353833](C:\Users\clee\AppData\Roaming\Typora\typora-user-images\image-20200624183353833.png)

![](https://i.loli.net/2020/06/24/yWgmErGacfStHO9.png)