
# Test Plan

**Author**: Vineet Baburaj

## 1 Build Results

![gradle build](../Docs/images/Test_result_1.png)

## 2 Android Autotest Results

![android test](../Docs/images/Test_result_2.png)

## 3 Unit Test Results

![unit test](../Docs/images/Test_result_3.png)

## End-to-End Test Case E2E1: Simulate job offer comparison process

### Test Description
Simulate the process of comparing job offers within the application, ensuring that the final comparison accurately reflects all entered data.

### Steps to Reproduce
1. Start the application.
    - ![Start_app](../Docs/images/E2E1/Start_app.png)

2. Enter details for the current job.
    - ![Enter_current_job](../Docs/images/E2E1/Enter_current_job.png)

3. Add multiple job offers.
   - 
    - ![Job_offer_1](../Docs/images/E2E1/Job_offer_1.png)
    - ![Job_offer_2](../Docs/images/E2E1/Job_offer_2.png)

4. Adjust comparison settings as needed.
    - ![Comparison_settings](../Docs/images/E2E1/Comparison_settings.png)

5. Perform the comparison.
    - ![Final](../Docs/images/E2E1/Final.png)

### Expected Results
- The final comparison screen displays all entered data, including details of the current job and the added job offers.

## End-to-End Test Case E2E2: Test flow without entering a current job

### Test Description
Test the application's flow when adding job offers and performing comparison without entering a current job.

### Steps to Reproduce
1. Start the application.
   - ![Start_app](../Docs/images/E2E2/Start_app.png)

2. Add multiple job offers without entering a current job.
   - 
   - ![Job_offer_1](../Docs/images/E2E2/Job_offer_1.png)
   - ![Job_offer_2](../Docs/images/E2E2/Job_offer_2.png)

3. Adjust comparison settings as needed.
   - ![Comparison_settings](../Docs/images/E2E1/Comparison_settings.png)

4. Perform the comparison without a current job.
   - ![Compare](../Docs/images/E2E2/Compare.png)
   - ![Final](../Docs/images/E2E2/Result.png)

### Expected Results
- The application handles comparisons of offers correctly even without a current job.

## End-to-End Test Case E2E3: Test editing and updating job details

### Test Description
Test the application to ensure that updates are correctly saved and reflected in the comparison.

### Steps to Reproduce
1. Start the application.
   - ![Start_app](../Docs/images/E2E1/Start_app.png)

2. Enter and save details for the current job and a job offer.
   - 
   - ![Enter_current_job](../Docs/images/E2E1/Enter_current_job.png)
   - ![Job_offer_1](../Docs/images/E2E1/Job_offer_1.png)
   - ![Job_offer_2](../Docs/images/E2E1/Job_offer_2.png)

3. Check updates are saved and reflected in the comparison.
   - ![Final](../Docs/images/E2E1/Final.png)

### Expected Results
- Updates made to job details are correctly saved and reflected in the comparison.
