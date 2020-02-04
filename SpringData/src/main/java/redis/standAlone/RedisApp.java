package redis.standAlone;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

public class RedisApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RedisConf.class);
        RedisConnectionFactory bean = ctx.getBean(RedisConnectionFactory.class);
        RedisConnection connection = bean.getConnection();
        Map<byte[], byte[]> map = connection.hGetAll("areas".getBytes());
        map.forEach((bytes, bytes2) -> System.out.println(new String(bytes) +  new String(bytes2)));
    }
}
