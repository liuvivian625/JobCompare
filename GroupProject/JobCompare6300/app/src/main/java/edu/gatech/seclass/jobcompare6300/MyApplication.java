package edu.gatech.seclass.jobcompare6300;

import android.app.Application;

public class MyApplication extends Application {
    private JobCompareDatabase jobCompareDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        jobCompareDatabase = new JobCompareDatabase(this);
    }

    public JobCompareDatabase getJobCompareDatabase() {
        return jobCompareDatabase;
    }

}
