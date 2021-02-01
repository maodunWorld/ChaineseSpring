package com.maodun;

import lombok.Data;

import java.util.List;

/**
 * @author tongjian
 * @date 2021/1/15 16:50
 */
@Data
public class backpresure {
    private List<KafkaSensor> kafkasensors;

    private String flowname;

    private String ratelimitkey;

    private Integer ratelimit;
}
