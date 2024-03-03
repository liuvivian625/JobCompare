package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CurrentJobActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText inputTitle;
    private EditText inputCompany;
    private EditText inputCity;
    private EditText inputState;
    private EditText inputCostOfLiving;
    private EditText inputSalary;
    private EditText inputBonus;
    private EditText inputStock;
    private EditText inputHomeFund;
    private EditText inputHolidays;
    private EditText inputInternet;

    private JobCompareDatabase jobCompareDatabase;
    private JobService jobService;
    private Job currentJob;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_job);

        jobCompareDatabase = ((MyApplication) getApplication()).getJobCompareDatabase();
        jobService = new JobService(jobCompareDatabase);

        inputTitle = findViewById(R.id.editTextTitleCurrentJob);
        inputCompany = findViewById(R.id.editTextCompanyCurrentJob);
        inputCity = findViewById(R.id.editTextCityCurrentJob);
        inputState = findViewById(R.id.editTextStateCurrentJob);
        inputCostOfLiving = findViewById(R.id.editTextLivingCostCurrentJob);
        inputSalary = findViewById(R.id.editTextYearlySalaryCurrentJob);
        inputBonus = findViewById(R.id.editTextYearlyBonusCurrentJob);
        inputStock = findViewById(R.id.editTextStockCurrentJob);
        inputHomeFund =  findViewById(R.id.editTextHomeFundCurrentJob);
        inputHolidays = findViewById(R.id.editTextHolidaysCurrentJob);
        inputInternet = findViewById(R.id.editTextInternetCurrentJob);

        Button save = findViewById(R.id.buttonSaveCurrentJob);
        Button cancel = findViewById(R.id.buttonCancelCurrentJob);

        save.setOnClickListener(this);
        cancel.setOnClickListener(this);

        //not working properly
        /*
        currentJob = jobService.FetchCurrentJob();
        if (currentJob != null){
            inputTitle.setText(currentJob.getJobTitle());
            inputCompany.setText(currentJob.getCompany());
            //inputCity.setText(currentJob.getLocation().getCity());
            //inputState.setText(currentJob.getLocation().getState());
            inputCostOfLiving.setText(String.valueOf(currentJob.getCostOfLiving()));
            inputSalary.setText(String.valueOf(currentJob.getYearlySalary()));
            inputBonus.setText(String.valueOf(currentJob.getYearlyBonus()));
            inputStock.setText(String.valueOf(currentJob.getNumShares()));
            inputHomeFund.setText(String.valueOf(currentJob.getHomeBuyingFundPercentage()));
            inputHolidays.setText(String.valueOf(currentJob.getPersonalHolidays()));
            inputInternet.setText(String.valueOf(currentJob.getMonthlyInternetStipend()));
        }

         */

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonSaveCurrentJob) {
            String title = inputTitle.getText().toString();
            String company = inputCompany.getText().toString();
            String city = inputCity.getText().toString();
            String state = inputState.getText().toString();
            float costOfLiving = Float.parseFloat(inputCostOfLiving.getText().toString());
            float salary = Float.parseFloat(inputSalary.getText().toString());
            float bonus = Float.parseFloat(inputBonus.getText().toString());
            float stock = Float.parseFloat(inputStock.getText().toString());
            float homeFunds = Float.parseFloat(inputHomeFund.getText().toString());
            int holidays = Integer.parseInt(inputHolidays.getText().toString());
            float internet = Float.parseFloat(inputInternet.getText().toString());


            //to-do: refine error messages
            if(!Utils.ValidateStringInput(title)){
                inputTitle.setError("Input is invalid!");
            }
            if(!Utils.ValidateStringInput(company)){
                inputCompany.setError("Input is invalid!");
            }
            if(!Utils.ValidateStringInput(city)){
                inputCity.setError("Input is invalid!");
            }
            if(!Utils.ValidateStringInput(state)){
                inputState.setError("Input is invalid!");
            }
            if(!Utils.validateCostOfLiving(costOfLiving)){
                inputCostOfLiving.setError("Input is invalid!");
            }
            if(!Utils.validateHomeBuyingFundPercentage(homeFunds)){
                inputHomeFund.setError("Input is invalid!");
            }
            if(!Utils.validatePersonalHolidays(holidays)){
                inputHolidays.setError("Input is invalid!");
            }
            if(!Utils.validateMonthlyInternetStipend(internet)){
                inputInternet.setError("Input is invalid!");
            }

            if (Utils.ValidateStringInput(title)
                    && Utils.ValidateStringInput(company)
                    && Utils.ValidateStringInput(city)
                    && Utils.ValidateStringInput(state)
                    && Utils.validateCostOfLiving(costOfLiving)
                    && Utils.validateHomeBuyingFundPercentage(homeFunds)
                    && Utils.validatePersonalHolidays(holidays)
                    && Utils.validateMonthlyInternetStipend(internet)) {
                new JobService(jobCompareDatabase).addCurrentJob(title, company, city, state, costOfLiving, salary, bonus, stock, homeFunds, holidays, internet);
                Intent intent = new Intent(CurrentJobActivity.this, MainActivity.class);
                startActivity(intent);
            }
        } else if (v.getId() == R.id.buttonCancelCurrentJob){
            Intent intent = new Intent(CurrentJobActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }








}
