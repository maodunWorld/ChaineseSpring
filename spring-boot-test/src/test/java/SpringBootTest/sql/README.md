# SQL 测试中的 事务注解

## env
docker
```text

```
pom
```xml
```
yml
```yaml
```

# Commit
```java
@Commit
```
提交测试的代码的事务
# RollBack
```java
@RollBack
```
## BeforeTransaction
```java
@BeforeTransaction
void beforeTransaction() {
    // logic to be executed before a transaction is started
}
```
开启事务前。
## AfterTransaction
```java
@AfterTransaction
void afterTransaction() {
    // logic to be executed after a transaction has ended
}
```
事务之后调用的方法