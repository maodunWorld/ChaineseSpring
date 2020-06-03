package com.maodun.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author tongjian
 * @date 2020/6/3 9:03
 */
@Data
public class book {
    private String name;
    private String author;
    private Date publishTime;
    private Integer price;
}
