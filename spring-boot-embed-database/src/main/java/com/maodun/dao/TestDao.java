package com.maodun.dao;

import com.maodun.pojo.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDao extends JpaRepository<Test, String> {
}
