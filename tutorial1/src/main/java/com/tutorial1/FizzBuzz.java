package com.tutorial1;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        final String FIZZ = "Fizz", BUZZ = "Buzz";
        System.out.print("Number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean isDivBy5 = (number % 5 == 0);
        boolean isDivBy3 = (number % 3 == 0);
        if (isDivBy3 && isDivBy5) {
            System.out.println(FIZZ + BUZZ);
        }
        else if (isDivBy3) {
            System.out.println(BUZZ);
        }
        else if (isDivBy5) {
            System.out.println(FIZZ);
        }
        else {
            System.out.println(number);
        }

        scanner.close();
    }
}
