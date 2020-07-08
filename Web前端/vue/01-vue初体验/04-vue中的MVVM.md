#什么是MVVM？
- Model ViewModel View
> ViewModel相当于Model和View之间的桥梁，为两者进行通信
- 这里的Model可以看成Plain JavaScript Object，ViewModel可以看成Vue实例，View可以看成DOM，Vue为两者通信
- ViewModel做了两件事
    - 第一件事：数据绑定，将JS定义的数据通过ViewModel解析，展示在View上，因为是响应式的，如果数据发生改变，就会监听到并且将数据更新给View
    - 第二件事：当View中有数据发生改变或者用户操作的时候，ViewModel会将这些响应返回给ViewModel中。
    