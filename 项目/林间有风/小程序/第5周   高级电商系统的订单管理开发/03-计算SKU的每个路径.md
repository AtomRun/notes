# 计算SKU每个路径

 将该路径算法放到`judger`类中，有法官，判断的意思，因为要接受很多参数，所以我们可以直接接受fenceGroup

将所有可能的sku路径，装到字典中

# 逻辑

## Realm

`realm`需要new一个`judger`并且传入`fenceGroup`

```js
observers: {
    'spu':function (spu){
        if (!spu){
            return
        }
        const fenceGroup = new FenceGroup(spu)
        fenceGroup.initFences()
        const judger = new Judger(fenceGroup)
        this.bindInitData((fenceGroup))
    }
},
```

## judger

```js
/**
 *@作者 cLee
 *@创建日期 2020/8/10 9:38
 *@描述 计算sku路径的类
 */
import {SkuCode} from "./sku-code";

class Judger {

    fenceGroup
    //路径字典
    pathDict = []


    constructor(fenceGroup) {
        this.fenceGroup = fenceGroup
        this.initPathDict()
    }

    //拆解SKU路径，形成字典
    initPathDict(){
        //从code码开始拆解
        this.fenceGroup.spu.sku_list.forEach(s=>{
            const skuCode = new SkuCode(s.code)
            this.pathDict = this.pathDict.concat(skuCode.totalSegments)
        })
        console.log(this.pathDict);
    }
}

export {
    Judger
}

```

1. fenceGroup用来接收传来的每个fenceGroup，我们只取其中的sku_list
2. 将skuList循环拿出其中的code用于作为new Skucode的参数

```js
/**
 *@作者 cLee
 *@创建日期 2020/8/10 9:43
 *@描述 封装sku-code相关的逻辑
 */
import {combination} from "../utils/util";

class SkuCode {

    code
    spuId
    //当前sku所有可能组合
    totalSegments = []

    constructor(code) {
        this.code = code
        this._splitToSegments()
    }

    _splitToSegments(){
        // 2$1-44#3-9#4-14
        const spuAndSpec = this.code.split('$');
        this.spuId = spuAndSpec[0]

        const specCodeArray = spuAndSpec[1].split('#')
        //使用函数将规格组合
        const length = specCodeArray.length

        for (let i = 1;i <= length; i++){
            const segments = combination(specCodeArray,i)

            //二维数组的话表示里面有多个sku，我们再用#拼接起来
            const newSegments = segments.map(segs=>{
                return segs.join('#')
            })
            this.totalSegments = this.totalSegments.concat(newSegments)
            // console.log(newSegments);
        }
    //    尽量少写显式的for循环
    }
}

export  {
    SkuCode
}

```

1. 根据code进行$的分割，再用#进行分割拿到所有组合的sku，再组合

