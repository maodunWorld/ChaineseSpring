package com.maodun;

import lombok.Data;

/**
 * @author tongjian
 * @date 2021/1/15 17:06
 */
@Data
public class KafkaSensor {
    private String groupid;
    private String topic;
    private Integer maxqueuesize;
}
