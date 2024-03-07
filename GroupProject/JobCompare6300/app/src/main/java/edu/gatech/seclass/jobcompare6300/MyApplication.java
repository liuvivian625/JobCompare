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

        int defaultWeight = Integer.parseInt(getResources().getString(R.string.default_weight));
        comparisonSettings = new ComparisonSettings(defaultWeight,defaultWeight,defaultWeight,defaultWeight,defaultWeight,defaultWeight);

    }

    public JobCompareDatabase getJobCompareDatabase() {
        return jobCompareDatabase;
    }

    public ComparisonSettings getComparisonSettings(){return comparisonSettings;}

}
