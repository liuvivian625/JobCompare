package edu.gatech.seclass.jobcompare6300.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.seclass.jobcompare6300.R;

public class CompareTwoJobsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_two_jobs);

        Button newComparison = findViewById(R.id.buttonNewComparisonCompareTwoJobs);
        newComparison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompareTwoJobsActivity.this, JobRankActivity.class);
                startActivity(intent);
            }
        });

        Button reset = findViewById(R.id.buttonMainMenuCompareTwoJobs);
        reset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompareTwoJobsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}