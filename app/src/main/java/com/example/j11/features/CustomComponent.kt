package com.example.j11.features


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomLinearComponent(
    modifier: Modifier = Modifier,
    indicatorValue: Int = 0,
    maxIndicatorValue: Int = 100,
    backgroundColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
    foregroundColor: Color = Color(0xff007aff),
    strokeWidth: Float = 45f
) {

    val allowedIndicatorValue =
        indicatorValue.coerceAtMost(maxIndicatorValue)

    val animatedValue by animateFloatAsState(
        targetValue = allowedIndicatorValue.toFloat(),
        animationSpec = tween(1000)
    )

    val percentage = animatedValue / maxIndicatorValue

    Box(
        modifier = modifier
            .height(40.dp)
            .padding(8.dp)
            .drawBehind {

                val progressWidth = size.width * percentage

                drawLine(
                    color = backgroundColor,
                    start = Offset(0f, size.height / 2),
                    end = Offset(size.width, size.height / 2),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )

                drawLine(
                    color = foregroundColor,
                    start = Offset(0f, size.height / 2),
                    end = Offset(progressWidth, size.height / 2),
                    strokeWidth = strokeWidth,
                    cap = StrokeCap.Round
                )
            }
    )
}


@Composable
@Preview(showBackground = true)
fun CustomComponentPreview(){
    CustomLinearComponent()
}