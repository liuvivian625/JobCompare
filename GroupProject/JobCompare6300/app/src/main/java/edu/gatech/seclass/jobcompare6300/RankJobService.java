package edu.gatech.seclass.jobcompare6300;

import java.util.Comparator;
import java.util.List;

public class RankJobService {
    private final JobCompareDatabase jobCompareDatabase;
    private ComparisonSettings comparisonSettings;

    public RankJobService(JobCompareDatabase jobCompareDatabase) {
        this.jobCompareDatabase = jobCompareDatabase;
        this.comparisonSettings = new ComparisonSettings(1, 1, 1, 1, 1, 1);
    }

    /**
     *
     * @param yearlySalaryWeight integer
     * @param yearlyBonusWeight integer
     * @param numOfStockWeight integer
     * @param homeBuyingFundWeight integer
     * @param personalHolidaysWeight integer
     * @param monthlyInternetStipendWeight integer
     */
    public void adjustComparisonSettings(int yearlySalaryWeight, int yearlyBonusWeight, int numOfStockWeight,
                                         int homeBuyingFundWeight, int personalHolidaysWeight, int monthlyInternetStipendWeight) {
        comparisonSettings = new ComparisonSettings(yearlySalaryWeight, yearlyBonusWeight, numOfStockWeight,
                homeBuyingFundWeight, personalHolidaysWeight, monthlyInternetStipendWeight);
    }

    /**
     * Rank job (if exist) and offers (if exist) in descending order based on the computed job score
     *
     * @return List of job objects
     * @throws NoJobException if there's no job or offer exist in JobCompareDatabase
     */
    public List<Job> rankJobOffers() throws NoJobException {
        List<Job> jobs = jobCompareDatabase.fetchAllJobs();
        if (jobs.size() == 0) {
            throw new NoJobException();
        }
        jobs.sort(new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2) {
                float diff = computeScore(j1) - computeScore(j2);
                if(diff > 0) {
                    return -1;
                } else if (diff < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return jobs;
    }

    // score = weighted average of AYS + AYB + (CSO/3) + HBP + (PCH * AYS / 260) + (MIS*12)
    private float computeScore(Job job) {
        return job.getAdjustedYearlySalary() * comparisonSettings.getYearlySalaryWeight()+
                job.getAdjustedYearlyBonus() * comparisonSettings.getYearlyBonusWeight() +
                job.getNumShares()/3 * comparisonSettings.getNumOfStockWeight() +
                job.getHomeBuyingFundPercentage() * job.getYearlySalary() * comparisonSettings.getHomeBuyingFundWeight() +
                job.getPersonalHolidays() * job.getAdjustedYearlySalary() / 260 * comparisonSettings.getPersonalHolidaysWeight() +
                job.getMonthlyInternetStipend() * 12 * comparisonSettings.getMonthlyInternetStipendWeight();
    }
}
