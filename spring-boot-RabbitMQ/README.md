# YAML 配置
```text
docker pull rabbitmq:management
docker run -d --hostname my-rabbit --name rabbit -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin -p 15672:15672 -p 5672:5672 -p 25672:25672 -p 61613:61613 -p 1883:1883 rabbitmq:management

#5672为程序接入接口，15672为后台WebUI接入口。
```
```yaml
spring:
  rabbitmq:
    host: 192.168.15.102
    port: 5672
```

# 收

# 发


# 事务