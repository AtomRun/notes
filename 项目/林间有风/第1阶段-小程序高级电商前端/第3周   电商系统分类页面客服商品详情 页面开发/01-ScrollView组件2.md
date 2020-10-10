# ScrollView自定义组件

## 元素属性解析

```html
<!--components/spu-scroll/index.wxml-->
<view class="container">
  <image class="title" src="{{theme.title_img}}"></image>
  <scroll-view
    enable-flex
    scroll-x
    class="scroll-view">
    <block wx:for="{{spuList}}">
      <view class="spu-container">
        <image class="spu-img" src="{{item.img}}"></image>
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

`enable-flex`表示让`scroll-view`开启flex布局

`scroll-x`表示`scroll-view`开y轴滚动条

# 通过scroll-iew抽象出的几个css编写原则

修改上述的css和html

```html
<!--components/spu-scroll/index.wxml-->
<view class="container">
  <image class="title" src="{{theme.title_img}}"></image>
  <scroll-view
    scroll-x
    class="scroll-view">
    <view class="inner">
      <block wx:for="{{spuList}}">
        <view class="spu-container">
          <image class="spu-img" src="{{item.img}}"></image>
            <l-price
                autofix
                value="{{item.price}}"
                color="#157658"
                l-value-class="price-value"
                l-unit-class="price=unit"></l-price>
          <text>{{item.title}}</text>
        </view>
      </block>
    </view>
  </scroll-view>
</view>
```

```css
/* components/spu-scroll/index.wxss */
.container {
  padding: 42rpx 0 34rpx 28rpx ;

}
.title {
  width: 694rpx;
  height: 90rpx;
}

.price-unit {
  font-size: 28rpx !important;
}
.price-value {
  font-size: 32rpx !important;
}
.spu-img {
  width: 160rpx;
  height: 160rpx;
}

.spu-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-right: 60rpx;
}

.scroll-view {
  margin-top: 28rpx;
  display: flex;
  flex-direction: row;
}

.inner {
  display: flex;
  flex-direction: row;
}
```

# WXS与小程序的内核简介

> 使用wxs对长度大于x的字符进行截断并且显示为...的处理

wx也是JavaScript

问：为什么会出现两种javascript？

1. 因为小程序的逻辑层和渲染层，是分离的环境
2. wxs的代码是运行在视图层的，js代码运行在逻辑层

问：两者的区别？

1. wxs只支持ES5，js支持到ES6/7

小程序的运行原理

两种环境：IOS/Android

其实本质还是Web技术为驱动，每个操作系统都要有宿主环境



# WXS和LinUIFilter的运用

使用wxs处理themeE的商品标题，让标题超过一定字数变为...

## CSS方式

```css
.spu-text {
  font-size: 20rpx;
  color: #666666;
  margin-top: 20rpx;

  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
```

### 效果

![](https://i.loli.net/2020/07/31/A8DiJ6RtFeTxZQm.png)

无论标题多长，都不会换行，也没有省略的效果，为什么呢？

这段CSS如果想要做省略，基本的要求就是text组件的宽度要是固定的，上面并没有固定，不固定的话，text组件会被文本给撑开的，所以不会省略，假设我们给`width:150rpx`的话，效果如下

![](https://i.loli.net/2020/07/31/354h98VcPCUnlfp.png)

但是问题是文字不居中，是因为我们设置的组件是居中的，但是文字不是居中的。

## 使用WXS+LinUIFilter的方式

### 引入WXS

```html
<wxs src="../../miniprogram_npm/lin-ui/filter/string.wxs" module="s"></wxs>
```

### 使用

```html
<text class="spu-text">{{item.title.length>=8?s.substring(item.title,0,7)+'...':item.title}}</text>
```

# 细节打磨

> 设置组件之间的边距

## 第一种方式，直接设置activityD的下边距

```css
.activity {
    margin-top: 20rpx;
    width: 100%;
    height: 310rpx;
    display: flex;
    /*margin-bottom: 20rpx;*/
}
```

还要设置他的背景色

```css
.container {
  padding: 42rpx 0 34rpx 28rpx ;
  background-color: #ffffff;
}
```

## 第二种方式，使用外部样式类

自定义组件s-spu-scroll设置class无效，因为是自定义组件，我们可以设置外部样式类

如果要给一个自定义组件一个外部样式类，我们需要在js文件下的Component下定义一个属性

`externalClasses:[]`是一个数组，每一个元素都代表我们定义的外部样式类，文字由我们自己定义

需要外部样式类是因为，有时候组件的样式并不是我们自己要写死的，而是由外部使用的人来设置，所以就像定义属性，用来接受某些设置

### 设置

```html
<view class="container l-class" >
```

container 原有的样式和l-class传入的样式都会被作用到这里

### 调用

```html
<s-spu-scroll
  l-class="spu-scroll"
  theme="{{themeE}}"
  spu-list="{{themeESpu}}"
  wx:if="{{themeE.online}}">
</s-spu-scroll>
```

```css
.spu-scroll {
  margin-top: 20rpx;
}
```

## 第三种方式，使用View包裹自定义组件

```html
<view class="spu-scroll">
    <s-spu-scroll
        theme="{{themeE}}"
        spu-list="{{themeESpu}}"
        wx:if="{{themeE.online}}">
    </s-spu-scroll>
</view>
```

这里我们使用第一种方案

