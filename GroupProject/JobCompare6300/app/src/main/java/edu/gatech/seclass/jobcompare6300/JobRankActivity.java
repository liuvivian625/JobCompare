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

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        RankJobService rankJobService = new RankJobService(jobCompareDatabase);
        //rankedJobs.addAll(rankJobService.rankJobOffers());

        //placeholder
        Job job1 = new Job("Software Engineer", "GaTech", new Location("Atlanta", "Georgia"), 10000.0f, 100000.0f, 75000.0f, 10000.0f, 7500.0f, 1000.0f, 5.0f, 15, 25.0f, 1, 100.0f);
        Job job2 = new Job("Data Scientist", "Apple", new Location("Cupertino", "California"), 1000.0f, 100000.0f, 75000.0f, 10000.0f, 7500.0f, 1000.0f, 5.0f, 15, 25.0f, 1, 50.0f);
        Job job3 = new Job("Data Scientist III", "Google", new Location("Cupertino", "California"), 1000.0f, 100000.0f, 75000.0f, 10000.0f, 7500.0f, 1000.0f, 5.0f, 15, 25.0f, 1, 30.0f);

        rankedJobs.add(job1);
        rankedJobs.add(job2);
        rankedJobs.add(job3);


        int numChecked = 2; //user can only select 2 items
        ArrayList<CheckBox> checkboxesList = new ArrayList<>();

        Button compare = findViewById(R.id.buttonCompareJobRank);

        //generate table
        for(Job job:rankedJobs){
            TableRow row = new TableRow(this);

            TextView outputTitle = new TextView(this);
            outputTitle.setText(job.getJobTitle());
            row.addView(outputTitle);

            TextView outputCompany = new TextView(this);
            outputCompany.setText(job.getCompany());
            row.addView(outputCompany);

            TextView outputScore = new TextView(this);
            outputScore.setText(String.valueOf(job.getScore()));
            row.addView(outputScore);

            CheckBox checkBox = new CheckBox(this);
            checkboxesList.add(checkBox);
            row.addView(checkBox);

            tableLayout.addView(row);
        }

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
                Intent intent = new Intent(JobRankActivity.this, CompareTwoJobsActivity.class);
                startActivity(intent);
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
                // traverse cells
                for (int j = 0; j < row.getChildCount(); j++) {
                    View cellView = row.getChildAt(j);
                    if (cellView instanceof CheckBox) {
                        CheckBox checkBox = (CheckBox) cellView;
                        checkBox.setChecked(false);
                    }
                }
            }
        }
    }


}

