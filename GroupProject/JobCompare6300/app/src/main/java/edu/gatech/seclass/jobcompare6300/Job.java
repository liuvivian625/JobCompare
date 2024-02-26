package edu.gatech.seclass.jobcompare6300;

import java.math.BigDecimal;

public class Job {

    private Integer jobID;

    private String jobTitle;

    private String company;

    private Location location;

    private Float costOfLiving;

    private Float yearlySalary;

    private Float adjustedYearlySalary;

    private Float yearlyBonus;

    private Float adjustedYearlyBonus;

    private Float numShares;

    private Float homeBuyingFundPercentage;

    private Integer personalHolidays;

    private Float monthlyInternetStipend;

    private Boolean isCurrentJob;

    private Float score;

    public Job (Integer jobID, String jobTitle, String company, Location location, Float costOfLiving, Float yearlySalary, Float adjustedYearlySalary,Float yearlyBonus,
                Float adjustedYearlyBonus, Float numShares, Float homeBuyingFundPercentage, Integer personalHolidays, Float monthlyInternetStipend, Boolean isCurrentJob, Float score)
    {
        this.jobID = jobID;
        this.jobTitle = jobTitle;
        this.company = company;
        this.location = location;
        this.costOfLiving = costOfLiving;
        this.yearlySalary = yearlySalary;
        this.adjustedYearlySalary = adjustedYearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.adjustedYearlyBonus = adjustedYearlyBonus;
        this.numShares = numShares;
        this.homeBuyingFundPercentage = homeBuyingFundPercentage;
        this.personalHolidays = personalHolidays;
        this.monthlyInternetStipend = monthlyInternetStipend;
        this.isCurrentJob = isCurrentJob;
        this.score = score;
    }

    public Integer getJobID() {
        return jobID;
    }

    public void setJobID(Integer jobID) {
        this.jobID = jobID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Float getCostOfLiving() {
        return costOfLiving;
    }

    public void setCostOfLiving(Float costOfLiving) {
        this.costOfLiving = costOfLiving;
    }

    public Float getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(Float yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public Float getAdjustedYearlySalary() {
        return adjustedYearlySalary;
    }

    public void setAdjustedYearlySalary(Float adjustedYearlySalary) {
        this.adjustedYearlySalary = adjustedYearlySalary;
    }

    public Float getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(Float yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }

    public Float getAdjustedYearlyBonus() {
        return adjustedYearlyBonus;
    }

    public void setAdjustedYearlyBonus(Float adjustedYearlyBonus) {
        this.adjustedYearlyBonus = adjustedYearlyBonus;
    }

    public Float getNumShares() {
        return numShares;
    }

    public void setNumShares(Float numShares) {
        this.numShares = numShares;
    }

    public Float getHomeBuyingFundPercentage() {
        return homeBuyingFundPercentage;
    }

    public void setHomeBuyingFundPercentage(Float homeBuyingFundPercentage) {
        this.homeBuyingFundPercentage = homeBuyingFundPercentage;
    }

    public Integer getPersonalHolidays() {
        return personalHolidays;
    }

    public void setPersonalHolidays(Integer personalHolidays) {
        this.personalHolidays = personalHolidays;
    }

    public Float getMonthlyInternetStipend() {
        return monthlyInternetStipend;
    }

    public void setMonthlyInternetStipend(Float monthlyInternetStipend) {
        this.monthlyInternetStipend = monthlyInternetStipend;
    }

    public Boolean getCurrentJob() {
        return isCurrentJob;
    }

    public void setCurrentJob(Boolean currentJob) {
        isCurrentJob = currentJob;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
