package com.main;

import com.bean.Product;
import com.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        Product p = (Product)ac.getBean("product");
        p.setPid(6);
        p.setPname("Laptop");
        p.setPrice(87000);

        ProductService ps = (ProductService) ac.getBean("productService");
        String result = ps.storeProduct(p);
        System.out.println(result);

        System.out.println(ps.getAllProducts());
    }
}
