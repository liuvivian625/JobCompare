package edu.gatech.seclass.jobcompare6300;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CurrentJobActivityEspressoTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSaveCurrentJobDetailsNavigatesBackToMainActivity() {
        onView(withId(R.id.buttonCurrentJob)).perform(click());

        onView(withId(R.id.editTextTitleCurrentJob)).perform(typeText("Software Engineer"), closeSoftKeyboard());
        onView(withId(R.id.editTextCompanyCurrentJob)).perform(typeText("ABC"), closeSoftKeyboard());
        onView(withId(R.id.editTextCityCurrentJob)).perform(typeText("Atlanta"), closeSoftKeyboard());
        onView(withId(R.id.editTextStateCurrentJob)).perform(typeText("GA"), closeSoftKeyboard());
        onView(withId(R.id.editTextLivingCostCurrentJob)).perform(typeText("120"), closeSoftKeyboard());
        onView(withId(R.id.editTextYearlySalaryCurrentJob)).perform(typeText("85000"), closeSoftKeyboard());
        onView(withId(R.id.editTextYearlyBonusCurrentJob)).perform(typeText("5000"), closeSoftKeyboard());
        onView(withId(R.id.editTextStockCurrentJob)).perform(typeText("150"), closeSoftKeyboard());
        onView(withId(R.id.editTextHomeFundCurrentJob)).perform(typeText("10"), closeSoftKeyboard());
        onView(withId(R.id.editTextHolidaysCurrentJob)).perform(typeText("15"), closeSoftKeyboard());
        onView(withId(R.id.editTextInternetCurrentJob)).perform(typeText("50"), closeSoftKeyboard());

        onView(withId(R.id.buttonSaveCurrentJob)).perform(click());

        onView(withId(R.id.buttonCurrentJob)).check(matches(isDisplayed()));
    }
}
