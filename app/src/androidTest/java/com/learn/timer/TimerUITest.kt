package com.learn.timer

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.learn.timer.theme.TimerTheme
import com.learn.timer.timer.TimerScreen
import com.learn.timer.timer.TimerScreenUI
import org.junit.Rule
import org.junit.Test

class TimerUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifyInitialTimerUI() {
        composeTestRule.setContent {
            TimerTheme {
                TimerScreenUI(timerString = "00:00", isTimerRunning = false, toggleTimer = {}, resetTimer = {})
            }
        }
        composeTestRule.onNodeWithText("00:00").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Start").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Reset").assertIsDisplayed()
    }

    @Test
    fun verifyTimerClockUI() {
        composeTestRule.setContent {
            TimerTheme {
                TimerScreenUI(timerString = "00:20", isTimerRunning = false, toggleTimer = {}, resetTimer = {})
            }
        }
        composeTestRule.onNodeWithText("00:20").assertIsDisplayed()
    }

    @Test
    fun verifyStopButton() {
        composeTestRule.setContent {
            TimerTheme {
                TimerScreenUI(timerString = "00:00", isTimerRunning = true, toggleTimer = {}, resetTimer = {})
            }
        }
        composeTestRule.onNodeWithContentDescription("Stop").assertIsDisplayed()
    }

    @Test
    fun verifyStartButton() {
        composeTestRule.setContent {
            TimerTheme {
                TimerScreenUI(timerString = "00:00", isTimerRunning = false, toggleTimer = {}, resetTimer = {})
            }
        }
        composeTestRule.onNodeWithContentDescription("Start").assertIsDisplayed()
    }

}