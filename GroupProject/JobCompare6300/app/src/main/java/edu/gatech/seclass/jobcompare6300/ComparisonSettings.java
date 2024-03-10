package edu.gatech.seclass.jobcompare6300;

public class ComparisonSettings {
    private int yearlySalaryWeight;
    private int yearlyBonusWeight;
    private int numOfStockWeight;
    private int homeBuyingFundWeight;
    private int personalHolidaysWeight;
    private int monthlyInternetStipendWeight;

    public ComparisonSettings(int yearlySalaryWeight, int yearlyBonusWeight, int numOfStockWeight, int homeBuyingFundWeight, int personalHolidaysWeight, int monthlyInternetStipendWeight) {
        this.yearlySalaryWeight = yearlySalaryWeight;
        this.yearlyBonusWeight = yearlyBonusWeight;
        this.numOfStockWeight = numOfStockWeight;
        this.homeBuyingFundWeight = homeBuyingFundWeight;
        this.personalHolidaysWeight = personalHolidaysWeight;
        this.monthlyInternetStipendWeight = monthlyInternetStipendWeight;
    }

    public ComparisonSettings(){
        //default constructor
    }

    public int getYearlySalaryWeight() {
        return yearlySalaryWeight;
    }

    public void setYearlySalaryWeight(int yearlySalaryWeight) {
        this.yearlySalaryWeight = yearlySalaryWeight;
    }

    public int getYearlyBonusWeight() {
        return yearlyBonusWeight;
    }

    public void setYearlyBonusWeight(int yearlyBonusWeight) {
        this.yearlyBonusWeight = yearlyBonusWeight;
    }

    public int getNumOfStockWeight() {
        return numOfStockWeight;
    }

    public void setNumOfStockWeight(int numOfStockWeight) {
        this.numOfStockWeight = numOfStockWeight;
    }

    public int getHomeBuyingFundWeight() {
        return homeBuyingFundWeight;
    }

    public void setHomeBuyingFundWeight(int homeBuyingFundWeight) {
        this.homeBuyingFundWeight = homeBuyingFundWeight;
    }

    public int getPersonalHolidaysWeight() {
        return personalHolidaysWeight;
    }

    public void setPersonalHolidaysWeight(int personalHolidaysWeight) {
        this.personalHolidaysWeight = personalHolidaysWeight;
    }

    public int getMonthlyInternetStipendWeight() {
        return monthlyInternetStipendWeight;
    }

    public void setMonthlyInternetStipendWeight(int monthlyInternetStipendWeight) {
        this.monthlyInternetStipendWeight = monthlyInternetStipendWeight;
    }

    public int getTotalWeight() {
        return this.yearlySalaryWeight + this.yearlyBonusWeight + this.numOfStockWeight +
                this.homeBuyingFundWeight + this.personalHolidaysWeight + this.monthlyInternetStipendWeight;
    }
}
