package edu.gatech.seclass.jobcompare6300;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class JobOfferActivityTest {

    @Rule
    public ActivityScenarioRule<JobOfferActivity> activityRule = new ActivityScenarioRule<>(JobOfferActivity.class);

    @Test
    public void saveJobOfferDetails() {
        onView(withId(R.id.editTextTitleJobOffer)).perform(typeText("Software Engineer"), closeSoftKeyboard());
        onView(withId(R.id.editTextCompanyJobOffer)).perform(typeText("Innovatech"), closeSoftKeyboard());
        onView(withId(R.id.editTextCityJobOffer)).perform(typeText("San Francisco"), closeSoftKeyboard());
        onView(withId(R.id.editTextStateJobOffer)).perform(typeText("CA"), closeSoftKeyboard());
        onView(withId(R.id.editTextLivingCostJobOffer)).perform(typeText("150"), closeSoftKeyboard());
        onView(withId(R.id.editTextYearlySalaryJobOffer)).perform(typeText("120000"), closeSoftKeyboard());
        onView(withId(R.id.editTextYearlyBonusJobOffer)).perform(typeText("10000"), closeSoftKeyboard());
        onView(withId(R.id.editTextStockJobOffer)).perform(typeText("500"), closeSoftKeyboard());
        onView(withId(R.id.editTextHomeFundJobOffer)).perform(typeText("15"), closeSoftKeyboard());
        onView(withId(R.id.editTextHolidaysJobOffer)).perform(typeText("15"), closeSoftKeyboard());
        onView(withId(R.id.editTextInternetJobOffer)).perform(typeText("60"), closeSoftKeyboard());

        closeSoftKeyboard();

        onView(withId(R.id.buttonSaveJobOffer)).perform(click());
    }
}
