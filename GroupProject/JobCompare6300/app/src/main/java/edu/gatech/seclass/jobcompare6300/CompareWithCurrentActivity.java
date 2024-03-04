package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CompareWithCurrentActivity extends AppCompatActivity {

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

    private List<Job> jobs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_with_current);

        jobCompareDatabase = ((MyApplication) getApplication()).getJobCompareDatabase();

        jobService = new JobService(jobCompareDatabase);
        jobs.addAll(jobService.displayCurrentJobAndOffer());
        Job currentJob = jobs.get(0);
        Job jobOffer = jobs.get(1);

        outputTitle1 = findViewById(R.id.textViewTitle1CompareWCur);
        outputCompany1 = findViewById(R.id.textViewCompany1CompareWCur);
        //outputLocation1 = findViewById(R.id.textViewLocation1CompareWCur);
        outputSalary1 = findViewById(R.id.textViewSalary1CompareWCur);
        outputBonus1 = findViewById(R.id.textViewBonus1CompareWCur);
        outputStock1 = findViewById(R.id.textViewStock1CompareWCur);
        outputHomeFund1 = findViewById(R.id.textViewHomeFund1CompareWCur);
        outputHolidays1 = findViewById(R.id.textViewHolidays1CompareWCur);
        outputInternet1 = findViewById(R.id.textViewInternet1CompareWCur);

        outputTitle2 = findViewById(R.id.textViewTitle2CompareWCur);
        outputCompany2 = findViewById(R.id.textViewCompany2CompareWCur);
        //outputLocation2 = findViewById(R.id.textViewLocation2CompareWCur);
        outputSalary2 = findViewById(R.id.textViewSalary2CompareWCur);
        outputBonus2 = findViewById(R.id.textViewBonus2CompareWCur);
        outputStock2 = findViewById(R.id.textViewStock2CompareWCur);
        outputHomeFund2 = findViewById(R.id.textViewHomeFund2CompareWCur);
        outputHolidays2 = findViewById(R.id.textViewHolidays2CompareWCur);
        outputInternet2 = findViewById(R.id.textViewInternet2CompareWCur);

        outputTitle1.setText(currentJob.getJobTitle());
        outputCompany1.setText(currentJob.getCompany());
        //outputLocation1.setText(currentJob.getLocation().toString());
        outputSalary1.setText(String.valueOf(currentJob.getAdjustedYearlySalary()));
        outputBonus1.setText(String.valueOf(currentJob.getAdjustedYearlyBonus()));
        outputStock1.setText(String.valueOf(currentJob.getNumShares()));
        outputHomeFund1.setText(String.valueOf(currentJob.getHomeBuyingFundPercentage()));
        outputHolidays1.setText(String.valueOf(currentJob.getPersonalHolidays()));
        outputInternet1.setText(String.valueOf(currentJob.getMonthlyInternetStipend()));

        outputTitle2.setText(jobOffer.getJobTitle());
        outputCompany2.setText(jobOffer.getCompany());
        //outputLocation2.setText(jobOffer.getLocation().toString());
        outputSalary2.setText(String.valueOf(jobOffer.getAdjustedYearlySalary()));
        outputBonus2.setText(String.valueOf(jobOffer.getAdjustedYearlyBonus()));
        outputStock2.setText(String.valueOf(jobOffer.getNumShares()));
        outputHomeFund2.setText(String.valueOf(jobOffer.getHomeBuyingFundPercentage()));
        outputHolidays2.setText(String.valueOf(jobOffer.getPersonalHolidays()));
        outputInternet2.setText(String.valueOf(jobOffer.getMonthlyInternetStipend()));

        Button mainMenu = findViewById(R.id.buttonMainMenuCompareWCur);
        mainMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompareWithCurrentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}