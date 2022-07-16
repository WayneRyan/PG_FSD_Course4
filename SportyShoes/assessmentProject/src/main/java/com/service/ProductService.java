package com.service;

import com.bean.Product;
import com.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public List<Product> getAllProducts() { return productDao.getAllProducts();}

    public Product getProduct(int id) { return productDao.getProduct( id); }

    public boolean update(Product selectedProduct) { return productDao.update(selectedProduct);}
}
