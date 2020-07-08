# 认识Flex布局

- flex布局是 目前web开发中使用最多的布局方案: 
  - flex 布局( Flexible布局,弹性布局)
  - 目前特别在移动端用的最多,目前PC端也使用越来越多了
- 两个重要的概念:
  - 开启了flex布局的元素叫**flex container**
  - flex container里面的直接子元素叫做**flex items**
- 设置display属性为flex或者inline-flex可以成为**flex container**
  - flex : flex container以block-level形式存在(块级元素，独自占用一行)
  - inline-flex : flex container以inline-level形式存在（行内元素，多元素在同一行）

## Flex布局模型

![](https://i.loli.net/2020/05/02/pGdeM4Z3xEcCAlV.png)

## Flex相关的属性

> 应用在flex container.上的CSS属性

### flex-direction

flex items默认都是沿着main axis (主轴)从main start开始往main end方向排布flex-direction决定了main axis的方向,有4个取值

- row (默认值)从左到右
- row-reverse (row反转主轴从右到左)
-  column（主轴从上到下）
- column-reverse（主轴从下到上）

![](https://i.loli.net/2020/05/02/BbF4DqcHaj5EKsP.png)

### flex-flow

### flex-wrap

### justify-content

- justify-content决定了flex items在main axis上的**对齐方式**
  - flex-start (默认值) :与main start对齐
  - flex-end :与main end对齐
  - center :居中对齐
  - space-between :
    - flex items之间的距离相等
    - 与main start、 main end两端对齐
  - space-evenly :
    - flex items之间的距离相等
    - flex items与main start、main end之间的距离等于flex items之间的距离
  - space-around :
    - flex items之间的距离相等
    - flex items与main start、main end之间的距离是flex items之间距离的一半

### align-items

- align-items决定了flex items在cross axis. 上的对齐方式
  - normal :在弹性布局中,效果和stretch-样
  - stretch :当flex items在cross axis方向的size为auto时,会自动拉伸至填充flex container
  - flex-start :与cross start对齐
  - flex-end :与cross end对齐
  - center :居中对齐
  - baseline :与基准线对齐

### align-content

## Flex-wrap

> flex-wrap决定了flex container是单行还是多行

- nowrap( 默认) :单行
- wrap:多行
- wrap-reverse :多行(对比wrap，cross start与cross end相反)

![](https://i.loli.net/2020/05/02/I91ZTalC5YEUPy8.png)

- flex-flow是flex-direction I| flex-wrap的简写
  - 可以省略,顺序任意

## align-content

>  align-content决定了多行flex items在cross axis. 上的对齐方式,用法与justify-content类似

- stretch (默认值) :与align-items的stretch类似
- flex-start :与cross start对齐
- flex-end :与cross end对齐
- center :居中对齐
- space-between :
  - flex items之间的距离相等
  - 与cross start、 cross end两端对齐
- space-around :
  - flex items之间的距离相等
  - flex items与cross start、cross end之间的距离是flex items之间距离的一半
- space-evenly :
  - flex items之间的距离相等
  - flex items与cross start、cross end之间的距离等于flex items之间的距离

## order

- order决定了flex items的排布顺序
  - 可以设置任意整数(正整数、唤整数、0 ) , 值越小就越排在前面
  - 默认值是0

## align-self

- flex items可以通过align-self 覆盖flex container设置的aligla-items
- auto (默认值) :遵从flex container的align-items设置
- stretch、 flex-start、 flex-end、 center. baseline ,效果跟align-items - -致

## flex-grow

- flex-grow决定了flex items如何扩展
  - 可以设置任意非负数字(正小数、正整数、0) ,默认值是0
  - 当flex container在main axis方向上有剩余size时, flex-grow属性才会有效
- 如果所有flex items的flex-grow总和sum超过1 ,每个flex item扩展的size为
  - flex container的剩余size * flex-grow / sum
- 如果所有flex items的flex-grow总和不超过1 ,每个flex item扩展的size为
  - flex container的剩余size * flex-grow

## flex-shrink

- flex-shrink决定了flex items如何收缩
  - 可以设置任意非负数字(正小数、正整数、0) , 默认值是1
  - 当flex items在main axis方向上超过了flex container的size , flex-shrink属性才会有效
- 如果所有flex items的flex-shrink总和超过1 ,每个flex item收缩的size为
  -  flex items超出flex container的size *收缩比例/所有flex items的收缩比例之和
- 如果所有flex items的flex-shrink总和sum不超过1 ,每个flex item收缩的size为
  - flex items超出flex container的size * sum *收缩比例/所有flex items的收缩比例之和
  - 收缩比例= flex-shrink * flex item的base size
  - base size就是flex item放入flex container之前的size
- flex items收缩后的最终size 不能小于min-width\min-height

## flex-basis

- flex-basis用来设置flex items在main axis方向.上的base size
  - auto (默认值)、具体的宽度数值( 100px )
- 决定flex items最终base size的因素,从优先级高到低
  - max-width\max-heightmin-width\min-height
  - flex-basis
  - width\height
  - 内容本身的size

## flex

- flex是flex-grow || flex-shrink |I flex-basis的简写,flex属性可以指定1个, 2个或3个值
- 单值语法:值必须为以下其中之一:
  - 一个无单位数( <number>):它会被当作<flex-grow>的值。
  - 一个有效的宽度(width)值:它会被当作<flex-basis>的值。
  - 关键字none , auto或initial.