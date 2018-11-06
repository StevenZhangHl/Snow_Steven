package com.steven.ssm.dao;

import com.steven.ssm.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapperDao {
    User findUserById(long id);

    List<User> getUserList();
}
