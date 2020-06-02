# QuickStart
## MockIto 使用套路   
Mock一个对象 -> 指定模拟行为（stubbing） —> 校验模拟行为后的结果 （verify）
## 理解Spy
Spy 构造的对象，如果他没有模拟行为 (stubbing) 那么他将会调用真实方法。
# 更多参考
[官方文档，写的很简洁](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)

# 关于MockIto的实现
基于ByteBuddy做的动态字节码生成，将模拟行为存于Map等集合容器，再通过ClassLoader重加载字节码文件，最后校验模拟行为的结果。