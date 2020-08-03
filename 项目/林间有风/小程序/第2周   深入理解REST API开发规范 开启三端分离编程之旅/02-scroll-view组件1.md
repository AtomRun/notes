# Scroll-View组件运用

## 新建组件

新建`spu-scroll`组件并且

```js
properties: {
    //这个组件依赖theme
    theme:Object,
    spu_list:Array
},
```

## 方法是否要加static？

方法可以加也可以不加，衡量标准是，你是否要保存状态，即实例和类的区别

`Theme`在被调用的时候已经被实例化了，所以我们可以不用加static

```js
//获取E位置的Spu信息
async getHomeLocationESpu(){
    return this.getThemeSpuByName(Theme.locationE)
}

async getThemeSpuByName(name){
    return await Http.request({
        url:`theme/name/${name}/with_spu`
    })
}
```

webStorm如果看到你方法中没有实例相关的属性，那么它就推荐你将方法设置为静态的

```js
  //获取E位置的Spu信息
  static async getHomeLocationESpu(){
    return Theme.getThemeSpuByName(Theme.locationE)
  }

  static async getThemeSpuByName(name){
    return await Http.request({
      url:`theme/name/${name}/with_spu`
    })
  }
```

## 调用该方法

```js
  //获取E位置的Spu信息
  static async getHomeLocationESpu(){
    return Theme.getThemeSpuByName(Theme.locationE)
  }

  static async getThemeSpuByName(name){
    return await Http.request({
      url:`theme/name/${name}/with_spu`
    })
  }
```

上述的代码的`async`和`await`可以去掉，因为请求之后不需要等待再进行下一步的处理，所以不需要await，但是如下调用的时需要await，因为我们要等待这个结果，后面要做数据绑定。

```js
const themeESpuList = await Theme.getHomeLocationESpu()
```

**为什么不用加`async`?**

因为`async`是强制保证方法到最后必须返回Promise，上述的两个方法不需要，因为Http.request本身就是返回的是promise，我们就不需要`async`再来包装一次了

## ScrollView组件

小程序的View不会自动出现滚动条，使用ScrollView可以让view出现滚动条

# 组件逻辑

## 规定组件依赖的参数

```js
/**
   * 组件的属性列表
   */
properties: {
    //这个组件依赖theme
    theme:Object,
        spuList:Array
},
```

## 获取值，设置值

```js
const themeE = await theme.getHomeLocationE()

let themeESpu = []
//先判断是否是online，不是就不发请求了
if (themeE.online){
    const data = await Theme.getHomeLocationESpu()
    if (data){
        themeESpu = data.spu_list.slice(0,8);
    }
}

const bannerB = await Banner.getHomeLocationB()
const grid = await Category.getHomeLocationC()
const activityD = await Activity.getHomeLocationD()
//等所有数据都渠道之后，进行一次性的setData，即上面这两条数据不要进行分开的setData
//永远要保证调用方的调用过程是简单的
this.setData({
    themeA,
    themeE,
    themeESpu,
    bannerB,
    grid,
    activityD
})
```

`themeE`的数据拿到后，先进行`online`的筛选，然后，放进data中，然后判断data是否存在，如果存在我们使用slice分割8条放到`themeESpu`数组中

themeE也要传给组件，`theme`像是简单的描述，主要对描述数据进行封装，`themeESpu`则是通过`themeE`中的数据去查找获得的`themeE`的详情数据

![](https://i.loli.net/2020/07/30/dfCPSvGDiKYcUL1.png)

获取themeE的SPU信息

```js
//获取E位置的Spu信息
static getHomeLocationESpu(){
    return Theme.getThemeSpuByName(Theme.locationE)
}

static getThemeSpuByName(name){
    return Http.request({
        url:`theme/name/${name}/with_spu`
    })
}
```

使用上面获取的SPU信息的接口将themeA的详细数据获取到

```js
const data = await Theme.getHomeLocationESpu()
```

# 使用组件

```html
<s-spu-scroll
    theme="{{themeE}}"
    spu-list="{{themeESpu}}"
    wx:if="{{themeE.online}}">
</s-spu-scroll>
```

判断online才会展示，并且将theme和spu-list赋值给组件

# 组件接收

```html
<!--components/spu-scroll/index.wxml-->
<view class="container">
  <image class="title" src="{{theme.title_img}}"></image>
  <scroll-view>
    <block wx:for="{{spuList}}">
      <view>
        <image src="{{item.img}}"></image>
          <l-price
              autofix
              value="{{item.price}}"
              color="#157658"
              l-value-class="price-value"
              l-unit-class="price=unit"></l-price>
        <text>{{item.title}}</text>
      </view>
    </block>
  </scroll-view>
</view>
```

# 组件CSS

```CSS
/* components/spu-scroll/index.wxss */
.title {
  width: 692rpx;
  height: 90rpx;
}

.price-unit {
  font-size: 28rpx !important;
}
.price-value {
  font-size: 32rpx !important;
}

```

## CSS权重

`!important`是设置css的优先级

