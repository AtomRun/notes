# ArrayList&LinkedList

# ArrayList

### 扩容

```java
public boolean add(E e) {
  //确保数组大小是否足够，不够执行扩容，size 为当前数组的大小
  ensureCapacityInternal(size + 1);  // Increments modCount!!
  //直接赋值，线程不安全的
  elementData[size++] = e;
  return true;
}
```

size在我们无参初始化ArrayList的时候，size为0，这里`ensureCapacityInternal`方法的是判断是否要扩容

```java
private void ensureCapacityInternal(int minCapacity) {
  //如果初始化数组大小时，有给定初始值，以给定的大小为准，不走 if 逻辑
  if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
    minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
  }
  //确保容积足够
  ensureExplicitCapacity(minCapacity);
}
```

如果初始化给定了初始值` elementData = c.toArray();`这句赋值，` elementData`就不为空不会走if语句，假设没给初始值，即 elementData和默认空相等，那就将minCapacity的值和默认数组容量10比较，取最大值。也就是说，如果是第一次put，那么size会直接扩容到10。

### 判断容量是否足够

```java
private void ensureExplicitCapacity(int minCapacity) {
  //记录数组被修改
  modCount++;
  // 如果我们期望的最小容量大于目前数组的长度，那么就扩容
  if (minCapacity - elementData.length > 0)
    grow(minCapacity);
}
```

将`minCapacity`拿过来，如果是第一次put就是根据前面的推算 minCapacity就是10。如果是初始化的时候，添加了一个值，那么这里的minCapacity就是2

modCount++是快速失败的作用，用来记录多线程情况下快速失败提升性能 //todo

这里的minCapacity是我们的最小期望值，即假设原来ArrayList中就一个数据，现在我们+1(因为put的时候size+1)，这个时候elementData.length 还是之前的size，所以现在的minCapacity-elementData.length 肯定是大于0的。所以要调用下面的扩容函数。(第一次初始化ArrayList设置值的情况)

假设我们无参初始化ArrayList的情况下，minCapacity还是10，一样会扩容的。

### 扩容函数

```java
//扩容，并把现有数据拷贝到新的数组里面去
private void grow(int minCapacity) {
  int oldCapacity = elementData.length;
  // oldCapacity >> 1 是把 oldCapacity 除以 2 的意思
  int newCapacity = oldCapacity + (oldCapacity >> 1);

  // 如果扩容后的值 < 我们的期望值，扩容后的值就等于我们的期望值
  if (newCapacity - minCapacity < 0)
    newCapacity = minCapacity;

  // 如果扩容后的值 > jvm 所能分配的数组的最大值，那么就用 Integer 的最大值
  if (newCapacity - MAX_ARRAY_SIZE > 0)
    newCapacity = hugeCapacity(minCapacity);
 
  // 通过复制进行扩容
  elementData = Arrays.copyOf(elementData, newCapacity);
}
```

首先将之前的length赋值给参数`oldCapacity`，即没扩容前的容量大小。再用之前的容量加上，之前的容量/2。

假设这是第一次put(之前初始化的时候是空参初始化)，minCapacity为10，oldCapacity为0，这个时候newCapacity也为0，newCapacity-minCapacity小于0，minCapacity就赋值给new，那么就调用copyOf方法，容量为10。

假设是初始化的时候放置了数据进去，那么size就是数据的个数

# LinkedList

