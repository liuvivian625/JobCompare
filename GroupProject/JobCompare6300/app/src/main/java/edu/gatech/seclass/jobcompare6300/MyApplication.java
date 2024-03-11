package edu.gatech.seclass.jobcompare6300;

import android.app.Application;

public class MyApplication extends Application {
    private JobCompareDatabase jobCompareDatabase;
    private RankJobService rankJobService;

    @Override
    public void onCreate() {
        super.onCreate();
        jobCompareDatabase = new JobCompareDatabase(this);
        rankJobService = new RankJobService(jobCompareDatabase);

    }

    public JobCompareDatabase getJobCompareDatabase() {
        return jobCompareDatabase;
    }

    public RankJobService getRankJobService(){
        return rankJobService;
    }
}
