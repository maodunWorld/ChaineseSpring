package com.maodun.dao;

import com.maodun.pojo.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoDao extends JpaRepository<Demo, String> {
}
