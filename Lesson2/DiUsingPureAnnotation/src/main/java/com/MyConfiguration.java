package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration                    // like a beans.xml
@ComponentScan(basePackages = "com")
public class MyConfiguration {

    @Bean(value = "pp")
    public Product getProductInstance(){
        Product pp = new Product(); // object creation done by us but maintained by container
        return pp;
    }

}
