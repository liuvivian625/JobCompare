1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).

        This should be handled by GUI implementation.

2. When choosing to enter current job details, a user will:

   a. Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of …

       This should be handled by GUI implementation.

   b. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

        If saveJob button is hit, all the information in the GUI fields will be packed as a Job instance and be 

        persistent in job field of SystemManager. If exit is hit, GUI will handle the interface but nothing to do in the backend.

3. When choosing to enter job offers, a user will:

   a. Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.

       This should be handled by GUI implementation.

    b. Be able to either save the job offer details or cancel.

        This should be similar to 2-b, saving the offer as a Job instance, and append it to the offers map field of 

        SystemManager to persistent.

    c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with

    the current job details (if present).

        (1)(2) will be handled by GUI implementation. (3) will call SystemManager compareJobs(), and pass the offer 

        instance and the SystemManager job instance, the function will compute


4. When adjusting the comparison settings, the user can assign integer weights to…, If no weights are assigned, all 

   factors are considered equal.

        When SystemManager is initialized, assign a Weight instance to weight field, all entries of which are equal to 1. 

        When adjustComparisonSettings() is called, the parameters passed to the function will be assigned to the weight 

        instance related fields.

5. When choosing to compare job offers, a user will:

    a. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details),

    and including the current job (if present), clearly indicated.

       Call rankJobs(), which will call computeScore() for all the job and offers, and then sort them by score value. 

       Current job will be identified based on Job isCurrentJob flag.

    b. Select two jobs to compare and trigger the comparison.

       This should be handled by GUI implementation.

    c. Be shown a table comparing the two jobs, displaying, for each job:

       rankJobs() should already return all the Job instances, GUI just needs to display the selected ones with required

       level of details.

    d. Be offered to perform another comparison or go back to the main menu.

       This should be handled by GUI implementation.

6. When ranking jobs, a job’s score is computed as the weighted average of …

        The score formula will be reflected in the implementation of computeScore() function. computeScore() will read 

        in SystemManager weight field to determine related parameters.

7. The user interface must be intuitive and responsive.

        This should be handled by GUI implementation.

8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices 

   is necessary).

         Nothing special to do.


