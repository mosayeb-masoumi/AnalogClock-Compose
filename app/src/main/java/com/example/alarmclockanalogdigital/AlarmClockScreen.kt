package com.example.alarmclockanalogdigital

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alarmclockanalogdigital.components.AnalogClockComponent
import com.example.alarmclockanalogdigital.components.NavigationBarComponent
import com.example.alarmclockanalogdigital.ui.theme.AlarmClockAnalogDigitalTheme
import kotlinx.coroutines.delay
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmClockScreen() {

    var hour by remember { mutableStateOf("0") }
    var minute by remember { mutableStateOf("0") }
    var second by remember { mutableStateOf("0") }
    var amOrPm by remember { mutableStateOf("0") }

    LaunchedEffect(Unit) {
        while (true) {
            val cal = Calendar.getInstance()
            hour = cal.get(Calendar.HOUR).run {
                if (this.toString().length == 1) "0$this" else "$this"
            }
            minute = cal.get(Calendar.MINUTE).run {
                if (this.toString().length == 1) "0$this" else "$this"
            }
            second = cal.get(Calendar.SECOND).run {
                if (this.toString().length == 1) "0$this" else "$this"
            }

            amOrPm = cal.get(Calendar.AM_PM).run {
                if (this == Calendar.AM) "AM" else "PM"
            }

            delay(1000)  // update every second
        }
    }

    Scaffold(
        bottomBar = { NavigationBarComponent() }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeaderComponent()
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight(fraction = 0.8f),
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AnalogClockComponent(
//                            hour = hour.toInt(),
                            hour = getHour(minute.toInt(), hour.toInt()),
                            minute = minute.toInt(),
                            second = second.toInt()
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        DigitalClockComponent(
                            hour = hour,
                            minute = minute,
                            amOrPm = amOrPm
                        )
                    }

                }
            }
        }
    }
}

fun getHour(minute: Int, hour: Int): Double {

    var newHour: Double
    minute.run {
        when {
            minute <= 3 -> {
                newHour = hour.toDouble()
            }

            minute <= 9 -> {
                newHour = (hour + 0.1)
            }

            (minute <= 15) -> {
                newHour = (hour + 0.2)
            }

            (minute <= 21) -> {
                newHour = (hour + 0.3)
            }

            (minute <= 27) -> {
                newHour = (hour + 0.4)
            }

            (minute <= 33) -> {
                newHour = (hour + 0.5)
            }

            (minute <= 39) -> {
                newHour = (hour + 0.6)
            }

            (minute <= 45) -> {
                newHour = (hour + 0.7)
            }

            (minute <= 51) -> {
                newHour = (hour + 0.8)
            }

            (minute < 57) -> {
                newHour = (hour + 0.9)
            }

            else -> {
                newHour = hour.toDouble()
            }
        }

    }

    return newHour
}

@Composable
fun DigitalClockComponent(
    hour: String,
    minute: String,
    amOrPm: String
) {
    Text(text = "$hour:$minute: $amOrPm", style = MaterialTheme.typography.titleLarge)
    Text(
        text = "Tehran  Iran",
        style = TextStyle(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f))
    )
}

@Composable
fun HeaderComponent() {
    Box(modifier = Modifier.padding(vertical = 16.dp)) {
        Text(text = "Clock", style = MaterialTheme.typography.titleMedium)
    }
}


@Preview(showBackground = true)
@Composable
fun AlarmClockScreenPreview() {
    AlarmClockAnalogDigitalTheme {
        AlarmClockScreen()
    }
}