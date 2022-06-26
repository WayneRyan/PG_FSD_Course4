package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("context.xml");
        Address add1 = (Address) ac.getBean("address");
        add1.setCity("New York");
        System.out.println(add1);

        Employee emp1 = (Employee) ac.getBean("employee");
        System.out.println(emp1);
    }
}
