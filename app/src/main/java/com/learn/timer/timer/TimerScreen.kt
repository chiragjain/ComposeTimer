package com.learn.timer.timer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FastRewind
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Replay
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.learn.timer.R
import com.learn.timer.theme.TimerTextStyle
import com.learn.timer.theme.TimerTheme

@Composable
fun TimerScreen(timerViewModel: TimerViewModel = viewModel()) {
    val timerString by timerViewModel.timerCount.observeAsState("00:00")
    val isTimerRunning by timerViewModel.isTimerRunning.observeAsState(false)

    TimerTheme {
        Scaffold(topBar = {
            TimerTopAppBar()
        }) {
            TimerScreenUI(
                timerString,
                isTimerRunning,
                timerViewModel::toggleTimerState,
                timerViewModel::resetTimer
            )
        }
    }
}

@Composable
private fun TimerTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = LocalContext.current.getString(R.string.app_name),
                Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        Modifier.fillMaxWidth(),
        backgroundColor = Color.White,
        contentColor = Color.Black
    )
}

@Composable
private fun TimerScreenUI(
    timerString: String,
    isTimerRunning: Boolean,
    toggleTimer: () -> Unit,
    resetTimer: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        TimerWidget(
            Modifier.padding(16.dp),
            timerString
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            StartStopButton(isTimerRunning, toggleTimer)
            Spacer(
                modifier = Modifier
                    .width(8.dp)
            )
            ResetTimerButton(resetTimer)
        }
    }
}

@Composable
private fun StartStopButton(isTimerRunning: Boolean, toggleTimer: () -> Unit) {
    Button(
        onClick = { toggleTimer() },
        Modifier
            .padding(16.dp)
            .size(72.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White
        ),
        shape = CircleShape
    ) {
        if (isTimerRunning) {
            Icon(
                Icons.Filled.Pause,
                stringResource(id = R.string.label_stop),
                Modifier.size(48.dp),
                tint = Color.White
            )
        } else {
            Icon(
                Icons.Filled.PlayArrow,
                stringResource(id = R.string.label_start),
                Modifier.size(48.dp),
                tint = Color.White
            )
        }
    }
}

@Composable
private fun ResetTimerButton(resetTimer: () -> Unit) {
    Button(
        onClick = { resetTimer() },
        Modifier
            .padding(16.dp)
            .size(72.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White
        ),
        shape = CircleShape
    ) {
        Icon(
            Icons.Filled.Replay,
            stringResource(id = R.string.label_stop),
            Modifier.size(48.dp),
            tint = Color.White
        )
    }
}

@Composable
private fun TimerWidget(modifier: Modifier = Modifier, timeString: String = "00:00") {
    Text(
        text = timeString,
        style = TimerTextStyle,
        modifier = modifier
    )
}

@Preview
@Composable
private fun TimeScreenPreview() {
    TimerTheme {
        TimerScreenUI("00:00", false, {}, {})
    }
}