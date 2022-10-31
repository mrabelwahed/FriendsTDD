package com.ramadan.freindstdd.signup

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.ramadan.freindstdd.MainActivity
import org.junit.Rule
import org.junit.Test
class SignupTest {

    @get:Rule
    val signUpTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun performSignUp() {
        launchSignupScreen(signUpTestRule) {
            typeEmail("ramadan@gmail.com")
            typePassword("123")
            submit()

        } verify{
            timelineScreenIsPresent()
        }
    }


}