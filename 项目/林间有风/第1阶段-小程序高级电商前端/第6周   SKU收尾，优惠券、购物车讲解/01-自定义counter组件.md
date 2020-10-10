# 自定义counter组件

```php+HTML
<l-counter
    l-count-class="all-background input-size"
    l-symbol-class="all-background font-color"
    l-disabled-class="all-background"
    l-class="container"
    count="{{count}}"
    min="{{min}}"
    max="{{max}}"
    bind:linout="onOverStep">
</l-counter>
```

```js
// components/counter/index.js
import {Cart} from "../../models/cart";

Component({
    /**
     * 组件的属性列表
     */
    properties: {
        count: {
            value:Cart.SKU_MIN_COUNT,
            type:Number
        },
        min:{
            type:Number,
            value: Cart.SKU_MIN_COUNT
        },
        max:{
            type:Number,
            value: Cart.SKU_MAX_COUNT
        }
    },

    /**
     * 组件的初始数据
     */
    data: {},

    /**
     * 组件的方法列表
     */
    methods: {
        onOverStep(event){
            const minOrMaxOut = event.detail.type
            if (minOrMaxOut == 'overflow_max'){
                wx.showToast({
                    icon:'none',
                    duration:3000,
                    title:`超出最大购买数量`
                })
            }
            if(minOrMaxOut == 'overflow_min'){
                wx.showToast({
                    icon:'none',
                    duration:3000,
                    title:`最少需要购买${Cart.SKU_MIN_COUNT}件`
                })
            }
        }
    }
})

```

