package com.eofsentinel.demoCoreJava;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Laptop implements Computer {

    @Override
    public void compile() {
        System.out.println("Compiling the source code on Laptop now...");
    }
}
