package edu.gatech.seclass.jobcompare6300;

public class Utils {
    public boolean ValidateStringInput(String input) {
        return input.length() != 0;
    }

    public boolean validateHomeBuyingFundPercentage(float homeBuyingFundPercentage) {
        return homeBuyingFundPercentage <= 15;
    }

    public boolean validateCostOfLiving(float costOfLiving) {
        return costOfLiving > 0;
    }

    public boolean validatePersonalHolidays(int personalHolidays) {
        return personalHolidays >= 0 && personalHolidays <= 20;
    }

    public boolean validateMonthlyInternetStipend(float monthlyInternetStipend) {
        return monthlyInternetStipend >= 0 && monthlyInternetStipend <= 75;
    }
}