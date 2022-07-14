package com.service;

import com.bean.User;
import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User checkCredentials(String userName, String password) {
        User user = userDao.getUser(userName);
        if (user != null && user.getPassword().equals(password) && user.isIs_admin()){
            return user;
        } else {
            return null;
        }
    }
}
