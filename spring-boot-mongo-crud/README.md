# SpringBoot整合Mongo，整合内嵌Mongo

## 内嵌 Mongo 用于单元测试



## Mongo 
### 不用建表，先配置YAML文件
```yaml
# mongo配置
spring:
  data:
    mongodb:
      uri: mongodb://192.168.15.102:27017
      database: myDB
      username: admin
      password: 123456
      auto-index-creation: on #自动创建索引
      field-naming-strategy: org.springframework.data.mapping.model.SnakeCaseFieldNamingStrategy # 字段映射关系， 如TestDoc映射为testDod表，creatorId映射为creator_id
      # authentication-database: 认证服务器地址
      # grid-fs-database: grid-fs地址

  jackson:
    # 时区，字符串格式化
    time-zone: GMT+8
    date-format: "yyyy-MM-dd HH:mm:ss"
```
### 依次定义Pojo,Dao,Service,Controller
参考代码,SpringData将根据Pojo自动生成对应Mongo表，无须手动建表。

### Create操作
插入一个字段
```java
TestDoc testDoc = new TestDoc();
Date time = new Date();
testDoc.setCreateTime(time);
testDoc.setCreatorId("maodun");
testDoc.setDocCode(UUID.randomUUID().toString());
testDoc.setDocText(UUID.randomUUID().toString());
testDocDao.insert(testDoc);
```
### 尝试