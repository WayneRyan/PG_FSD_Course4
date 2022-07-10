package com.service;

import com.bean.User;
import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getUser(String user_id) {
        return userDao.getUser(user_id);
    }

    public boolean updateUser(User user) {
        return userDao.saveOrUpdate(user);
    }
}
