package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CompareTwoJobsActivity extends AppCompatActivity {
    private JobCompareDatabase jobCompareDatabase;
    private JobService jobService;

    private TextView outputTitle1;
    private TextView outputCompany1;
    private TextView outputLocation1;
    private TextView outputSalary1;
    private TextView outputBonus1;
    private TextView outputStock1;
    private TextView outputHomeFund1;
    private TextView outputHolidays1;
    private TextView outputInternet1;

    private TextView outputTitle2;
    private TextView outputCompany2;
    private TextView outputLocation2;
    private TextView outputSalary2;
    private TextView outputBonus2;
    private TextView outputStock2;
    private TextView outputHomeFund2;
    private TextView outputHolidays2;
    private TextView outputInternet2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_two_jobs);

        List<Job> selectedJobs = (List<Job>)getIntent().getSerializableExtra("selectedJobs");

        jobCompareDatabase = ((MyApplication) getApplication()).getJobCompareDatabase();
        jobService = new JobService(jobCompareDatabase);

        if (selectedJobs != null){
            Job job1 = selectedJobs.get(0);
            Job job2 = selectedJobs.get(1);

            outputTitle1 = findViewById(R.id.textViewTitle1Compare2Jobs);
            outputCompany1 = findViewById(R.id.textViewCompany1Compare2Jobs);
            outputLocation1 = findViewById(R.id.textViewLocation1Compare2Jobs);
            outputSalary1 = findViewById(R.id.textViewSalary1Compare2Jobs);
            outputBonus1 = findViewById(R.id.textViewBonus1Compare2Jobs);
            outputStock1 = findViewById(R.id.textViewStock1Compare2Jobs);
            outputHomeFund1 =  findViewById(R.id.textViewHomeFund1Compare2Jobs);
            outputHolidays1 = findViewById(R.id.textViewHolidays1Compare2Jobs);
            outputInternet1 = findViewById(R.id.textViewInternet1Compare2Jobs);

            outputTitle2 = findViewById(R.id.textViewTitle2Compare2Jobs);
            outputCompany2 = findViewById(R.id.textViewCompany2Compare2Jobs);
            outputLocation2 = findViewById(R.id.textViewLocation2Compare2Jobs);
            outputSalary2 = findViewById(R.id.textViewSalary2Compare2Jobs);
            outputBonus2 = findViewById(R.id.textViewBonus2Compare2Jobs);
            outputStock2 = findViewById(R.id.textViewStock2Compare2Jobs);
            outputHomeFund2 =  findViewById(R.id.textViewHomeFund2Compare2Jobs);
            outputHolidays2 = findViewById(R.id.textViewHolidays2Compare2Jobs);
            outputInternet2 = findViewById(R.id.textViewInternet2Compare2Jobs);

            outputTitle1.setText(job1.getJobTitle());
            outputCompany1.setText(job1.getCompany());
            outputLocation1.setText(job1.getLocation().toString());
            outputSalary1.setText(String.valueOf(job1.getAdjustedYearlySalary()));
            outputBonus1.setText(String.valueOf(job1.getAdjustedYearlyBonus()));
            outputStock1.setText(String.valueOf(job1.getNumShares()));
            outputHomeFund1.setText(String.valueOf(job1.getHomeBuyingFundPercentage()));
            outputHolidays1.setText(String.valueOf(job1.getPersonalHolidays()));
            outputInternet1.setText(String.valueOf(job1.getMonthlyInternetStipend()));

            outputTitle2.setText(job2.getJobTitle());
            outputCompany2.setText(job2.getCompany());
            outputLocation2.setText(job2.getLocation().toString());
            outputSalary2.setText(String.valueOf(job2.getAdjustedYearlySalary()));
            outputBonus2.setText(String.valueOf(job2.getAdjustedYearlyBonus()));
            outputStock2.setText(String.valueOf(job2.getNumShares()));
            outputHomeFund2.setText(String.valueOf(job2.getHomeBuyingFundPercentage()));
            outputHolidays2.setText(String.valueOf(job2.getPersonalHolidays()));
            outputInternet2.setText(String.valueOf(job2.getMonthlyInternetStipend()));
        }



        Button newComparison = findViewById(R.id.buttonNewComparisonCompareTwoJobs);
        newComparison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompareTwoJobsActivity.this, JobRankActivity.class);
                startActivity(intent);
            }
        });

        Button mainMenu = findViewById(R.id.buttonMainMenuCompareTwoJobs);
        mainMenu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompareTwoJobsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}