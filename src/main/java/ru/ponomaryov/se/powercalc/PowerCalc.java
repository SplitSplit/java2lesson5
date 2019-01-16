package ru.ponomaryov.se.powercalc;

public class PowerCalc {

    public static void main(String[] args) {
        System.out.println("5 pow 4 = " + pow(5, 4));
    }

    private static int pow(int value, int power) {
        if (power == 1) {
            return value;
        }
        if (power == 0) {
            return 1;
        }
        if (power < 0) {
            throw new RuntimeException("Not implemented!");
        }
        return value * pow(value, power - 1);
    }
}
