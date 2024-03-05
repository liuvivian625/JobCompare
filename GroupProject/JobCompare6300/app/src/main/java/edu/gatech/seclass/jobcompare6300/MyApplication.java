package edu.gatech.seclass.jobcompare6300;

import android.app.Application;

public class MyApplication extends Application {
    private JobCompareDatabase jobCompareDatabase;
    private ComparisonSettings comparisonSettings;

    @Override
    public void onCreate() {
        super.onCreate();
        jobCompareDatabase = new JobCompareDatabase(this);
        jobCompareDatabase.resetDb();

        comparisonSettings = new ComparisonSettings(1,1,1,1,1,1);

    }

    public JobCompareDatabase getJobCompareDatabase() {
        return jobCompareDatabase;
    }

    public ComparisonSettings getComparisonSettings(){return comparisonSettings;}

}
