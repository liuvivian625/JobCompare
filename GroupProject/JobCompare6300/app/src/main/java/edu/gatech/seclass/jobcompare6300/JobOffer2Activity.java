package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JobOffer2Activity extends AppCompatActivity {
    private JobService jobService;
    private JobCompareDatabase jobCompareDatabase;
    private static final Logger logger = Logger.getLogger(JobOffer2Activity.class.getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer2);

        jobCompareDatabase = ((MyApplication) getApplication()).getJobCompareDatabase();

        Button newOffer = findViewById(R.id.buttonNewOfferJobOffer2);
        newOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobOffer2Activity.this, JobOfferActivity.class);
                startActivity(intent);
            }
        });

        Button mainMenu = findViewById(R.id.buttonMainMenuJobOffer2);
        mainMenu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobOffer2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button compareWithCurrent = findViewById(R.id.buttonCompareWithCurrentJobOffer2);
        jobService = new JobService(jobCompareDatabase);

        try{
            Job currentJob = jobService.FetchCurrentJob();
            compareWithCurrent.setEnabled(true);
            compareWithCurrent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(JobOffer2Activity.this, CompareWithCurrentActivity.class);
                    startActivity(intent);
                }
            });
        }
        catch (MissingCurrentJobException e){
            logger.log(Level.INFO, "Missing current Job");
        }

    }
}