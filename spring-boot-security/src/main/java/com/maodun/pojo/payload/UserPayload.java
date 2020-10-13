package com.maodun.pojo.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author tongjian
 * @date 2020/10/13 10:23
 */
@Data
public class UserPayload {
    private String name;
    @JsonIgnore
    private String password;
}
