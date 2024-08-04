package com.eofsentinel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Dev obj = context.getBean(Dev.class);
        obj.build();

        System.out.println(obj.getAge());

        obj.setAge(10);
        System.out.println(obj.getAge());

    }
}
