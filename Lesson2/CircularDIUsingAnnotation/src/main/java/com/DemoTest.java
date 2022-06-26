package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);

        A obj1 = (A) ac.getBean("a");
        B obj2 = (B) ac.getBean("b");

        obj1.dis1();
        obj2.dis2();


    }
}
