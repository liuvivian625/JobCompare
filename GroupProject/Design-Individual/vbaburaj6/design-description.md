
# Design Description Document

Main Menu & Actions: The JobOfferApp class is the starting point of the app. The User class lets you do things like adding or changing job information, putting in job offers, changing how job offers are compared, and comparing job offers.

Adding/Changing Current Job Info: Use the JobOffer class to put in or update details about your current job (like job title, company, and location). The User class has functions to help you do this.

Putting in Job Offers: You can enter details for job offers with the JobOffer class, just like you do for your current job. The User class helps you add these offers.

Changing How to Compare Jobs: The ComparisonSettings class lets you decide what parts of a job offer are most important to you by giving them weights.

Comparing Job Offers: With the User class, you can compare different job offers. It uses information from JobOffer and ComparisonSettings to figure out which job is better based on what's important to you.

Deciding Which Job is Better: The app calculates which job is better using a special formula in the User class that looks at all the details of a job and the weights you've set.



