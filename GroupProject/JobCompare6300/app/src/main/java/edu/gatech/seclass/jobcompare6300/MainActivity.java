package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private JobCompareDatabase jobCompareDatabase;
    private JobService jobService;
    private RankJobService rankJobService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Service initialization
        jobCompareDatabase = new JobCompareDatabase(this);
        jobCompareDatabase.resetDb();

//        Job job = new Job("Software Engineer", "GaTech", new Location("Atlanta", "Georgia"), 10000.0f, 100000.0f, 75000.0f, 10000.0f, 7500.0f, 1000.0f, 5.0f, 15, 25.0f, 1, 5.0f);
//
//        //adding sample job
//        jobCompareDatabase.addJob(job);
//
//        Job job2 = new Job("Data Scientist", "Apple", new Location("Cupertino", "California"), 1000.0f, 100000.0f, 75000.0f, 10000.0f, 7500.0f, 1000.0f, 5.0f, 15, 25.0f, 1, 50.0f);
//
//        //adding sample job
//        jobCompareDatabase.addJob(job2);
//
//        //updating sample job
//        Job newJob = new Job("Software Engineer 2", "GaTech", new Location("Atlanta", "Georgia"), 10000.0f, 100000.0f, 75000.0f, 10000.0f, 7500.0f, 1000.0f, 5.0f, 15, 25.0f, 1, 5.0f);
//        jobCompareDatabase.updateJob(newJob);
//
//        System.out.printf("current job: [%s]%n", jobCompareDatabase.fetchCurrentJob().getJobTitle());
//
//        jobCompareDatabase.resetDb();

        jobService = new JobService(jobCompareDatabase);
        rankJobService = new RankJobService(jobCompareDatabase);

        Button currentJob = findViewById(R.id.buttonCurrentJob);
        currentJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentJobActivity.class);
                startActivity(intent);
            }
        });

        Button jobOffer = findViewById(R.id.buttonJobOffer);
        jobOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JobOfferActivity.class);
                startActivity(intent);
            }
        });

        Button comparisonSettings = findViewById(R.id.buttonComparisonSettings);
        comparisonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ComparisonSettingsActivity.class);
                startActivity(intent);
            }
        });

        Button compareJobs = findViewById(R.id.buttonCompare);
        compareJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JobRankActivity.class);
                startActivity(intent);
            }
        });
    }
}