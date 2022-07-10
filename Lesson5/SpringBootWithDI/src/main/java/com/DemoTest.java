package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com")    // it will enable @Component annotation, both class must be part of same package
public class DemoTest {
    public static void main(String[] args) {
        SpringApplication.run(DemoTest.class, args); // run spring boot
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.scan("com");
        ac.refresh();
        Employee emp = (Employee) ac.getBean("employee");
        emp.displayEmpInfo();

    }
}
