package com.ramadan.freindstdd.signup

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ramadan.freindstdd.MainActivity
import com.ramadan.freindstdd.R
typealias composeRule<T> = AndroidComposeTestRule<ActivityScenarioRule<T>, T>

fun launchSignupScreen(
    rule: composeRule<MainActivity>,
    block:  SignupRobot.()-> Unit) : SignupRobot{
   return SignupRobot(rule).apply(block)
}

class SignupRobot(private val rule: composeRule<MainActivity>) {
    fun typeEmail(email: String) {
     val emailHint = rule.activity.getString(R.string.email)
     rule.onNodeWithText(emailHint)
         .performTextInput(email)
    }

    fun typePassword(password: String) {
     val passwordHint = rule.activity.getString(R.string.password)
        rule.onNodeWithText(passwordHint)
            .performTextInput(password)
    }

    fun submit() {
      val passwordHint = rule.activity.getString(R.string.signup)
      rule.onNodeWithText(passwordHint).performClick()
    }

    infix fun verify(block: SignupVerification.() -> Unit) : SignupVerification{
       return SignupVerification(rule).apply(block)
    }
}


class  SignupVerification(private val rule: composeRule<MainActivity>){
    fun timelineScreenIsPresent() {
      val timeline = rule.activity.getString(R.string.timeline)
        rule.onNodeWithText(timeline)
            .assertIsDisplayed()
    }
}