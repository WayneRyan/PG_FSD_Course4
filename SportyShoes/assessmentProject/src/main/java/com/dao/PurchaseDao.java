package com.dao;

import com.bean.Category;
import com.bean.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class PurchaseDao {
    @Autowired
    EntityManagerFactory emf;

    public List<Purchase> getFilteredPurchases(Date startDate, Date endDate, Category category) {
        try {
            EntityManager manager = emf.createEntityManager();
            TypedQuery<Purchase> qry = manager.createQuery("select p from Purchase p where p.product.category = :category and p.date > :startDate and p.date < :endDate", Purchase.class);
            qry.setParameter("startDate", startDate);
            qry.setParameter("endDate", endDate);
            qry.setParameter("category", category);
            List<Purchase> resultList = qry.getResultList();
            return resultList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
