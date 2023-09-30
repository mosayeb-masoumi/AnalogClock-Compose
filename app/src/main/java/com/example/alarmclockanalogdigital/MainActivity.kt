package com.example.alarmclockanalogdigital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.alarmclockanalogdigital.example1.AlarmClockExample1
import com.example.alarmclockanalogdigital.example2.AlarmClockExample2
import com.example.alarmclockanalogdigital.ui.theme.AlarmClockAnalogDigitalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlarmClockAnalogDigitalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //prefered
                    AlarmClockExample1()

//                    AlarmClockExample2()
                }
            }
        }
    }
}



