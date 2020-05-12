package redis.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

@SpringBootApplication
public class RedisApp implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(RedisApp.class, args);
    }

    @Autowired
    RedisTemplate<String , String > redisTemplate;

    @Override
    public void run(String... args) throws Exception {
        Map<Object, Object> areas = redisTemplate.opsForHash().entries("areas");
        areas.forEach((k, v) -> System.out.println(k + "---" + v));
    }
}
