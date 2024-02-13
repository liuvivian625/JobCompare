# Requirement 1
When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet). 

## Implement
User enters the app's main menu displaying the four buttons (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers, handled within the GUI.

There is a List object "jobList" initialized for a first time user.

# Requirement 2
When choosing to enter current job details, a user will:
1. Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of:
    - Title
    - Company
    - Location (entered as city and state)
    - Cost of living in the location (expressed as an index)
    - Yearly salary 
    - Yearly bonus 
    - Number of stock option shares offered
    - Home Buying Program fund (one-time dollar amount up to 15% of Yearly Salary)
    - Personal Choice Holidays (A single overall number of days from 0 to 20)
    - Monthly Internet Stipend ($0 to $75 inclusive)
2. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

## Implement
2.1 First to check database to see if currentJob is empty by calling "isCurrentJobEmpty". "isCurrentJob" is a field of Class "Job". If it returns true, a new object "currentJob" is created by calling "Job" class, set "isCurrentJob" to true, and then read user's input to set field values. If it returns false, query the database to get all the values of the non-empty fields of the currentJob stored in database and display. If user chooses to edit the details, read user's input to set field values.

2.2 If user chooses to save the job details, then update database. If user chooses to cancel and exit without saving, set all fields to none. Return to the main menu is handled within GUI.

# Requirement 3
When choosing to enter job offers, a user will:
1. Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.
2. Be able to either save the job offer details or cancel.
3. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

## Implement
3.1 If user chooses "enter job offers", a new object "jobOffer" is created by calling class "Job". "isCurrentJob" is set to false. Read user's input to set Job's fields. 

3.2 If user chooses save, update the database. If user chooses cancel, set all fields to none.

3.3 GUI to pop out a new menu to let user to choose from (1)(2)(3). If user chooses (1) enter another job, then repeat 3.1. If user chooses (2) return to main menu, handle this within GUI. If user hasn't saved the jobOffer, (3) compare the job is disabled. If user has saved, user can choose (3) compare the offer, calling "isCurrentJobEmpty" to check if the currentJob is empty, if it returns false, calling "JobComparator.showSelectedJobs(currentJob, currentJobOffer)" to display the fields of each job. If "isCurrentJobEmpty" returns true, throw error message "Current job is empty".

# Requirement 4
When adjusting the comparison settings, the user can assign integer weights to:
- Yearly salary
- Yearly bonus
- Number of Stock Option Shares Offered
- Home Buying Program Fund
- Personal Choice Holidays
- Monthly Internet Stipend

If no weights are assigned, all factors are considered equal.

## Implement
If user chooses adjust the comparison settings, if first time, call "JobComparator.setWeights" to set all values to 5. The range of weights values is [1,9].  Display weight values in GUI. Read user input and set weight values.

# Requirement 5
When choosing to compare job offers, a user will:
1. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
2. Select two jobs to compare and trigger the comparison.
3. Be shown a table comparing the two jobs, displaying, for each job:
    - Title
    - Company
    - Location 
    - Yearly salary adjusted for cost of living
    - Yearly bonus adjusted for cost of living
    - Number of Stock Option Shares Offered
    - Home Buying Program fund (one-time up to 15% of Yearly Salary)
    - Personal Choice Holidays (A single overall number of days from 0 to 20) 
    - Monthly Internet Stipend ($0 to $75 inclusive monthly)
4. Be offered to perform another comparison or go back to the main menu.

## Implement
5.1 If user chooses compare job offers, query database to get a list of jobOffers and currentJob, if length of the list is larger than 1, call "JobComparator.sort" to sort the all jobOffers including currentJob, then call "JobComparator.showList" to display the sort result. If "isCurrentJobEmpty" returns false, call "Job.markCurrentJob()" to mark the current job. If length of the list is not larger than 1, throw error message "You need to have at least two jobs to compare." 

5.2 User selects two jobs in GUI. Using the index, call "JobComparator.showSelectedJobs(Job1, Job2)".

5.3 "JobComparator.showSelectedJobs(Job1, Job2)" calls each argument's get field methods to get all the field values except Yearly salary adjusted and Yearly bonus adjusted. For these two items, "Job1/Job2.calculateAdjustSalary()" and "Job1/Job2.calculateAdjustBonus()" are called to return the values.

5.4 Gui to handle perform another comparison. If yes, then repeat from 5.1.

# Requirement 6
When ranking jobs, a job’s score is computed as the weighted average of:

AYS + AYB + (CSO/3) + HBP + (PCH * AYS / 260) + (MIS*12)

where:
- AYS = yearly salary adjusted for cost of living
- AYB = yearly bonus adjusted for cost of living
- CSO = Company shares offered (assuming a - -3-year vesting schedule and a price-per-share of $1)
- HBP = Home Buying Program
- PCH = Personal Choice Holidays 
- MIS= Monthly Internet Stipend 

For example, if the weights are 2 for the yearly salary, 2 for the yearly bonus, 2 for Internet Stipend, and 1 for all other factors, the score would be computed as:

2/9 * AYS + 2/9 * AYB + 1/9 * (CSO/3) + 1/9 * HBP + 1/9 * (PCH * AYS / 260) + 2/9 * (MIS*12)

## Implement
In the "JobComparator.sort" method, "calculateJobScore" is called using the formula to calculate each job's score.

# Requirement 7
The user interface must be intuitive and responsive.

## Implement
This is not represented in my design, as it will be handled entirely within the GUI implementation.

# Requirement 8
For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

## Implement
N/A






