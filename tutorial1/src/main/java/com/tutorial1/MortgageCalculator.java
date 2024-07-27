package com.tutorial1;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Principal: ");
            double principalAmount = scanner.nextDouble();
            System.out.print("Annual rate of interest: ");
            double rateOfInterestAnuallyPercent = scanner.nextDouble();
            System.out.print("Years: ");
            double years = scanner.nextDouble();

            int months = (int) Math.ceil(years * 12);
            double roiMonthly = rateOfInterestAnuallyPercent/100.0/12.0;
            double temp = Math.pow(1 + roiMonthly, months);
            double mortgage = principalAmount * roiMonthly * temp / (temp - 1);
            String mortgageOutput = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);

            System.out.println("\nTotal months: " + months + "\nMortgage: " + mortgageOutput);
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
        finally {
            scanner.close();
        }
    }
}
