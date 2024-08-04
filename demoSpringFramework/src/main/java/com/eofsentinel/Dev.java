package com.eofsentinel;

public class Dev {

    private IComputer comp;
    private int age;
    private double salary;

    public IComputer getComp() {
        return comp;
    }

    public void setComp(IComputer comp) {
        this.comp = comp;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dev() {
        System.out.println("Dev ctor");
    }

    public Dev(int age, double salary, IComputer computer) {
        this.age = age;
        this.salary = salary;
        this.comp = computer;
        System.out.println("Dev ctor: age=" + this.age + ", salary=" + this.salary);
    }

    public void build() {
        System.out.println("Working on a Java Spring Boot project...");
        this.comp.compile();
    }

}
