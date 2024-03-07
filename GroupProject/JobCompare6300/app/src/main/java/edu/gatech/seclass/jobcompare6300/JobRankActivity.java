package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JobRankActivity extends AppCompatActivity {

    private JobCompareDatabase jobCompareDatabase;
    private List<Job> rankedJobs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_rank);

        jobCompareDatabase = ((MyApplication) getApplication()).getJobCompareDatabase();

        RankJobService rankJobService = new RankJobService(jobCompareDatabase);
        rankedJobs.addAll(rankJobService.rankJobOffers());

        //placeholder
/*
        Job job1 = new Job("Software Engineer", "GaTech", new Location("Atlanta", "Georgia"), 150.0f, 100000.0f, 100000.0f, 15000.0f, 7500.0f, 1000, 5.0f, 15, 25.0f, 1, 100.0f);
        Job job2 = new Job("Data Scientist", "Apple", new Location("Cupertino", "California"), 300.0f, 150000.0f, 125000.0f, 20000.0f, 7500.0f, 1000, 15.0f, 12, 45.0f, 0, 90.0f);
        Job job3 = new Job("Data Scientist III", "Google", new Location("Mountain View", "California"), 400.0f, 300000.0f, 285000.0f, 20000.0f, 5500.0f, 500, 12.0f, 13, 35.0f, 0, 80.0f);

        rankedJobs.add(job1);
        rankedJobs.add(job2);
        rankedJobs.add(job3);

*/


        int numChecked = 2; //user can only select 2 items
        ArrayList<CheckBox> checkboxesList = new ArrayList<>();

        TableLayout tableLayout = findViewById(R.id.tableLayout);
        //generate table
        //to-do: indicate current job
        for(Job job:rankedJobs){
            TableRow row = new TableRow(this);

            TextView outputTitle = new TextView(this);
            outputTitle.setText(job.getJobTitle());
            if(job.isCurrentJob()){
                outputTitle.setTextColor(getResources().getColor(R.color.text_highlight));
            }
            row.addView(outputTitle);

            TextView outputCompany = new TextView(this);
            outputCompany.setText(job.getCompany());
            if(job.isCurrentJob()){
                outputCompany.setTextColor(getResources().getColor(R.color.text_highlight));
            }
            row.addView(outputCompany);

            TextView outputScore = new TextView(this);
            outputScore.setText(String.valueOf(1));
            if(job.isCurrentJob()){
                outputTitle.setTextColor(getResources().getColor(R.color.text_highlight));
            }
            row.addView(outputScore);

            CheckBox checkBox = new CheckBox(this);
            checkBox.setTag(job);
            checkboxesList.add(checkBox);
            row.addView(checkBox);

            tableLayout.addView(row);
        }

        Button compare = findViewById(R.id.buttonCompareJobRank);

        final int[] count = {0};
        for (CheckBox checkbox : checkboxesList) {
            checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        count[0]++;
                    } else {
                        count[0]--;
                    }

                    if (count[0] == numChecked) {
                        compare.setEnabled(true);
                    } else {
                        compare.setEnabled(false);
                    }
                }
            });
        }


        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCompareClicked();
            }
        });

        Button reset = findViewById(R.id.buttonResetJobRank);
        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resetTableCheckBoxes(tableLayout);
            }
        });
    }

    private void resetTableCheckBoxes(TableLayout tableLayout) {
        // traverse rows
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            View rowView = tableLayout.getChildAt(i);
            if (rowView instanceof TableRow) {
                TableRow row = (TableRow) rowView;
                CheckBox checkBox = (CheckBox) row.getChildAt(3);
                checkBox.setChecked(false);
            }
        }
    }

    private void onCompareClicked(){
        List<Job> selectedJobs = new ArrayList<>();
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            View rowView = tableLayout.getChildAt(i);
            if (rowView instanceof TableRow) {
                TableRow row = (TableRow) rowView;
                CheckBox checkBox = (CheckBox) row.getChildAt(3);
                if (checkBox.isChecked()) {
                    Job selectedJob = (Job) checkBox.getTag();
                    selectedJobs.add(selectedJob);
                }
            }
        }
        Intent intent = new Intent(JobRankActivity.this, CompareTwoJobsActivity.class);
        intent.putExtra("selectedJobs", (Serializable) selectedJobs);
        startActivity(intent);
    }


}

