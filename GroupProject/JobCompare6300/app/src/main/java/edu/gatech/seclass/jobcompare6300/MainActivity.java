package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private JobCompareDatabase jobCompareDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jobCompareDatabase = new JobCompareDatabase(this);
        jobCompareDatabase.resetDb();

        Job job = new Job("Software Engineer", "GaTech", new Location("Atlanta", "Georgia"),10000.0f, 100000.0f, 75000.0f, 10000.0f, 7500.0f, 1000.0f, 5.0f, 15, 25.0f, 1.0f, 5.0f);

        //adding sample job
        jobCompareDatabase.addJob(job);

        Job job2 = new Job("Data Scientist", "Apple", new Location("Cupertino", "California"),1000.0f, 100000.0f, 75000.0f, 10000.0f, 7500.0f, 1000.0f, 5.0f, 15, 25.0f, 0.0f, 50.0f);

        //adding sample job
        jobCompareDatabase.addJob(job2);

        //updating sample job
        Job newJob = new Job("Software Engineer 2", "GaTech", new Location("Atlanta", "Georgia"),10000.0f, 100000.0f, 75000.0f, 10000.0f, 7500.0f, 1000.0f, 5.0f, 15, 25.0f, 1.0f, 5.0f);
        jobCompareDatabase.updateJob(newJob);

        System.out.printf("current job: [%s]%n", jobCompareDatabase.fetchCurrentJob().getJobTitle());

        //System.out.printf("all jobs: [%s]%n", jobCompareDatabase.fetchAllJobs().toString());

    }

}