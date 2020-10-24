package com.maodun.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Test {
    @Id
    private String id;
    private String name;
}
