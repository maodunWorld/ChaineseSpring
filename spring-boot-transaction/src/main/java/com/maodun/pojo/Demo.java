package com.maodun.pojo;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@ToString
public class Demo {
    private String name;
    @Id
    private String id;
    private Long age;
    private Long heigh;
}
