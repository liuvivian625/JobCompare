package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionMenuView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
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

        int numChecked = 2; //user can only select 2 items
        ArrayList<CheckBox> checkboxesList = new ArrayList<>();

        TableLayout tableLayout = findViewById(R.id.tableLayout);
        //generate table
        //to-do: indicate current job
        for(Job job:rankedJobs){
            TableRow row = new TableRow(this);


            TextView outputTitle = new TextView(this);
            TextView outputCompany = new TextView(this);
            TextView outputScore = new TextView(this);

            CheckBox checkBox = new CheckBox(this);
            checkBox.setTag(job);
            checkboxesList.add(checkBox);

            outputTitle.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT,1));
            outputCompany.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT,1));
            outputScore.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT,1));
            checkBox.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT,1));

            float score = rankJobService.computeScore(job);
            int roundedScore = Math.round(score);

            outputTitle.setText(job.getJobTitle());
            outputCompany.setText(job.getCompany());
            outputScore.setText(String.valueOf(roundedScore));

            if(job.isCurrentJob()){
                outputTitle.setTextColor(getResources().getColor(R.color.text_highlight));
                outputCompany.setTextColor(getResources().getColor(R.color.text_highlight));
                outputTitle.setTextColor(getResources().getColor(R.color.text_highlight));
            }

            row.addView(outputTitle);
            row.addView(outputCompany);
            row.addView(outputScore);
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

