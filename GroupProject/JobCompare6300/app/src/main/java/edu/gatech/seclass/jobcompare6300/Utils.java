package edu.gatech.seclass.jobcompare6300;

public class Utils {
    public static boolean ValidateStringInput(String input) {
        return input.length() != 0;
    }

    public static boolean validateHomeBuyingFundPercentage(float homeBuyingFundPercentage) {
        return homeBuyingFundPercentage <= 15 && homeBuyingFundPercentage>=0;
    }

    public static boolean validateCostOfLiving(float costOfLiving) {
        return costOfLiving > 0;
    }

    public static boolean validatePersonalHolidays(int personalHolidays) {
        return personalHolidays >= 0 && personalHolidays <= 20;
    }

    public static boolean validateMonthlyInternetStipend(float monthlyInternetStipend) {
        return monthlyInternetStipend >= 0 && monthlyInternetStipend <= 75;
    }
}