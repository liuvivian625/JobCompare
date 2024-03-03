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
                //location
                new JobService(jobCompareDatabase).addJobOffer(title, company, city, state, costOfLiving, salary, bonus, stock, homeFunds, holidays, internet);
                Intent intent = new Intent(JobOfferActivity.this, JobOffer2Activity.class);
                startActivity(intent);
            }

        }else if (v.getId()==R.id.buttonCancelJobOffer){
            Intent intent = new Intent(JobOfferActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
