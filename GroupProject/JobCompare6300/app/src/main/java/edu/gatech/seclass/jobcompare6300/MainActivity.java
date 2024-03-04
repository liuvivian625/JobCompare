package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private JobCompareDatabase jobCompareDatabase;

    private RankJobService rankJobService;
    private static final Logger logger = Logger.getLogger(MainActivity.class.getName());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jobCompareDatabase = ((MyApplication) getApplication()).getJobCompareDatabase();

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
        try{
            List<Job> jobs = rankJobService.rankJobOffers();
            if(jobs.size()>=2){
                compareJobs.setEnabled(true);
                compareJobs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, JobRankActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }catch (NoJobException e){
            logger.log(Level.INFO, "No job exception");
        }



    }
}