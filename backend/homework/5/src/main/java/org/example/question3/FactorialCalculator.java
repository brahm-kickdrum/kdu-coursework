package org.example.question3;

import org.example.LoggerFile;

public class FactorialCalculator extends Thread {
    private static final LoggerFile log = new LoggerFile();
    private int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        long factorialResult = calculateFactorial(number);
        log.logInfo("Factorial of " + number + ": " + factorialResult);
    }

    /**
     * FactorialCalculator function calculates the factorial of a number
     * @param n
     * @return
     */
    private long calculateFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
