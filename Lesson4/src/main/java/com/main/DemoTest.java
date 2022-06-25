package com.main;

import com.bean.Employee;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.security.cert.X509Certificate;

public class DemoTest {
    public static void main(String[] args) {
//        Employee emp = new Employee();
//        emp.display();
        Resource res = new ClassPathResource("beans.xml");
        BeanFactory f1 = new XmlBeanFactory(res);
//        Employee emp1 = (Employee) f1.getBean("emp1");
//        emp1.display();
//        Employee emp11 = (Employee) f1.getBean("emp1");
//        emp11.display();
//        Employee emp2 = (Employee) f1.getBean("emp2");
//        emp2.display();
//        Employee emp12 = (Employee) f1.getBean("emp2");
//        emp12.display();

        Employee emp3 = (Employee) f1.getBean("emp1");
        System.out.println(emp3);

        Employee emp4 = (Employee) f1.getBean("emp3");
        System.out.println(emp4);
    }
}
