package com.eofsentinel.demoCoreJava;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    // @Autowired // Field injection
    // @Qualifier("laptop")
    private Computer computer;

    private final BeanFactory beanFactory;

    // Ctor injection
    public Dev(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void setComputer(String computerType) {
        this.computer = (Computer) this.beanFactory.getBean(computerType);
    }

//    // setter injection
//    @Autowired
//    @Qualifier("laptop")
//    public void setLaptop(Computer computer) {
//        this.computer = computer;
//    }

    public void build() {
        System.out.println("Working on a Java Spring Boot project...");
        this.computer.compile();
    }

}
