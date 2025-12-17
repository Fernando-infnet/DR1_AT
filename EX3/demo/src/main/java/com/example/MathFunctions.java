package com.example;

import java.util.Arrays;

public class ViaCep {

    private final MathLogger logger;

    // Injeção de dependência
    public ViaCep(MathLogger logger) {
        this.logger = logger;
    }

    public int multiplyByTwo(int number) {
        logger.log("multiplyByTwo", new int[]{number});
        return number * 2;
    }

    public int[] generateMultiplicationTable(int number, int limit) {
        logger.log("generateMultiplicationTable", new int[]{number, limit});
        int[] result = new int[limit];
        for (int i = 0; i < limit; i++) {
            result[i] = number * (i + 1);
        }
        return result;
    }

    public boolean isPrime(int number) {
        logger.log("isPrime", new int[]{number});
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public double calculateAverage(int[] numbers) {
        logger.log("calculateAverage", numbers);
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }
        return Arrays.stream(numbers).average().getAsDouble();
    }
}
