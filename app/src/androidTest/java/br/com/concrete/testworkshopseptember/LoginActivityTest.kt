package br.com.concrete.testworkshopseptember

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @get:Rule
    val activityRule = IntentsTestRule(LoginActivity::class.java)

    @Test
    fun givenInitialState_shouldHaveEmailAndPasswordEmpty() {
        onView(withId(R.id.email))
            .check(matches(withText("")))

        onView(withId(R.id.password))
            .check(matches(withText("")))
    }

    @Test
    fun givenEmailIsEmpty_whenLogin_shouldShowEmailIsEmptyMessage() {
        onView(withId(R.id.password))
            .perform(typeText("aA#21234"))

        onView(withId(R.id.login))
            .perform(click())

        onView(withText(R.string.error_email_is_empty))
            .check(matches(isDisplayed()))
    }

    @Test
    fun givenPasswordIsEmpty_whenLogin_shouldShowPasswordIsEmptyMessage() {
        onView(withId(R.id.email))
            .perform(typeText("wesley.marcolino@concrete.com.br"))

        onView(withId(R.id.login))
            .perform(click())

        onView(withText(R.string.error_password_is_empty))
            .check(matches(isDisplayed()))
    }

    @Test
    fun givenPasswordIsInvalid_whenLogin_shouldShowPasswordIsInvalidMessage() {
        onView(withId(R.id.email))
            .perform(typeText("wesley.marcolino@concrete.com.br"))
        onView(withId(R.id.password))
            .perform(typeText("12345678"))

        onView(withId(R.id.login))
            .perform(click())

        onView(withText(R.string.error_invalid_password))
            .check(matches(isDisplayed()))
    }

    @Test
    fun givenEmailAndPasswordAreValid_whenLogin_shouldGoToHomeActivity() {
        onView(withId(R.id.email))
            .perform(typeText("wesley.marcolino@concrete.com.br"))
        onView(withId(R.id.password))
            .perform(typeText("aA#21234"))

        onView(withId(R.id.login))
            .perform(click())

        intended(hasComponent(HomeActivity::class.java.name))
    }
}
