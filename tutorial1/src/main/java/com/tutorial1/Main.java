package com.tutorial1;

import java.awt.Point;
import java.time.Instant;
import java.util.Date;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello world!!");
        
        int age = 30;
        byte herAge = (byte)(age - 3);
        System.out.println("MyAge: " + age + "\nHerAge: " + herAge);

        long viewsCount = 3_123_456_789L;
        float price = 10.99F;
        char letter = 'A';
        boolean isEligible = false;
        System.out.println(viewsCount);
        System.out.println(price);
        System.out.println(letter);
        System.out.println(isEligible);

        Date now = new Date();
        Instant utcNow = Instant.now();
        System.out.println(now);
        System.out.println(utcNow);

        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;
        System.out.println(point2);

        String message = "  Hello World" + " !!!!";
        System.out.println(message);
        System.out.println(message.endsWith("!!"));
        System.out.println(message.length());
        System.out.println(message.indexOf('w'));
        System.out.println(message.indexOf("start"));
        System.out.println(message.replace("World", "\"Universe\""));
        System.out.println(message);
        System.out.println(message.toUpperCase());
        System.out.println(message.trim());
    }
}