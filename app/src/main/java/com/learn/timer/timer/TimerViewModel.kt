package com.learn.timer.timer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class TimerViewModel(private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO) : ViewModel() {

    private val _timerCount = MutableLiveData<String>()
    val timerCount: LiveData<String> = _timerCount

    private val _isTimerRunning = MutableLiveData<Boolean>()
    val isTimerRunning: LiveData<Boolean> = _isTimerRunning

    private var counter = 0

    private var job: Job? = null

    init {
        _isTimerRunning.value = false
        _timerCount.value = convertToTimerString(0)
    }

    fun toggleTimerState() {
        if (_isTimerRunning.value == false) {
            _isTimerRunning.value = true
            startTimer()
        } else {
            _isTimerRunning.value = false
            job?.cancel()
        }
    }

    private fun startTimer() {
        job = viewModelScope.launch(defaultDispatcher) {
            while (_isTimerRunning.value == true) {
                delay(1_000)
                if (counter == MAX_TIME) {
                    counter = 0
                } else {
                    counter++
                }
                _timerCount.postValue(convertToTimerString(counter))
            }
        }
    }

    fun resetTimer() {
        if (_isTimerRunning.value == true) {
            toggleTimerState()
        }
        counter = 0
        _timerCount.postValue(convertToTimerString(counter))
    }


    private fun convertToTimerString(timeInt: Int): String {
        return "${(timeInt / 60).toString().padStart(2, '0')}:${
            (timeInt % 60).toString().padStart(2, '0')
        }"
    }

    companion object {
        private const val MAX_TIME = 3_659
    }

}