package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private JobCompareDatabase jobCompareDatabase;
    private JobService jobService;
    private RankJobService rankJobService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Service initialization
        jobCompareDatabase = new JobCompareDatabase(this);
        jobService = new JobService(jobCompareDatabase);
        rankJobService = new RankJobService(jobCompareDatabase);

        // TODO: GUI Interfaces
    }

    public void handleClick(View view) {
        jobService.EnterJobOffer();
    }
}