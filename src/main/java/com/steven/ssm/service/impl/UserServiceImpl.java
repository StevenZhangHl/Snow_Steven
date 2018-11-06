package com.steven.ssm.service.impl;

import com.steven.ssm.dao.UserMapperDao;
import com.steven.ssm.entity.User;
import com.steven.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapperDao userMapperDao;

    public User findUserById(long id) {
        return userMapperDao.findUserById(id);
    }

    @Override
    public List<User> getUserList() {
        return userMapperDao.getUserList();
    }
}
