package com.maodun.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author tongjian
 * @date 2020/10/13 10:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultResp {
    private int code;
    private String msg;
    private Object data;
}
