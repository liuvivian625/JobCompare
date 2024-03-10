package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ComparisonSettingsActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText inputYearlySalary;
    private EditText inputYearlyBonus;
    private EditText inputStock;
    private EditText inputHomeFund;
    private EditText inputHolidays;
    private EditText inputInternet;

    private JobCompareDatabase jobCompareDatabase;
    private RankJobService rankJobService;
    private ComparisonSettings comparisonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_settings);

        jobCompareDatabase = ((MyApplication) getApplication()).getJobCompareDatabase();
        rankJobService = ((MyApplication) getApplication()).getRankJobService();
        comparisonSettings = rankJobService.getComparisonSettings();

        inputYearlySalary = findViewById(R.id.editTextNumberYearlySalaryWeight);
        inputYearlyBonus = findViewById(R.id.editTextNumberYearlyBonusWeight);
        inputStock = findViewById(R.id.editTextNumberStockWeight);
        inputHomeFund = findViewById(R.id.editTextNumberHomeFundWeight);
        inputHolidays = findViewById(R.id.editTextNumberHolidaysWeight);
        inputInternet = findViewById(R.id.editTextNumberInternetWeight);

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
            rankJobService.adjustComparisonSettings(salaryWeight, bonusWeight, stockWeight, homeFundWeight, holidaysWeight, internetWeight);

            Intent intent = new Intent(ComparisonSettingsActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.buttonResetComparisonSettings){
            //reset to default value
            inputYearlySalary.setText("1");
            inputYearlyBonus.setText("1");
            inputStock.setText("1");
            inputHomeFund.setText("1");
            inputHolidays.setText("1");
            inputInternet.setText("1");
            rankJobService.adjustComparisonSettings(1,1,1,1,1,1);
        }
    }

}