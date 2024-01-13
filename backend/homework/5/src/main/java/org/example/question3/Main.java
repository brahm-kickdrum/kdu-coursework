package org.example.question3;

import org.example.LoggerFile;

public class Main {
    private static final LoggerFile log = new LoggerFile();
    public static void main(String[] args) {
        int number = 10;

        FactorialCalculator factorialCalculator = new FactorialCalculator(number);
        FactorsCalculator factorsCalculator = new FactorsCalculator(number);

        factorialCalculator.start();
        factorsCalculator.start();

        try {
            factorialCalculator.join();
            factorsCalculator.join();
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Re-interrupt the current thread
            log.logError(e.getMessage());
        }

        log.logInfo("Main thread finished.");
    }
}
