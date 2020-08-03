# SKU/SPU/规格名/规格值

SPU = Standard Product Unit（标准化产品单元）

SKU = Stock Keeping Unit（库存量单元）

## 举例

iphone11 

## SPU：商品/产品

- iphone 11
- iphone 11 pro
- iphone 11 pro max

## SKU：单品/商品

- 规格：颜色
- 运存：6G、8G、
- 版本：全网通
- 唯一：拿到手中用的手机

规格名；颜色、运存

规格值：黑色、6G

# 组件

新建`realm`组件，含义是控制SKU的选择的控制中心

`fence`组件，用来放置sku的详细规格信息

# 数据流向

数据都在服务器上，从页面加载数据，然后传到`relam`，再传到`fence`中

# 获取数据

从home中跳转到detail页面并且携带了pid，detail.js中哦我们要获取这个id，接着发送Http请求，获取到商品详情数据，然后通过setData将数据传到realm中

# 矩阵转置和旋转

旋转

- 将矩阵按照顺时针旋转

转置

- 将矩阵的某一个行号和列号互换

# 顺序

金属灰      七龙珠          小号S
青芒色      灌篮高手      中号M
青芒色      圣斗士          大号L
橘黄色      七龙珠          小号S



首先金属灰被传进来

```js
matrix.forEach((element,i,j)=>{
    if (currentJ!==j){
        currentJ = j
        //创建fence,开启新列
        fences [currentJ] = this._createFence(element)

    }
    fences[currentJ].pushValueTitle(element.value)
})
```

这里会判断生成一个新的`fence`，这个if就走完了，然后会将当前的`金属灰`推到`fences`去

然后青芒色进来，这还是同一个列，因为j第一列为0，第一次加载的时候不相等，然后j的值复制给currentJ，然后青芒色进来的时候就相等了，这个时候不会创建新的fences了，然后青芒色就被添加到fences数组中了。

到第五个七龙珠的时候，j为1，不相等，j被赋值给currentJ，然后又创建了个新的fences，这样就会保证，第一列和第二列的数据不会放到一起