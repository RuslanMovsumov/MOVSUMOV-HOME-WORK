package com.example;

public class Factorial {
    public static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число не должно быть отрицательным");
        }
        if (n == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
