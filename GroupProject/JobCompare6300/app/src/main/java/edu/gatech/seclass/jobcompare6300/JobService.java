package edu.gatech.seclass.jobcompare6300;

import java.util.ArrayList;
import java.util.List;

public class JobService {

    private final JobCompareDatabase jobCompareDatabase;

    public JobService(JobCompareDatabase jobCompareDatabase) {
        this.jobCompareDatabase = jobCompareDatabase;
    }

    /**
     * Create a new current job or update the current job if exists
     *
     * @param jobTitle String
     * @param company String
     * @param city String
     * @param state String
     * @param costOfLiving Float number of city indexing, must be larger than 0
     * @param yearlySalary Float number
     * @param yearlyBonus Float number
     * @param numShares Float number
     * @param homeBuyingFundPercentage Float number in [0, 15]
     * @param personalHolidays Integer number in [0， 20]
     * @param monthlyInternetStipend Float number in [0, 75]
     */
    public void addCurrentJob(String jobTitle, String company, String city, String state, Float costOfLiving,
                                      Float yearlySalary, Float yearlyBonus, Integer numShares, Float homeBuyingFundPercentage,
                                      Integer personalHolidays, Float monthlyInternetStipend) {
        int isCurrentJob = 1;

        Job job = createJob(jobTitle, company, city, state, costOfLiving, yearlySalary, yearlyBonus,
                numShares, homeBuyingFundPercentage, personalHolidays, monthlyInternetStipend, isCurrentJob);

        if (jobCompareDatabase.fetchCurrentJob() == null) {
            jobCompareDatabase.addJob(job);
        } else {
            jobCompareDatabase.updateCurrentJob(job);
        }
    }

    /**
     * Fetch current job information in displaying current job
     *
     * @return current job object
     * @throws MissingCurrentJobException if current job has not been set
     */
    public Job FetchCurrentJob() throws MissingCurrentJobException {
        Job currentJob = jobCompareDatabase.fetchCurrentJob();
        if (currentJob == null) {
            throw new MissingCurrentJobException();
        }
        return currentJob;
    }

    /**
     * Create a new Job offer
     *
     * @param jobTitle String
     * @param company String
     * @param city String
     * @param state String
     * @param costOfLiving Float number of city indexing, must be larger than 0
     * @param yearlySalary Float number
     * @param yearlyBonus Float number
     * @param numShares Float number
     * @param homeBuyingFundPercentage Float number in [0, 15]
     * @param personalHolidays Integer number in [0， 20]
     * @param monthlyInternetStipend Float number in [0, 75]
     */
    public void addJobOffer(String jobTitle, String company, String city, String state, Float costOfLiving,
                              Float yearlySalary, Float yearlyBonus, Integer numShares, Float homeBuyingFundPercentage,
                              Integer personalHolidays, Float monthlyInternetStipend) {
        int isCurrentJob = 0;

        Job job = createJob(jobTitle, company, city, state, costOfLiving, yearlySalary, yearlyBonus,
                numShares, homeBuyingFundPercentage, personalHolidays, monthlyInternetStipend, isCurrentJob);

        jobCompareDatabase.addJob(job);
    }

    /**
     * Display current job and previously editing offer
     *
     * @return List of jobs which contains two job object, the first is current job, the second is job offer
     * @throws MissingCurrentJobException if current job has not been set
     */
    public List<Job> displayCurrentJobAndOffer() throws MissingCurrentJobException{
        List<Job> jobs = new ArrayList<>();

        Job currentJob = jobCompareDatabase.fetchCurrentJob();
        if (currentJob == null) {
            throw new MissingCurrentJobException();
        }
        jobs.add(currentJob);

        List<Job> prevJobOffers = jobCompareDatabase.fetchAllJobs();
        Job lastOffer = new Job();
        for(int i = prevJobOffers.size() - 1; i >= 0; i--) {
            Job offer = prevJobOffers.get(i);
            if(!offer.isCurrentJob()) {
                lastOffer = offer;
                break;
            }
        }
        jobs.add(lastOffer);

        return jobs;
    }

    private Job createJob(String jobTitle, String company, String city, String state, Float costOfLiving,
                          Float yearlySalary, Float yearlyBonus, Integer numShares, Float homeBuyingFundPercentage,
                          Integer personalHolidays, Float monthlyInternetStipend, int isCurrentJob) {
        float adjustedYearlySalary = yearlySalary * 100 / costOfLiving;
        float adjustedYearlyBonus = yearlyBonus * 100 / costOfLiving;
        float score = 1f;

        return new Job(jobTitle, company, new Location(city, state), costOfLiving, yearlySalary,
                adjustedYearlySalary, yearlyBonus, adjustedYearlyBonus, numShares, homeBuyingFundPercentage,
                personalHolidays, monthlyInternetStipend, isCurrentJob, score);
    }
}
