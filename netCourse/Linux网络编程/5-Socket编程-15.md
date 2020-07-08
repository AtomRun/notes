# Socket编程（十五）

## 本章目标

1. epoll使用
2. epoll与select、 pol1区别
3. epoll LT/ET模式

## epoll

- #include <sys/epoll.h>
- int epoll_ create(int size);
- int epoll_ create 1 (int flags);
- int epoll ctl(int epfd, int op, int fd, struct epoll_ event event);
- int epoll _wait(int epfd, struct epoll_ event *events, int maxevents, int timeout);

![](https://i.loli.net/2020/05/23/rFJQYilaofVn9WZ.png)

![](https://i.loli.net/2020/05/23/kZJinSTdm1QKwt2.png)

## epoll与select、poll之间的区别

- 相比于select与poll,epolI最大的好处在于它不会随着监所fd数目的增
  长而降低效率。
- 内核中的select与polI的实现是采用轮询来处理的，轮询的fd数目越多
  自然耗时越多。
- epoll的实现是基于回调的，如果fd有期望的事件发生就通过回调函数
  将其加入epoll绪队列中，也就是说它只关心“活跃”的fd， 与fd数目无
  关。
- 内核1用户空间内存拷贝问题，如何让内核把fd消息通知给用户空间
  呢?在这个问题上select/poll采取了内存拷贝方法。而epoll采用 了共
  享内存的方式。
- epoll不仅会告诉应用程序有I/0事件到来，还会告诉应用程序相关的
  信息，这些信息是应用程序滇充的，因此根据这些信息应用程序就能
  直接定位到事件，而不必遍历整个fd集合

## Epollet

- 此模式下，系统仅仅通知应用程序哪些fds变成了就绪状态，- -旦fd变 成就绪状态，epoll将不再关
  注这个fd的任何状态信息，( 从epoll队列移除)直到应用程序通过读写操作触发EAGAIN状态，epoll认为这个fd又变为空闲状态，那么epoll又重新关注这个fd的状态变化( 重新加入epolI队列)
- 随着epoll _wait的 返回，队列中的fds是在减少的
  所以在大并发的系统中，EPOLLET更 有优势。
  但是对程序员的要求也更高。

![](https://i.loli.net/2020/05/23/IgmWDUeJfYZP5Fx.png)