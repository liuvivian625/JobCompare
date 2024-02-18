1. When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).

       When the application initializes, it initiates a MainMenu object to serve as the overarching system controller. It will initate a GlobalStorage object to store all the information including job/offer/comparison weights to process in the future. The main menu GUI prominently features four buttons corresponding to distinct functionalities, guiding users to each respective page. Within each individual page, the requisite functions invoke the relevant public methods of the MainMenu object to execute the necessary tasks seamlessly. 

2. When choosing to enter current job details, a user will:

   a. Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of …

       When the user accesses the current job page, the system checks if the GlobalStorage.currentJob field is set. If the field is not Null, the GUI displays input boxes pre-filled with stored values corresponding to the attributes. Otherwise, it presents empty input boxes to collect user inputs. Beneath the input boxes, a "Save" button is provided to transmit the collected information to the backend. Additionally, the interface includes a "Cancel" button to discard the current input and a "Return" button to navigate back to the previous screen.

   b. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

       When a user clicks the "Save" button, the backend retrieves all information from input boxes, processing them through a Util class that manages input validation and type conversion. Subsequently, the backend invokes the GlobalStorage.addCurrentJob() method to instantiate a new Job object, saving it within the GlobalStorage.currentJob field. In the event of "Cancel", the GUI clears all input box contents. Upon selecting "Exit," the GUI navigates back to the main menu page.

3. When choosing to enter job offers, a user will:

   a. Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.

       This should be handled by GUI implementation: The GUI will present empty input boxes for all necessary attributes to gather user inputs, alongside a "Save" button to transmit the collected information to the backend. Additionally, it will feature a "Add Another" & "Cancel" button to discard the current input to prepare for the new input, and a "Return" button to navigate back to the previous screen. Also a "Compare with Current Job" button for 3-c(3).

    b. Be able to either save the job offer details or cancel.

       When a user clicks the "Save" button, the backend retrieves all information from input boxes, processing them through a Util class that manages input validation and type conversion. Subsequently, the backend invokes the GlobalStorage.addJobOffer() method to instantiate a new Job object, append it to the GlobalStorage.jobOffers list. In the event of "Cancel", the GUI clears all input box contents.

    c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

       (1)(2) should be handled by GUI implementation: (1) When a user clicks the "Add Another" button, the GUI will clear the input box (2) Upon selecting "Exit," the GUI navigates back to the main menu page. 
        
       (3)When the "Compare with Current Job" button is activated, the system triggers the displayJob() function. Initially, this function verifies whether GlobalStorage.currentJob is not null and also checks if GlobalStorage.jobOffers list is not empty. If both conditions are met, it proceeds to generate a list of Job instances. The first instance is set to GlobalStorage.currentJob, while the second instance is assigned the values from the last entry in the OffersGlobalStorage.jobOffers list.


4. When adjusting the comparison settings, the user can assign integer weights to…, If no weights are assigned, all factors are considered equal.

       Upon initialization of the MainMenu, a ComparisonSettings instance is created with all entries set to 1, and subsequently stored in GlobalStorage.comparisonSettings. Upon accessing the adjust comparison page, the current ComparisonSettings from GlobalStorage is retrieved and displayed to the user. If the user modifies any field and clicks "Adjust," the adjustComparisonSettings() function is invoked. This function processes the parameters using Util and updates the corresponding field accordingly.

5. When choosing to compare job offers, a user will:

    a. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.

       Upon accessing the Compare Job page, the initial action involves invoking the rankJobOffers() function. This function gathers all available jobs from GlobalStorage's currentJob and jobOffers fields, along with the weight attributes extracted from comparisonSettings. Subsequently, each job, along with the comparisonSettings, is passed to the computeScore() function to calculate the corresponding score. Following this computation, all jobs and their respective scores are sorted based on their score values, and the sorted list is returned for further processing.

       Current job will be identified based on Job object's isCurrentJob flag, and marked by GUI.

    b. Select two jobs to compare and trigger the comparison.

       This should be handled by GUI implementation: when exact two jobs are selected and user hits "Compare" button, then GUI leads user to 5-c.

    c. Be shown a table comparing the two jobs, displaying, for each job:

       This should be handled by GUI implementation: in 5-a, rankJobs() already return all the Job objects, GUI just needs to display the selected ones with required level of details.

    d. Be offered to perform another comparison or go back to the main menu.

       This should be handled by GUI implementation. "Compare" button will repeat 5-c for new selections and "Return" button for navigateing back to the main menu page.

6. When ranking jobs, a job’s score is computed as the weighted average of …
        
       When the function rankJobOffers() is invoked, it retrieves all available jobs from GlobalStorage's currentJob and jobOffers fields, along with the weight attributes from comparisonSettings. Subsequently, it passes the job and comparisonSettings to the computeScore() function, where the scoring formula is implemented. The computed score is then stored within the Job object, which is utilized for ranking within the rankJobOffers() function.

7. The user interface must be intuitive and responsive.

       This should be handled by GUI implementation.

8. For simplicity, you may assume there is a single system running the app (no communication or saving between devices 

   is necessary).

       Nothing special to do.


