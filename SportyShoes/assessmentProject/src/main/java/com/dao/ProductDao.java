package com.dao;

import com.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    EntityManagerFactory emf;

    public List<Product> getAllProducts() {
        try {
            EntityManager manager = emf.createEntityManager();
            TypedQuery<Product> qry = manager.createQuery("select p from Product p", Product.class);
            return qry.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public Product getProduct(int id) {
        try {
            EntityManager manager = emf.createEntityManager();
            TypedQuery<Product> qry = manager.createQuery("select p from Product p where p.id=:id", Product.class);
            qry.setParameter("id", id);
            return qry.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean update(Product selectedProduct) {
        EntityManager manager = emf.createEntityManager();
        EntityTransaction tran = manager.getTransaction();
        try {
            tran.begin();
            manager.merge(selectedProduct);
            tran.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
