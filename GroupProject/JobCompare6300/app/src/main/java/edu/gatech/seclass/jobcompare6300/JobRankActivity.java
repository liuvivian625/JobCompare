package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;

public class JobRankActivity extends AppCompatActivity {
    TableRow row; //add row dynamically

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_rank);

        Button compare = findViewById(R.id.buttonCompareJobRank);
        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JobRankActivity.this, CompareTwoJobsActivity.class);
                startActivity(intent);
            }
        });

        Button reset = findViewById(R.id.buttonResetJobRank);
        reset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
    }
}