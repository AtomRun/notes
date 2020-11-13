# HashSet

## 类注释

1. 底层实现基于 HashMap，所以迭代时不能保证按照插入顺序，或者其它顺序进行迭代；
2. add、remove、contanins、size 等方法的耗时性能，是不会随着数据量的增加而增加的，这个主要跟 HashMap 底层的数组数据结构有关，不管数据量多大，不考虑 hash 冲突的情况下，时间复杂度都是 O (1)；
3. 线程不安全的，如果需要安全请自行加锁，或者使用 Collections.synchronizedSet；
4. 迭代过程中，如果数据结构被改变，会快速失败的，会抛出 ConcurrentModificationException 异常。

## HashSet如何使用HashMap作为底层的？

1. 使用继承的方式
   1. 表示和父类是同一种事务，而Set和Map就是想表达两种事务，所以继承不妥，Java语言语法限制，只能继承一个类，影响后续扩展。
2. 使用组合的方式
   1. 将HashMap作为一个成员变量组合到HashSet中。组合更加灵活，可以任意的组合现有的基础类，并且可以在基础类方法的基础上进行扩展、编排等，而且方法命名可以任意命名，无需和基础类的方法名称保持一致。

```java
// 把 HashMap 组合进来，key 是 Hashset 的 key，value 是下面的 PRESENT
private transient HashMap<E,Object> map;
// HashMap 中的 value
private static final Object PRESENT = new Object();
```

1. 我们在使用 HashSet 时，比如 add 方法，只有一个入参，但组合的 Map 的 add 方法却有 key，value 两个入参，相对应上 Map 的 key 就是我们 add 的入参，value 就是第二行代码中的 PRESENT，此处设计非常巧妙，用一个默认值 PRESENT 来代替 Map 的 Value；
2. 如果 HashSet 是被共享的，当多个线程访问的时候，就会有线程安全问题，因为在后续的所有操作中，并没有加锁。

HashSet 在以 HashMap 为基础进行实现的时候，首先选择组合的方式，接着使用默认值来代替了 Map 中的 Value 值，设计得非常巧妙，给使用者的体验很好，使用起来简单方便，我们在工作中也可以借鉴这种思想，可以把底层复杂实现包装一下，一些默认实现可以自己吃掉，使吐出去的接口尽量简单好用。

## 初始化

```java
public HashSet(Collection<? extends E> c) {
    map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
    addAll(c);
}
```

这里初始化的时候直接new了一个HashMap，并且容量设置为c/0.75+1和16取参数最大的一个

1. 和 16 比较大小的意思是说，如果给定 HashMap 初始容量小于 16 ，就按照 HashMap 默认的 16 初始化好了，如果大于 16，就按照给定值初始化。
2. HashMap 扩容的伐值的计算公式是：Map 的容量 * 0.75f，一旦达到阀值就会扩容，此处用 (int) (c.size ()/.75f) + 1 来表示初始化的值，这样使我们期望的大小值正好比扩容的阀值还大 1，就不会扩容，符合 HashMap 扩容的公式。

# TreeSet

底层组合的是TreeMap，所以继承了 TreeMap key 能够排序的功能，迭代的时候，也可以按照 key 的排序顺序进行迭代，我们主要来看复用 TreeMap 时，复用的两种思路：

### 1.复用 TreeMap 的思路一

场景一： TreeSet 的 add 方法，我们来看下其源码：

```java
public boolean add(E e) {
    return m.put(e, PRESENT)==null;
}
```

可以看到，底层直接使用的是 HashMap 的 put 的能力，直接拿来用就好了。

#### 2.复用 TreeMap 的思路二

场景二：需要迭代 TreeSet 中的元素，那应该也是像 add 那样，直接使用 HashMap 已有的迭代能力，比如像下面这样：

```java
// 模仿思路一的方式实现
public Iterator<E> descendingIterator() {
    // 直接使用 HashMap.keySet 的迭代能力
    return m.keySet().iterator();
}
```

这种是思路一的实现方式，TreeSet 组合 TreeMap，直接选择 TreeMap 的底层能力进行包装，但 TreeSet 实际执行的思路却完全相反，我们看源码：

```java
// NavigableSet 接口，定义了迭代的一些规范，和一些取值的特殊方法
// TreeSet 实现了该方法，也就是说 TreeSet 本身已经定义了迭代的规范
public interface NavigableSet<E> extends SortedSet<E> {
    Iterator<E> iterator();
    E lower(E e);
}  
// m.navigableKeySet() 是 TreeMap 写了一个子类实现了 NavigableSet
// 接口，实现了 TreeSet 定义的迭代规范
public Iterator<E> iterator() {
    return m.navigableKeySet().iterator();
}
```