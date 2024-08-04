package com.eofsentinel;

public class Laptop implements IComputer  {

    public Laptop() {
        System.out.println("Laptop ctor");
    }

    public void compile() {
        System.out.println("Compiling in Laptop...");
    }

}
