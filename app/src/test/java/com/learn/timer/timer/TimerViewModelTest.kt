package com.learn.timer.timer

import com.learn.timer.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.rules.TestRule


@ExperimentalCoroutinesApi
class TimerViewModelTest {

    private lateinit var viewModel: TimerViewModel

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @JvmField
    @Rule
    public var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = TimerViewModel(testDispatcher)
    }


    @Test
    fun `toggle timer starts timer if not running`() {
        testDispatcher.runBlockingTest {
            viewModel.toggleTimerState()
            val isTimerStarted = viewModel.isTimerRunning.getOrAwaitValue()
            viewModel.toggleTimerState()
            assertTrue(isTimerStarted)
        }
    }

    @Test
    fun `timer should show 0030 after 30 secs`() {
        testDispatcher.runBlockingTest {
            viewModel.toggleTimerState()
            advanceTimeBy(30_000)
            viewModel.toggleTimerState()
            val timerValue = viewModel.timerCount.getOrAwaitValue()
            assertEquals("00:30", timerValue)
        }
    }

    @Test
    fun `toggle timer stops timer if running`() {
        testDispatcher.runBlockingTest {
            viewModel.toggleTimerState() // start timer
            advanceTimeBy(1_000)
            viewModel.toggleTimerState() // resume timer
            val isTimerStopped = !viewModel.isTimerRunning.getOrAwaitValue()
            assertTrue(isTimerStopped)
        }
    }

    @Test
    fun `toggle timer resume timer if stopped`() {
        testDispatcher.runBlockingTest {
            viewModel.toggleTimerState() // start timer
            advanceTimeBy(1_000)
            viewModel.toggleTimerState() // pause timer
            advanceTimeBy(1_000)
            viewModel.toggleTimerState() // resume timer
            val isTimerStopped = viewModel.isTimerRunning.getOrAwaitValue()
            viewModel.toggleTimerState() // exit infinite loop
            assertTrue(isTimerStopped)
        }
    }

    @Test
    fun `timer should reset after reset timer`() {
        testDispatcher.runBlockingTest {
            viewModel.toggleTimerState()
            viewModel.isTimerRunning.getOrAwaitValue()
            viewModel.resetTimer()
            val timerValue = viewModel.timerCount.getOrAwaitValue()
            assertEquals("00:00", timerValue)
        }
    }

    @After
    fun tearDown() {
        testDispatcher.cleanupTestCoroutines()
    }


}