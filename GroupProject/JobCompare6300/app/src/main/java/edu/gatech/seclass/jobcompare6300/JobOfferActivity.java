package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class JobOfferActivity extends AppCompatActivity implements View.OnClickListener {

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer);

        jobCompareDatabase = ((MyApplication) getApplication()).getJobCompareDatabase();

        inputTitle = findViewById(R.id.editTextTitleJobOffer);
        inputCompany = findViewById(R.id.editTextCompanyJobOffer);
        inputCity = findViewById(R.id.editTextCityJobOffer);
        inputState = findViewById(R.id.editTextStateJobOffer);
        inputCostOfLiving = findViewById(R.id.editTextLivingCostJobOffer);
        inputSalary = findViewById(R.id.editTextYearlySalaryJobOffer);
        inputBonus = findViewById(R.id.editTextYearlyBonusJobOffer);
        inputStock = findViewById(R.id.editTextStockJobOffer);
        inputHomeFund = findViewById(R.id.editTextHomeFundJobOffer);
        inputHolidays = findViewById(R.id.editTextHolidaysJobOffer);
        inputInternet = findViewById(R.id.editTextInternetJobOffer);

        Button save = findViewById(R.id.buttonSaveJobOffer);
        Button cancel = findViewById(R.id.buttonCancelJobOffer);

        save.setOnClickListener(this);
        cancel.setOnClickListener(this);

    }
    public void onClick(View v){
        if (v.getId()==R.id.buttonSaveJobOffer) {
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

                new JobService(jobCompareDatabase).addJobOffer(title, company, city, state, costOfLiving, salary, bonus, stock, homeFunds, holidays, internet);
                Intent intent = new Intent(JobOfferActivity.this, JobOffer2Activity.class);
                startActivity(intent);
            }

        }else if (v.getId()==R.id.buttonCancelJobOffer){
            Intent intent = new Intent(JobOfferActivity.this, MainActivity.class);
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
