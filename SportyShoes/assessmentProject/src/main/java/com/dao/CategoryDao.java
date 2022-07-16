package com.dao;

import com.bean.Category;
import com.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDao {

    @Autowired
    EntityManagerFactory emf;

    public List<Category> getAllCategories() {
        try {
            EntityManager manager = emf.createEntityManager();
            TypedQuery<Category> qry = manager.createQuery("select c from Category c", Category.class);
            return qry.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public Category getCategory(int selectedCategory) {
        try {
            EntityManager manager = emf.createEntityManager();
            TypedQuery<Category> qry = manager.createQuery("select c from Category c where c.id=:category", Category.class);
            qry.setParameter("category", selectedCategory);
            return qry.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
