package com.maodun;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author maodunWorld
 * @date 2020/5/26 15:52
 */
@ConfigurationProperties("robot")
@Data
@ToString
public class RobotProperties {
    private String id;
    private String item;
    @Value("${robot.interval.hour.list}")
    private String interval;
    @Value("${robot.server.ip}")
    private String ip;
    private qqPropperties qq = new qqPropperties();

    @Data
    @ToString
    public class qqPropperties {
        private String groups;
        private String persons;
    }
}
