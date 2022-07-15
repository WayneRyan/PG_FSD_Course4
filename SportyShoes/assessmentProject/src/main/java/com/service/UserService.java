package com.service;

import com.bean.User;
import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public Object getFilteredUsers(String filterText) {
        return userDao.getFilteredUsers(filterText);
    }
}
