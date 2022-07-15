package com.dao;

import com.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

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

    public List<User> getAllUsers() {
        try {
            EntityManager manager = emf.createEntityManager();
            TypedQuery<User> qry = manager.createQuery("select u from User u", User.class);
            return qry.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public Object getFilteredUsers(String filterText) {
        try {
            EntityManager manager = emf.createEntityManager();
            TypedQuery<User> qry = manager.createQuery("select u from User u where u.user_name like :filterText", User.class);
            qry.setParameter("filterText", "%" + filterText + "%");
            return qry.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
