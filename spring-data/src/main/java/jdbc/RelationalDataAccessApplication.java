package jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@Slf4j
public class RelationalDataAccessApplication implements CommandLineRunner {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RelationalDataAccessApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.query("select * from flink.ad_stat", (rs, rowNum) -> new ad_stat(rs.getString("date"), rs.getString("province"), rs.getString("city"), rs.getInt("adid"), rs.getInt("click_count")))
                .forEach(e -> log.info(e.toString()));
    }
}
