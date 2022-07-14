package com.dao;

import com.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

@Repository
public class UserDao {

    @Autowired
    EntityManagerFactory emf;

    public User getUser(String userName){
        try {
            EntityManager manager = emf.createEntityManager();
            TypedQuery<User> qry = manager.createQuery("select u from User u where u.user_name=:userName", User.class);
            qry.setParameter("userName", userName);
            return qry.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
