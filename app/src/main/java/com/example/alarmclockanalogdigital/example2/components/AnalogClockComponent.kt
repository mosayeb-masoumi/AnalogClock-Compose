package com.example.alarmclockanalogdigital.example2.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alarmclockanalogdigital.ui.theme.AnalogClockHourHandColor
import com.example.alarmclockanalogdigital.ui.theme.AnalogClockInnerBoxColor
import com.example.alarmclockanalogdigital.ui.theme.AnalogClockMinuteHandColor
import com.example.alarmclockanalogdigital.ui.theme.AnalogClockOuterBoxColor
import com.example.alarmclockanalogdigital.ui.theme.AnalogClockSecondHandColor
import kotlin.math.min

@Composable
fun AnalogClockComponent(
    hour: Double,
    minute: Int,
    second: Int
) {

    Box(
        modifier =
        Modifier
            .fillMaxSize(fraction = 0.6f)
            .aspectRatio(1f)
            .clip(CircleShape)
            .background(color = AnalogClockOuterBoxColor),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier =
            Modifier
                .fillMaxSize(fraction = 0.78f)
                .aspectRatio(1f)
                .clip(CircleShape)
                .background(color = AnalogClockInnerBoxColor)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val diameter = min(size.width, size.height) * 0.9f
                val radius = diameter / 2


                repeat(12) {  // 12 is 1 to 12 (round the clock)

                    val start = center - Offset(0f, radius)
                    val end = start + Offset(0f, radius / 40f)

                    rotate(it / 12f * 360) {
                        drawLine(
                            color = Color.Black.copy(alpha = 0.5f),
                            start = start,
                            end = end,
                            strokeWidth = 5.dp.toPx(),
                            cap = StrokeCap.Round
                        )
                    }
                }


//            // to create the center  red circle
//            drawCircle(
//                color = AnalogClockSecondHandColor,
//                radius = 5.dp.toPx(),
//                center = center
//
//            )

                // create handles
                val secondRatio = second / 60f
                val minuteRatio = minute / 60f
                val hourRatio = hour / 12f

                // create hourHand
                rotate(hourRatio.toFloat() * 360, center) {
                    drawLine(
                        color = AnalogClockHourHandColor,
                        start = center - Offset(0f, radius * 0.4f),
                        end = center + Offset(0f, radius * 0.1f),
                        strokeWidth = 3.8.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }

                // create minuteHand
                rotate(minuteRatio * 360, center) {
                    drawLine(
                        color = AnalogClockMinuteHandColor,
                        start = center - Offset(0f, radius * 0.6f),
                        end = center + Offset(0f, radius * 0.1f),
                        strokeWidth = 3.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }

                // create secondHand
                rotate(secondRatio * 360, center) {
                    drawLine(
                        color = AnalogClockSecondHandColor,
                        start = center - Offset(0f, radius * 0.7f),
                        end = center + Offset(0f, radius * 0.1f),
                        strokeWidth = 3.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }

                // to create the center  red circle
                drawCircle(
                    color = AnalogClockSecondHandColor,
                    radius = 5.dp.toPx(),
                    center = center

                )

            }
        }


    }

}


@Preview(showBackground = true)
@Composable
fun AnalogClockComponentPreview() {
    AnalogClockComponent(10.5, 10, 30)
}