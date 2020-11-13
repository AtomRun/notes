# Netty

## 什么是高性能？

1. 高并发用户（日活、同时在线）从业务角度，外部角色（用户）角度来看
2. 高吞吐量（内部角度看）
3. 低延迟

压测

```shell
wrk -c 40 -d 30s --latency http://localhost:8080/xxx
```

`-c` 压力测试模拟并发

`latency` 延迟和`response time`响应。