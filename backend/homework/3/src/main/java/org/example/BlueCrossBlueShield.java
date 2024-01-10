package org.example;

public class BlueCrossBlueShield implements InsuranceBrand {
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking){
        double premium = 0;
        if(insurancePlan instanceof PlatinumPlan) {
            if (age > 55) {
                premium = premium + 200.0;
            }
            if (smoking) {
                premium = premium + 100.0;
            }
        }

        else if(insurancePlan instanceof GoldPlan){
            if (age > 55) {
                premium = premium + 150.0;
            }
            if (smoking) {
                premium = premium + 90.0;
            }
        }

        else if(insurancePlan instanceof SilverPlan){
            if (age > 55) {
                premium = premium + 50.0;
            }
            if (smoking) {
                premium = premium + 80.0;
            }
        }

        else if(insurancePlan instanceof BronzePlan){
            if (age > 55) {
                premium = premium + 50.0;
            }
            if (smoking) {
                premium = premium + 70.0;
            }
        }

        return premium;
    }
}