package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
        Employee add1 = (Employee) ac.getBean("employee");
        System.out.println(add1);

        Product pp = (Product) ac.getBean("pp");
        pp.displayProductInfo();
    }
}
