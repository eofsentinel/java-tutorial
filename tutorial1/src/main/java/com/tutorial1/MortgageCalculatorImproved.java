package com.tutorial1;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculatorImproved {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            double principalAmount, rateOfInterestAnuallyPercent, years;
            
            // Read principal amount.
            while (true) {
                System.out.print("Principal ($1K - $1M): ");
                principalAmount = scanner.nextDouble();
                if (principalAmount < 1_000 || principalAmount > 1_000_000) {
                    System.out.println("Principal amount should be between $1,000 and $1,000,000.");
                    continue;
                }
                break;
            }

            // Read annual rate of interest.
            while (true) {
                System.out.print("Annual rate of interest: ");
                rateOfInterestAnuallyPercent = scanner.nextDouble();
                if (rateOfInterestAnuallyPercent <= 0 || rateOfInterestAnuallyPercent > 30) {
                    System.out.println("Annual rate of interest should be greater than 0 and less than 30.");
                    continue;
                }
                break;
            }

            // Read tenure in years
            while (true) {
                System.out.print("Tenure (1 - 30 Years): ");
                years = scanner.nextDouble();
                if (years <= 0 || years > 30) {
                    System.out.println("Tenure should be between 1 and 30 years.");
                    continue;
                }
                break;
            }

            int months = (int) Math.ceil(years * 12);
            double roiMonthly = rateOfInterestAnuallyPercent/100.0/12.0;
            double temp = Math.pow(1 + roiMonthly, months);
            double mortgage = principalAmount * roiMonthly * temp / (temp - 1);
            String mortgageOutput = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);

            System.out.println("\n\nMortgage: " + mortgageOutput + "\n");
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
        finally {
            scanner.close();
        }
    }
}
