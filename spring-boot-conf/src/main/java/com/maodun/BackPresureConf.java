package com.maodun;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author tongjian
 * @date 2021/1/15 16:52
 */
@ConfigurationProperties("backpresure")
@Data
public class BackPresureConf {
    private List<backpresure> list;
}
