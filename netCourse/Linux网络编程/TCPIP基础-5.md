# TCPIP基础（五）

## 滑动窗口协议

![](https://i.loli.net/2020/04/28/4ZVWDYTz5EIy7cL.png)

- 通告接收窗口(rwnd) :预防应用程序发送的数据超过对方的缓冲区。接收方使用的流量控制
- 拥塞窗口(cwnd):预防应用程序发送的数据超过网络所能承受的能力。发送方使用的流量控制
- 发送窗口取两者较小值
- 慢启动阀值( ssthresh: slow start threshold)
- 慢启动阶段: cwnd从 1开始按指数增长直到ssthresh 
- 拥塞避免阶段: cwnd按线性增长，直到拥塞，将
  cwnd=1，ssthr esh减半

## UDP特点

1. UDP只负责将数据传输出去，不负责数据是否发送到别人那里
2. 接收方也不会发送确认，丢失也不会反馈
3. 使用UDP效率更高，因为UDP头部比TCP更简单
4. 如果使用UDP来进行可靠的数据传输，就要模拟TCP，那样反而不如TCP高效

![](https://i.loli.net/2020/05/01/s2hCcFAUgi6GOQD.png)

## UDP报文格式

![](https://i.loli.net/2020/05/01/HhQpCSUt9R7aAdg.png)



![](https://i.loli.net/2020/05/01/q9MthbATEs28CLF.png)