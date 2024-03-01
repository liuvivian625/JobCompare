package edu.gatech.seclass.jobcompare6300.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.gatech.seclass.jobcompare6300.R;

public class CurrentJobActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_job);

        Button save = findViewById(R.id.buttonSaveCurrentJob);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button cancel = findViewById(R.id.buttonCancelCurrentJob);
        cancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CurrentJobActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
