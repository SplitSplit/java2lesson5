package ru.ponomaryov.se.hellobye;

public class Main5 {

    public static void main(String[] args) {
        countdown(5);
        System.out.println("5! = " + factorial(5));
    }

    private static int countdown(int n) {
        if (n <= 1) {
            System.out.println(n);
            return n;
        } else {
            System.out.println(n);
            return countdown(n - 1);
        }
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
