# Synchronized

## Synchronized的作用

同步方法支持一种简单的策略来防止线程干扰和内存一致性错误:如果一个对象对多个线程可见,则对该对象变量的所有读取或写入都是通过同步方法完成的。

能够保证在**同一时刻**最多只有**一个**线程在执行该段代码，以达到保证并发安全的效果。

## Synchronized的地位

- Synchronized是java的关键字，被java语言原生支持
- 是最基本的互斥同步手段
- 是并发编程中的元老级别，是并发编程的必学内容

## 不使用并发手段会发生什么后果？

### 代码实战:两个线程同时a++ ,最后结果会比预计的少

```java
/**
 * @ClassName DisppearRequest1
 * @Description 消失的请求
 * @Author clee
 * @Date 2020/7/18 10:40
 * @Version 1.0
 **/
public class DisappearRequest1 implements Runnable{

    static DisappearRequest1 instance = new DisappearRequest1();

    static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        //在一个线程中调用 other.join() ，
        // 这时候当前线程会让出执行权给 other 线程，
        // 直到 other 线程执行完或者过了超时时间之后再继续执行当前线程
        t1.join();
        t2.join();

        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }
}
```

结果为：190653，与预期不符。

## 造成这种结果的原因

count++，看上去只有一个操作，但其实，包含了三个动作

1. 读取count
2. count+1
3. count的值写入内存

两个线程争抢执行资源，当一个线程没执行完被另一个抢走的时候count值会发生变化

## Synchronized的两个用法

1. 对象锁

   包括**方法锁(默认锁对象为this当前实例对象)**和**同步代码块锁(自己指定锁对
   象)**

   1. 代码块形式:手动指定锁对象

   ```java
   /**
    * @ClassName SynchronizedObjectCodeBlock2
    * @Description 对象锁示例1，代码块形式
    * @Author clee
    * @Date 2020/7/18 15:21
    * @Version 1.0
    **/
   public class SynchronizedObjectCodeBlock2 implements Runnable{
   
   
       static SynchronizedObjectCodeBlock2 instance = new SynchronizedObjectCodeBlock2();
   
       public static void main(String[] args) throws InterruptedException {
   
           Thread t1 = new Thread(instance);
           Thread t2 = new Thread(instance);
           t1.start();
           t2.start();
           t1.join();
           t2.join();
           while (t1.isAlive() || t2.isAlive()){
   
           }
           System.out.println("finished");
       }
   
       @Override
       public void run() {
           //让代码串行执行，不能让多个线程同时执行
           synchronized (this){
   
               System.out.println("我是对象锁的代码块形式，我叫"+Thread.currentThread().getName());
               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName()+"运行结束。");
           }
       }
   }
   
   ```

   执行结果

   ```java
   SynchronizedObjectCodeBlock2
   我是对象锁的代码块形式，我叫Thread-0
   Thread-0运行结束。
   我是对象锁的代码块形式，我叫Thread-1
   Thread-1运行结束。
   finished
   
   Process finished with exit code 0
   
   ```

   

   1. 方法锁形式: synchronized修饰普通方法,锁对象默认为this

2. 类锁

   1. 指synchronized修饰**静态**的方法或指定锁为**Class对象**。

