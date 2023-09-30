package com.example.alarmclockanalogdigital.example2.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.alarmclockanalogdigital.R
import com.example.alarmclockanalogdigital.ui.theme.NavigationBarColor

@Composable
fun NavigationBarComponent() {
    NavigationBar(
        modifier = Modifier.clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp)),
        containerColor = NavigationBarColor
    ) {

        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_alarm_24),
                    contentDescription = null
                )
            },
            selected = false, onClick = { })
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_hourglass_bottom_24),
                    contentDescription = null
                )
            },
            selected = false, onClick = { })
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_access_time_24),
                    contentDescription = null
                )
            },
            selected = true, onClick = { })
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_timer_24),
                    contentDescription = null
                )
            },
            selected = false, onClick = { })
        NavigationBarItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_hotel_24),
                    contentDescription = null
                )
            },
            selected = false, onClick = { })
    }
}