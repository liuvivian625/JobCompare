package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ComparisonSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_settings);

        Button mainMenu = findViewById(R.id.buttonMainMenuComparisonSettings);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComparisonSettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button reset = findViewById(R.id.buttonResetComparisonSettings);
        reset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
    }
}