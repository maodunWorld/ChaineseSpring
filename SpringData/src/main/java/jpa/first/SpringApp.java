package jpa.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringApp.class, args);
        AdStatRepo bean = ctx.getBean(AdStatRepo.class);
        Optional<ad_stat> byId = bean.findById(22);
        ad_stat adStat = byId.get();
        System.out.println(adStat);

    }
}
