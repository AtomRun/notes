# 引入Icon

```json
"l-icon": "/miniprogram_npm/lin-ui/icon/index"
```

## 使用linUI内置图标

```html
<l-icon name="cart" size="40" color="#157658"></l-icon>
```

## 使用外部alibab图标

放到全局css中

```css
/*!**app.wxss**!*/
/*.container {*/
/*  height: 100%;*/
/*  display: flex;*/
/*  flex-direction: column;*/
/*  align-items: center;*/
/*  justify-content: space-between;*/
/*  padding: 200rpx 0;*/
/*  box-sizing: border-box;*/
/*} */
page {
    background-color: #f5f5f5;
}

@font-face {
    font-family: 'wind';  /* project id 2003226 */
    src: url('//at.alicdn.com/t/font_2003226_4k8joupig6.eot');
    src: url('//at.alicdn.com/t/font_2003226_4k8joupig6.eot?#iefix') format('embedded-opentype'),
    url('//at.alicdn.com/t/font_2003226_4k8joupig6.woff2') format('woff2'),
    url('//at.alicdn.com/t/font_2003226_4k8joupig6.woff') format('woff'),
    url('//at.alicdn.com/t/font_2003226_4k8joupig6.ttf') format('truetype'),
    url('//at.alicdn.com/t/font_2003226_4k8joupig6.svg#wind') format('svg');
}

.wind {
    font-family: wind !important;
    font-size: 160rpx !important;
    color: #157658 !important;
}

.l-icon-home:before {
    content: "\e656;";
}

```

```html
<l-icon name="home" l-class="wind"></l-icon>
```

