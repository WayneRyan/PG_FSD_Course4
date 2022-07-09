package com.dao;

import com.bean.Login;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class LoginDao {

    @Autowired
    SessionFactory sf;   //Do DI for SessionFactory Bean

    public int signIn(Login login){
        Session session = sf.openSession();
        TypedQuery<Login> qry = session.createQuery("select l from Login l where l.email=:email and l.password=:password");
        qry.setParameter("email", login.getEmail());
        qry.setParameter("password", login.getPassword());
        List<Login> list = qry.getResultList();
        return list.size();
    }

    public int signUp(Login login){
        try {
            Session session = sf.openSession();
            Transaction tran = (Transaction) session.getTransaction();
            tran.begin();
            session.save(login);
            tran.commit();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

}
