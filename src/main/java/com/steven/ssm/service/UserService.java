package com.steven.ssm.service;

import com.steven.ssm.entity.User;

import java.util.List;

public interface UserService {
    User findUserById(long id);

    List<User>getUserList();
}
