package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class ComparisonSettingsActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText inputYearlySalary;
    private EditText inputYearlyBonus;
    private EditText inputStock;
    private EditText inputHomeFund;
    private EditText inputHolidays;
    private EditText inputInternet;

    private JobCompareDatabase jobCompareDatabase;
    private ComparisonSettings comparisonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_settings);

        jobCompareDatabase = ((MyApplication) getApplication()).getJobCompareDatabase();

        inputYearlySalary = findViewById(R.id.editTextNumberYearlySalaryWeight);
        inputYearlyBonus = findViewById(R.id.editTextNumberYearlyBonusWeight);
        inputStock = findViewById(R.id.editTextNumberStockWeight);
        inputHomeFund = findViewById(R.id.editTextNumberHomeFundWeight);
        inputHolidays = findViewById(R.id.editTextNumberHolidaysWeight);
        inputInternet = findViewById(R.id.editTextNumberInternetWeight);

        comparisonSettings = ((MyApplication)getApplication()).getComparisonSettings();
        inputYearlySalary.setText(String.valueOf(comparisonSettings.getYearlySalaryWeight()));
        inputYearlyBonus.setText(String.valueOf(comparisonSettings.getYearlyBonusWeight()));
        inputStock.setText(String.valueOf(comparisonSettings.getNumOfStockWeight()));
        inputHomeFund.setText(String.valueOf(comparisonSettings.getHomeBuyingFundWeight()));
        inputHolidays.setText(String.valueOf(comparisonSettings.getPersonalHolidaysWeight()));
        inputInternet.setText(String.valueOf(comparisonSettings.getMonthlyInternetStipendWeight()));

        Button mainMenu = findViewById(R.id.buttonMainMenuComparisonSettings);
        Button reset = findViewById(R.id.buttonResetComparisonSettings);
        mainMenu.setOnClickListener(this);
        reset.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.buttonMainMenuComparisonSettings) {
            int salaryWeight = Integer.parseInt(inputYearlySalary.getText().toString());
            int bonusWeight = Integer.parseInt(inputYearlyBonus.getText().toString());
            int stockWeight = Integer.parseInt(inputStock.getText().toString());
            int homeFundWeight = Integer.parseInt(inputHomeFund.getText().toString());
            int holidaysWeight = Integer.parseInt(inputHolidays.getText().toString());
            int internetWeight = Integer.parseInt(inputInternet.getText().toString());
            new RankJobService(jobCompareDatabase).adjustComparisonSettings(salaryWeight, bonusWeight, stockWeight, homeFundWeight, holidaysWeight, internetWeight);

            comparisonSettings.setYearlySalaryWeight(salaryWeight);
            comparisonSettings.setYearlyBonusWeight(bonusWeight);
            comparisonSettings.setNumOfStockWeight(stockWeight);
            comparisonSettings.setPersonalHolidaysWeight(holidaysWeight);
            comparisonSettings.setMonthlyInternetStipendWeight(internetWeight);

            Intent intent = new Intent(ComparisonSettingsActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.buttonResetComparisonSettings){
            //reset to default value
            String outputDefaultWeight = getResources().getString(R.string.default_weight);
            inputYearlySalary.setText(outputDefaultWeight);
            inputYearlyBonus.setText(outputDefaultWeight);
            inputStock.setText(outputDefaultWeight);
            inputHomeFund.setText(outputDefaultWeight);
            inputHolidays.setText(outputDefaultWeight);
            inputInternet.setText(outputDefaultWeight);
            int defaultWeight = Integer.parseInt(outputDefaultWeight);
            new RankJobService(jobCompareDatabase).adjustComparisonSettings(defaultWeight, defaultWeight, defaultWeight, defaultWeight, defaultWeight, defaultWeight);
        }
    }

}