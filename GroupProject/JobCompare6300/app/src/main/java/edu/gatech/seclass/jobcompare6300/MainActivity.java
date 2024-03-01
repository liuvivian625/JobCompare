package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private JobCompareDatabase jobCompareDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jobCompareDatabase = new JobCompareDatabase(this);

        Job job = new Job(1,"Software Engineer", "GaTech", new Location("Atlanta", "Georgia"),10000.0f, 100000.0f, 75000.0f, 10000.0f, 7500.0f, 1000.0f, 5.0f, 15, 25.0f, 1.0f, 5.0f);

        //adding sample job
        jobCompareDatabase.addJob(job);

    }

    public void handleClick(View view) {
    }
}