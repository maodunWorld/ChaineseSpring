# Prometheus + grafana的小练习
* java PrometheusPracticeApp, 对应配置文件prometheus.yml
```yaml
server:
  port: 8081
management:
  endpoints:
    web:
      exposure:
        include: "prometheus"
  metrics:
    export:
      influx:
        enabled: false
    tags:
      application: ${spring.application.name}
  endpoint:
    prometheus:
      enabled: true
spring:
  application:
    name: springboot-promethues
```