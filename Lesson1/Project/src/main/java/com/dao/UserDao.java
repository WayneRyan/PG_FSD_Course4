package com.dao;

import com.bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class UserDao {

    @Autowired
    SessionFactory sf;

    public User getUser(String user_id){
        try {
            Session session = sf.openSession();
            TypedQuery<User> qry = session.createQuery("select  u from User  u where u.user_id=:user_id");
            qry.setParameter("user_id", user_id);
            return qry.getSingleResult();
        } catch (Exception e) {
            return  null;
        }
    }

    public boolean saveOrUpdate(User user) {
        try {
            Session session = sf.openSession();
            Transaction tran = (Transaction) session.getTransaction();
            tran.begin();
            session.saveOrUpdate(user);
            tran.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
