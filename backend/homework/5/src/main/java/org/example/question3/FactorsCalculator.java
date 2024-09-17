package org.example.question3;

import org.example.LoggerFile;

public class FactorsCalculator extends Thread {
    private static final LoggerFile log = new LoggerFile();
    private int number;

    public FactorsCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        log.logInfo("Factors of " + number + ": ");
        calculateFactors(number);
    }

    /**
     * FactorialCalculator function calculates the factorial of a number
     * @param n
     */
    private void calculateFactors(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                log.logInfo(i + " ");
            }
        }
    }
}

