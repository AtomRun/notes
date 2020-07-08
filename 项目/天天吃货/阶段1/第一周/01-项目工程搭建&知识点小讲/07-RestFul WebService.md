# Restful Web Service

- 通信方式
- 信息传递
- 无状态
- 独立性

## GET

/order/{id}

/getOrder?id=1001

## POST

/order

/saveOrder

## PUT

/order/{id}

/modifyOrder

## DELETE

/order/{id}

/deleteOrder?id=1001

## 建议

不需要严格按照Restful接口标准，只要按照形式来即可，严格按照会给前后端联调带来时间成本，改造后的接口名更加易读更加易于理解