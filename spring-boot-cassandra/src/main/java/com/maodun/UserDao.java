package com.maodun;

import com.maodun.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

/**
 * @author tongjian
 * @date 2020/6/8 14:50
 */
public interface UserDao extends CassandraRepository<User, UUID> {
}
