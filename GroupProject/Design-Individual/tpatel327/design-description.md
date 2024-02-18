## Assignment 5 Design Description 

#### Requirement: User sees main menu with 4 options.

This requirement is realized by the user opening the application and seeing a main menu with the 4 options: enterEditCurrentJob, NewJobOffer, ComparisonSettings and CompareJobs. These are all methods/operations that the user can click on to continue on with their task.

#### Requirement: User can enter current job details. User can save or cancel and exit as well.

This requirement is realized by the CurrentJobDetails class where a user can enter their current job details if it exists. There is a boolean that checks to see if there is a current job. If no job then the class will create a new Job object that the user can fill out. This object contains all the requirements for a Job which can be shown in the UML diagram. A user will then be able to save the current job details or cancel by the operations save() and cancelExit().

#### Requirement: User can enter a new job offer and then either be able to save, cancel, or compare the offer with the current job if it exists.

This requirement is realized by the Job Offer class which creates a new job offer which is a new Job Object. There is also a compareJob() operation which will compare the new job offer with the current job details if it exists. Current job details has a boolean for this specific reason and it if true it will allow the comparison else it will give an error. There is also a save, cancel exit and return to the main menu.

#### Requirement: User can adjust the comparison settings. User can choose to save or cancel.

This requirement is realized by the Comparison Settings class which is expressed in the UML diagram. There are attributes that relate to each field that has a weight. Users can save or cancel.


#### Requirement: Users can compare job offers, do more comparisons or go back to the main menu. Users can see a table with the 2 job offers.

This requirement is realized by the Job Offer class which has the ability to compare offers. Users will see their current job and a list of all the other job offers. Users can then 2 job offers (which doesn't have to be their current job) and compare the offers. This class will use the Compute Job Rank class and the Comparison Settings class to get details and weights to calculate a score. Then the score will be stored in the job object and finally a display method which will show the 2 offers.

#### Requirement: Ranking Jobs. 

This requirement is realized by the Compute Job Rank class which utilizes the Comparison Settings class. This class will compute a weighted average based on the job details, weights set by the user and the comparison settings. The compute method will use a weighted average formula shown in the original requirements document.
