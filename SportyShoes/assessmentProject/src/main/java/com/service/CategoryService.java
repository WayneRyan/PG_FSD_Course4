package com.service;

import com.bean.Category;
import com.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public List<Category> getAllCategories() {return categoryDao.getAllCategories();}

    public Category getCategory(int selectedCategory) {
        return categoryDao.getCategory(selectedCategory);
    }
}
