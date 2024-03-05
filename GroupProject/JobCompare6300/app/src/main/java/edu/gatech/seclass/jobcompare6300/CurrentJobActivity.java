package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.logging.Level;
import java.util.logging.Logger;

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
    private static final Logger logger = Logger.getLogger(CurrentJobActivity.class.getName());


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

        try{
            currentJob = jobService.FetchCurrentJob();
            inputTitle.setText(currentJob.getJobTitle());
            inputCompany.setText(currentJob.getCompany());
            inputCity.setText(currentJob.getLocation().getCity());
            inputState.setText(currentJob.getLocation().getState());
            inputCostOfLiving.setText(String.valueOf(currentJob.getCostOfLiving()));
            inputSalary.setText(String.valueOf(currentJob.getYearlySalary()));
            inputBonus.setText(String.valueOf(currentJob.getYearlyBonus()));
            inputStock.setText(String.valueOf(currentJob.getNumShares()));
            inputHomeFund.setText(String.valueOf(currentJob.getHomeBuyingFundPercentage()));
            inputHolidays.setText(String.valueOf(currentJob.getPersonalHolidays()));
            inputInternet.setText(String.valueOf(currentJob.getMonthlyInternetStipend()));
        }
        catch(MissingCurrentJobException e){
            logger.log(Level.INFO, "Missing current Job");
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonSaveCurrentJob) {
            if(validateInputs()){
                String title = inputTitle.getText().toString();
                String company = inputCompany.getText().toString();
                String city = inputCity.getText().toString();
                String state = inputState.getText().toString();
                float costOfLiving = Float.parseFloat(inputCostOfLiving.getText().toString());
                float salary = Float.parseFloat(inputSalary.getText().toString());
                float bonus = Float.parseFloat(inputBonus.getText().toString());
                int stock = Integer.parseInt(inputStock.getText().toString());
                float homeFunds = Float.parseFloat(inputHomeFund.getText().toString());
                int holidays = Integer.parseInt(inputHolidays.getText().toString());
                float internet = Float.parseFloat(inputInternet.getText().toString());
                new JobService(jobCompareDatabase).addCurrentJob(title, company, city, state, costOfLiving, salary, bonus, stock, homeFunds, holidays, internet);
                Intent intent = new Intent(CurrentJobActivity.this, MainActivity.class);
                startActivity(intent);
            }
        } else if (v.getId() == R.id.buttonCancelCurrentJob){
            Intent intent = new Intent(CurrentJobActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    private boolean validateInputs(){
        String title = inputTitle.getText().toString();
        String company = inputCompany.getText().toString();
        String city = inputCity.getText().toString();
        String state = inputState.getText().toString();
        String costOfLivingString = inputCostOfLiving.getText().toString();
        String salaryString = inputSalary.getText().toString();
        String bonusString = inputBonus.getText().toString();
        String stockString = inputStock.getText().toString();
        String homeFundsString = inputHomeFund.getText().toString();
        String holidaysString = inputHolidays.getText().toString();
        String internetString = inputInternet.getText().toString();

        if(!Utils.ValidateStringInput(title)){
            inputTitle.setError("Can't be empty!");
            return false;
        }
        if(!Utils.ValidateStringInput(company)){
            inputCompany.setError("Can't be empty!");
            return false;
        }
        if(!Utils.ValidateStringInput(city)){
            inputCity.setError("Can't be empty!");
            return false;
        }
        if(!Utils.ValidateStringInput(state)){
            inputState.setError("Can't be empty!");
            return false;
        }
        if(!Utils.ValidateStringInput(costOfLivingString)){
            inputCostOfLiving.setError("Please enter a number larger than 0.");
            return false;
        }else{
            float costOfLiving = Float.parseFloat(costOfLivingString);
            if(!Utils.validateCostOfLiving(costOfLiving)) {
                inputCostOfLiving.setError("Please enter a number larger than 0.");
                return false;
            }
        }
        if(!Utils.ValidateStringInput(salaryString)){
            inputSalary.setError("Please enter a number.");
            return false;
        }
        if(!Utils.ValidateStringInput(bonusString)){
            inputBonus.setError("Please enter a number.");
            return false;
        }
        if(!Utils.ValidateStringInput(stockString)){
            inputStock.setError("Please enter a number.");
            return false;
        }
        if(!Utils.ValidateStringInput(homeFundsString)){
            inputHomeFund.setError("Please enter a number no more than 15.");
            return false;
        }else{
            float homeFunds = Float.parseFloat(homeFundsString);
            if(!Utils.validateHomeBuyingFundPercentage(homeFunds)) {
                inputHomeFund.setError("Please enter a number no more than 15.");
                return false;
            }
        }
        if(!Utils.ValidateStringInput(holidaysString)){
            inputHolidays.setError("Please enter a number between 0 and 20.");
            return false;
        }else{
            int holidays = Integer.parseInt(holidaysString);
            if(!Utils.validatePersonalHolidays(holidays)) {
                inputHolidays.setError("Please enter a number between 0 and 20.");
                return false;
            }
        }
        if(!Utils.ValidateStringInput(internetString)){
            inputInternet.setError("Please enter a number between 0 and 75.");
            return false;
        }else{
            float internet = Float.parseFloat(internetString);
            if(!Utils.validateMonthlyInternetStipend(internet)){
                inputInternet.setError("Please enter a number between 0 and 75.");
                return false;
            }
        }
        return true;
    }


}
