package org.example;

public class Main {
    private static LoggerFile log = new LoggerFile();
    public static void main(String[] args) {
        HealthInsurancePlan insurancePlan = new PlatinumPlan();

        Patient patientA = new Patient();
        patientA.setInsurancePlan(insurancePlan);

        double[] payments = Billing.computePaymentAmount(patientA, 1000.0);
        log.logInfo(String.valueOf(payments[0]));
        log.logInfo(String.valueOf(payments[1]));

        User staff = new User();
        InsuranceBrand insuranceBrand = new BlueCrossBlueShield();

        insurancePlan.setOfferedBy(insuranceBrand);
        staff.setInsurancePlan(insurancePlan);
        log.logInfo("Result : " + insurancePlan.computeMonthlyPremium(5000, 56, true));

    }
}