package pamo.bmicalc;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.closeSoftKeyboard;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

@RunWith(AndroidJUnit4.class)
public class BMICalculatorInstrumentedTest {

    @Rule
    public ActivityScenarioRule<HomeActivity> activityRule =
            new ActivityScenarioRule<>(HomeActivity.class);

    @Test
    public void calculateBMI_validInput_showsResult() {
        onView(withId(R.id.enterWeight)).perform(typeText("70"));
        closeSoftKeyboard();
        onView(withId(R.id.enterHeight)).perform(typeText("175"));
        closeSoftKeyboard();
        onView(withId(R.id.calculate)).perform(click());

        onView(withId(R.id.result)).check(matches(withText(org.hamcrest.Matchers.containsString("BMI"))));
    }
}
