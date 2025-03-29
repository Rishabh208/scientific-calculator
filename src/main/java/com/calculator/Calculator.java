package com.calculator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static double calculateSquareRoot(double num) {
        try {
            if (num < 0) {
                throw new IllegalArgumentException("Error: Cannot calculate square root of a negative number");
            }
            return Math.sqrt(num);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Double.NaN;
        }
    }

    public static long calculateFactorial(int num) {
        try {
            if (num < 0) {
                throw new IllegalArgumentException("Error: Cannot calculate factorial of a negative number");
            }
            long result = 1;
            for (int i = 2; i <= num; i++) {
                result *= i;
            }
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static double calculateLogarithm(double num) {
        try {
            if (num <= 0) {
                throw new IllegalArgumentException("Error: Cannot calculate natural logarithm of zero or negative number");
            }
            return Math.log(num);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Double.NaN;
        }
    }

    public static double calculatePower(double base, double exponent) {
        try {
            return Math.pow(base, exponent);
        } catch (Exception e) {
            System.out.println("Error: Unable to calculate power function");
            return Double.NaN;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean start = true;

        while(start) {
            try {
                System.out.println("Scientific Calculator");
                System.out.println("--------------------");
                System.out.println("Select an operation:");
                System.out.println("1. Square root (√x)");
                System.out.println("2. Factorial (x!)");
                System.out.println("3. Natural logarithm (ln(x))");
                System.out.println("4. Power function (x^y)");
                System.out.println("5. Exit");
                System.out.print("Enter your choice (1-5): ");

                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter a number: ");
                        double sqrtInput = sc.nextDouble();
                        System.out.println("Square root of " + sqrtInput + " = " + calculateSquareRoot(sqrtInput));
                        break;

                    case 2:
                        System.out.print("Enter a non-negative integer: ");
                        int factInput = sc.nextInt();
                        if (factInput < 0) {
                            System.out.println("Error: Factorial cannot be calculated for negative numbers.");
                        } else {
                            System.out.println("Factorial of " + factInput + " = " + calculateFactorial(factInput));
                        }
                        break;

                    case 3:
                        System.out.print("Enter a positive number: ");
                        double logInput = sc.nextDouble();
                        System.out.println("Natural logarithm of " + logInput + " = " + calculateLogarithm(logInput));
                        break;

                    case 4:
                        System.out.print("Enter the base (x): ");
                        double base = sc.nextDouble();
                        System.out.print("Enter the exponent (y): ");
                        double exponent = sc.nextDouble();
                        System.out.println(base + " raised to the power of " + exponent + " = " + calculatePower(base, exponent));
                        break;

                    case 5:
                        System.out.println("You are exiting!");
                        start = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please select a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter numbers only.");
                sc.next(); // Clear invalid input
            }
            System.out.println();
        }
        sc.close();
    }
}

//add
