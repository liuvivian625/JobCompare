# Test Plan

*This is the template for your test plan. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: \<Jing Liu\>

## 1 Testing Strategy

### 1.1 Overall strategy

*This section should provide details about your unit-, integration-, system-, and regression-testing strategies. In particular, it should discuss which activities you will perform as part of your testing process, and who will perform such activities.*

Our testing strategy includes both unit testing, integration testing, and system testing. Unit testing will be performed by individual team members for their respective code modules. Integration testing will focus on testing the interaction between different components of the application. It will be conducted by all the team members. System testing will be conducted by all the team members to ensure the integration and functionality of the entire system.

### 1.2 Test Selection

*Here you should discuss how you are going to select your test cases, that is, which black-box and/or white-box techniques you will use. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

For unit testing:
- Black-box testing will focus on testing the external behavior of each unit.
- White-box testing will focus on testing the internal logic and structure of each unit.

For integration testing:
- Black-box testing will focus on testing the interaction between different components of the app to see if they can work together to achieve desired functionality.

For System testing:
- Black-box testing will focus on testing the functionality of the app as a whole.
- This will include testing various user scenarios, edge cases, and performance aspects of the application.

### 1.3 Adequacy Criterion

*Define how you are going to assess the quality of your test cases. Typically, this involves some form of functional or structural coverage. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

We will assess the quality of our test cases based on both functional and structural coverage. Functional coverage will ensure that all specified requirements are tested, while structural coverage will ensure that all code paths are exercised.

### 1.4 Bug Tracking

*Describe how bugs and enhancement requests will be tracked.*

Bugs and enhancement requests will be tracked using JIRA. Each issue will be assigned a unique identifier and categorized based on severity and priority.

### 1.5 Technology

*Describe any testing technology you intend to use or build (e.g., JUnit, Selenium).*

For unit testing:
- Use JUnit.

For integration testing:
- Use Espresso.
- Focus on user's interaction with each component.

For system testing:
- Manual testing for navigation.
- Use Espresso to test entire flow.

## 2 Test Cases

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.*

### 2.1 Unit Testing
| Test Case | Purpose | Steps | Expected Result | Actual Result | Pass/Fail | Additional Info |
|-----------|---------|-------|-----------------|---------------|-----------|----------------|
| TC-101    | Validate "enter current job" functionality | 1. call current job setters 2. call saveJob 3. print currentJob| Current job is created and printed fields matches entries | | | |
| TC-102    | Validate "enter job offers" | 1. call job offer setters 2. call saveJob 3. repeat to create another job offer 4. print job offer list | Job offers are correctly created and store in the list. | | | |
| TC-103    | Validate "calculate job score" functionality | 1. call weight setters to set different weights 2. call getJobScore | Job scores are correctly changed to reflect weight change. | | | |
| TC-104    | Validate "rank jobs" for current job and job offers | 1. create a current job and two job offers 2. call rankJobs | A job list is returned and it is in right order from highest score to lowest score| | | |
| TC-105    | Validate "display jobs" | 1. create a current job and a job offer 2. call displayJobs | Attributes with some adjustments of current job and job offer are returned| | | |

### 2.2 Integregation Testing
| Test Case | Purpose | Steps | Expected Result | Actual Result | Pass/Fail | Additional Info |
|-----------|---------|-------|-----------------|---------------|-----------|----------------|
| TC-201    | Validate integration between user input and "enter current job" | | | | |
| TC-202    | Validate integration between user input and "edit current job" | | | | |
| TC-203    | Validate integration between user input and "enter job offers" | | | | |
| TC-204    | Validate integration between user input and "adjust the comparison setting" | | | | |
| TC-205    | Validate integration between user selecting two jobs and compare | | | | |
| TC-205    | "enter current job" exception | user has invalid inputs when "enter current job" | | | |
| TC-206    | "enter job offers" exception | user has invalid inputs when "enter job offers" | | | |
| TC-207    | Compare job offer with current job exception | user doesn't have a current job and has only one job offer and hit compare | | | |
| TC-208    | Rank job exception | user has no current job and no job offers | | | |

### 2.3 System Testing
| Test Case | Purpose | Steps | Expected Result | Actual Result | Pass/Fail | Additional Info |
|-----------|---------|-------|-----------------|---------------|-----------|----------------|
| TC-301    | Validate user interface elements | 1. Navigate through all screens of the application 2. Verify the presence and functionality of UI elements (buttons, text fields, etc.) | All UI elements are present and functional without any visual or functional defects | | | |
| TC-302    | Validate user workflow | 1. Perform typical user actions such as enter current job, enter job offers, adjust comparison settings, compare jobs 2. Verify the application responds correctly to each action | Application responds correctly to user actions and progresses through expected workflows without errors | | | |
| TC-303    | Validate performance | 1. Simulate user interactions with the application 2. Monitor application response time and resource usage | Application maintains acceptable performance metrics (response time, resource utilization) under expected load conditions | | | |
