package edu.gatech.seclass.jobcompare6300.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.seclass.jobcompare6300.Job;
import edu.gatech.seclass.jobcompare6300.Location;
import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.JobCompareDatabase;

public class MainActivity extends AppCompatActivity {

    private JobCompareDatabase jobCompareDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //jobCompareDatabase = new JobCompareDatabase(this);

        //Job job = new Job(1, "Software Engineer", "GaTech", new Location("Atlanta", "Georgia"), 10000.0f, 100000.0f, 75000.0f, 10000.0f, 7500.0f, 1000.0f, 5.0f, 15, 25.0f, 1.0f, 5.0f);

        //adding sample job
       // jobCompareDatabase.addJob(job);

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