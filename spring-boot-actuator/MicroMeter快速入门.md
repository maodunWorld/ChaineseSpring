# 代码在 MircoMeterLearn 单元测试下

# Registry （metrics的上下文中心）
```java
    /**
     * 最简单的注册中心
     */ 
    @Test
    public void test1() {
        SimpleMeterRegistry simpleMeterRegistry = new SimpleMeterRegistry();
        log.info(simpleMeterRegistry.toString());
    }

    /**
     * 复杂的注册中心，复杂注册中心中会维护一个简单注册中心的列表
     */
    @Test
    void test2() {
        CompositeMeterRegistry compositeMeterRegistry = new CompositeMeterRegistry();
        // 初始化一个Counter，并且我们可以将Counter打上一个或多个多个标签。
        // 简单理解Couter为一个计数器
        Counter couter1 = compositeMeterRegistry.counter("couter1");
        couter1.increment();
        SimpleMeterRegistry simple = new SimpleMeterRegistry();
        compositeMeterRegistry.add(simple);
        couter1.increment();
        // Couter只是接口 ，实现类有Dropwizard这种Metrics库
        log.info(String.valueOf(couter1.count()));
    }

    /**
     * 静态全局的注册中心
     */
    @Test
    void test3() {
        Metrics.addRegistry(new SimpleMeterRegistry());
    }
```
# Meter 度量单位 字面意思去理解即可
```java
Timer，Counter，Gauge，DistributionSummary，LongTaskTimer，FunctionCounter，FunctionTimer
```
# 命名规则
通过实现NamingConvention接口，并在注册中心注册，完成自定义名称转换。
```java
registry.config().namingConvention(myCustomNamingConvention);
```
```java
 Metrics.counter("database.call", "db", "users");
// 在InfluxDb和Prometheus中转换为 database_call_db_users
```

# Meter的用法
## Gounter
```java
    @Data
    class TestCase {
        private String code1;
        private String code2;
    }

    static {
        Metrics.addRegistry(new SimpleMeterRegistry());
    }

    /*
    couter 是计数器
     */
    @Test
    void couter() {
        TestCase testCase = new TestCase();
        testCase.setCode1("code1");
        testCase.setCode2("code2");
        addCouter(testCase);
        TestCase testCase1 = new TestCase();
        testCase1.setCode1("code12");
        testCase1.setCode2("code22");
        addCouter(testCase1);
        Search.in(Metrics.globalRegistry).meters().forEach(e -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("code1:")
                    .append(e.getId().getName())
                    .append(",tags:")
                    .append(e.getId().getTags())
                    .append(",type:").append(e.getId().getType())
                    .append(",value").append(e.measure());
            System.out.println(stringBuilder.toString());
        });
    }

    private void addCouter(TestCase testCase) {
        Metrics.counter("testcouter", Arrays.asList(Tag.of("code1", testCase.getCode1()), Tag.of("code2", testCase.getCode2()))).increment();
    }
```
通过Build模式构建Counter
```java
 Counter counter = Counter
                .builder("counter")
                .baseUnit("beans") // optional
                .description("a description of what this counter does") // optional
                .tags("region", "test") // optional
                .register(Metrics.globalRegistry);
```
## FunctionCouter 带函数操作的Counter
简单使用
```java
    /*
    functionCouter使用
     */
    @Test
    void test3() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        FunctionCounter register = FunctionCounter.builder("testFunCouter", atomicInteger, new ToDoubleFunction<AtomicInteger>() {
            @Override
            public double applyAsDouble(AtomicInteger value) {
                return value.get();
            }
        }).baseUnit("func")
                .description("funcCouter")
                .tag("funcK", "funcV")
                .register(Metrics.globalRegistry);
        atomicInteger.incrementAndGet();
        atomicInteger.incrementAndGet();
        log.info("couter is" + register.count());
        log.info("atomic is" + atomicInteger.get());
    }
```
## Gauges 你可以理解为一个状态快照，类比汽车的速度表
创建Gauge的方式
```java
    /*
    Gauges
     */
    @Test
    void test4() {
        ArrayList<Object> listGauge = Metrics.globalRegistry.gauge("listGauge", Collections.emptyList(), new ArrayList<>(), List::size);
        ArrayList<Object> listSize2 = Metrics.globalRegistry.gaugeCollectionSize("ListSize2", Tags.empty(), new ArrayList<>());
        HashMap<Object, Object> mapGauge = Metrics.globalRegistry.gaugeMapSize("mapGauge", Tags.empty(), new HashMap<>());
        // maintain a reference to myGauge
        AtomicInteger myGauge = Metrics.globalRegistry.gauge("numberGauge", new AtomicInteger(0));

// ... elsewhere you can update the value it holds using the object reference
        myGauge.set(27);
        myGauge.set(11);

        // 通过
    }
```
## Timer 定时度量，而Guava里的Stopwatch是计时器
```java
 Timer register = Timer.builder("my.timer")
                .description("test timer")
                .tag("region", "test")
                .register(Metrics.globalRegistry);
```
Function-tracking timers, 和函数Counter一样，可以通过函数调用完成度量。
```java
IMap<?, ?> cache = ...; // suppose we have a Hazelcast cache
registry.more().timer("cache.gets.latency", Tags.of("name", cache.getName()), cache,
    c -> c.getLocalMapStats().getGetOperationCount(), (1)
    c -> c.getLocalMapStats().getTotalGetLatency(),
    TimeUnit.NANOSECONDS (2)
);
```
##  Distribution summaries 聚合度量
```java
DistributionSummary summary = DistributionSummary
    .builder("response.size")
    .description("a description of what this summary does") // optional
    .baseUnit("bytes") // optional (1)
    .tags("region", "test") // optional
    .scale(100) // optional (2)
    .register(registry);
```
// TODO

## Histograms and percentiles
// TODO