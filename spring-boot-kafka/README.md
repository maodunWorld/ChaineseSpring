# SpringBoot整合Kafka
### YAML配置
```yaml
spring:
  kafka:
    consumer:
      bootstrap-servers: 192.168.15.102:9092 # 消费者Kakfa地址
      enable-auto-commit: false # 不自动提交offset
      group-id: test-group # 消费者组
      auto-offset-reset: earliest #offset自动重置为最早的
    producer:
      bootstrap-servers: 192.168.15.102:9092
      # key-serializer:  指定Key的序列化类
      # value-serializer:  指定Value的序列化类
    bootstrap-servers: 192.168.15.102:9092

```
### Consumer

