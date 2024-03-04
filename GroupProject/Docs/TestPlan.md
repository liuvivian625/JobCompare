
# Test Plan

**Author**: Vineet Baburaj, Jing Liu

## 1 Testing Strategy

### 1.1 Overall strategy

The testing strategy encompasses unit testing, UI testing, and end-to-end testing to ensure comprehensive coverage. The team will conduct unit tests to validate individual functions, UI tests for user interaction flows, and end-to-end tests will simulate real-world usage scenarios.

### 1.2 Test Selection

Test cases will be selected using both black-box and white-box techniques. White-box testing for unit tests focuses on code coverage, while black-box testing for UI and end-to-end tests is based on software requirements and user scenarios.

### 1.3 Adequacy Criterion

The quality of test cases will be assessed using functional coverage for black-box tests and code coverage metrics for white-box tests, aiming for at least 80% code coverage with unit tests.

### 1.4 Bug Tracking

Bugs and enhancement requests will be tracked using a document shared with the team hosted on cloud. Any bug or enhancement will be added there and assigned to a developer.

### 1.5 Technology

JUnit for unit testing, Espresso for UI testing and end-to-end testing on Android.

## 2 Test Cases

| Test Case ID | Purpose                                                | Steps                                                                                                                                  | Expected Result                               | Actual Result | Pass/Fail | Additional Info              |
|--------------|--------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------|---------------|-----------|------------------------------|
| UT1          | Verify yearly salary adjustment calculation            | Call `calculateAdjustedSalary` with specific inputs.                                                                                   | Correctly adjusted salary is returned.        |               |           |                              |
| UT2          | Verify yearly bonus adjustment calculation             | Call `calculateAdjustedBonus` with specific inputs.                                                                                    | Correctly adjusted bonus is returned.         |               |           |                              |
| UT3          | Ensure Home Buying Program fund does not exceed limit  | Call `validateHomeBuyingFundPercentage` with specific input.                                                                           | Validation passes if input <= 15%.            |               |           |                              |
| UT4          | Test weighted average calculation for job comparison   | Execute `computeScore` with predefined job attributes and weights.                                                                     | Correct weighted average is calculated.       |               |           |                              |
| UT5          | Verify ranking algorithm sorts jobs correctly          | Call `rankJobOffers` with a list of jobs.                                                                                              | Jobs are sorted correctly based on scores.    |               |           |                              |
| UT6          | Test ValidateStringInput with Non-Empty String         | Call `ValidateStringInput` with "validInput".                                                                                          | `true` is returned for non-empty string.      |               |           |                              |
| UT7          | Test ValidateStringInput with Empty String             | Call `ValidateStringInput` with "".                                                                                                    | `false` is returned for empty string.         |               |           |                              |
| UT8          | Test validateHomeBuyingFundPercentage Within Limit     | Call `validateHomeBuyingFundPercentage` with 10.                                                                                       | `true` is returned for input within 0-15%.    |               |           |                              |
| UT9          | Test validateHomeBuyingFundPercentage Exceeding Limit  | Call `validateHomeBuyingFundPercentage` with 20.                                                                                       | `false` is returned for input exceeding 15%.  |               |           |                              |
| UT10         | Test validateCostOfLiving with Positive Value          | Call `validateCostOfLiving` with 100.                                                                                                  | `true` is returned for positive value.        |               |           |                              |
| UT11         | Test validateCostOfLiving with Non-Positive Value      | Call `validateCostOfLiving` with 0.                                                                                                    | `false` is returned for non-positive value.   |               |           |                              |
| UT12         | Test validatePersonalHolidays Within Range             | Call `validatePersonalHolidays` with 15.                                                                                               | `true` is returned for holidays within 0-20.  |               |           |                              |
| UT13         | Test validatePersonalHolidays Exceeding Range          | Call `validatePersonalHolidays` with 25.                                                                                               | `false` is returned for holidays exceeding 20.|               |           |                              |
| UT14         | Test validateMonthlyInternetStipend Within Range       | Call `validateMonthlyInternetStipend` with 50.                                                                                         | `true` is returned for stipend within $0-$75. |               |           |                              |
| UT15         | Test validateMonthlyInternetStipend Exceeding Range    | Call `validateMonthlyInternetStipend` with 100.                                                                                        | `false` is returned for stipend exceeding $75.|               |           |                              |
| UIT1         | Check accessibility of current job details input fields| Launch `CurrentJobActivity`, attempt to enter data into each field.                                                                    | All fields are accessible and editable.       |               |           | Espresso tests on Android.   |
| UIT2         | Verify 'Save' with valid inputs saves data             | Enter valid data in all fields of `CurrentJobActivity` and press 'Save'.                                                               | Data is saved, app navigates to the main menu.|               |           | Espresso tests on Android.   |
| UIT3         | Ensure user can add a new job offer                    | Navigate to `JobOfferActivity`, enter job offer details, and save.                                                                     | Job offer details are displayed correctly.    |               |           |                              |
| UIT4         | Test 'Cancel' action discards changes                  | Navigate to any input form, enter details, press 'Cancel'.                                                                             | Changes are discarded, app navigates back.    |               |           |                              |
| E2E1         | Simulate job offer comparison process                  | Start app, enter current job, add job offers, adjust comparison settings, perform comparison.                                          | Final comparison reflects all entered data.   |               |           |                              |
| E2E2         | Test flow without entering a current job               | Start app, add job offers, adjust comparison settings, perform comparison without a current job.                                        | App handles comparisons of offers correctly.  |               |           |                              |
| E2E3         | Test editing and updating job details                  | Enter and save a current job and a job offer, return to edit both, check updates are saved and reflected in comparison.                | Updates are correctly saved and reflected.    |               |           |                              |

