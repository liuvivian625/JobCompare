package edu.gatech.seclass.jobcompare6300.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.seclass.jobcompare6300.R;

public class JobOffer2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer2);

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
        compareWithCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobOffer2Activity.this, CompareTwoJobsActivity.class);
                startActivity(intent);
            }
        });
    }
}