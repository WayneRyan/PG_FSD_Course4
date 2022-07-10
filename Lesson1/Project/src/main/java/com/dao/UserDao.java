package com.dao;

import com.bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.sql.SQLOutput;

@Repository
public class UserDao {

    @Autowired
    SessionFactory sf;

    public User getUser(String user_id) {
        try {
            Session session = sf.openSession();
            TypedQuery<User> qry = session.createQuery("select  u from User  u where u.user_id=:user_id");
            qry.setParameter("user_id", user_id);
            return qry.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean saveOrUpdate(User user) {
        try {
            System.out.println(user);
            Session session = sf.openSession();
            System.out.println(user);
            Transaction tran = (Transaction) session.getTransaction();
            System.out.println(user);
            tran.begin();
            System.out.println(user);
            session.saveOrUpdate(user);
            System.out.println(user);
            tran.commit();
            System.out.println(user);
            return true;
        } catch (Exception e) {
            System.out.println("SaveOrUpdate failed: " + e);
            return false;
        }
    }
}
