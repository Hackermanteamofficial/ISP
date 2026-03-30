package com.example.j11.features

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginButton(
    title: String
) {
    Box(
        modifier = Modifier
            .width(165.dp)
            .height(50.dp)
            .clip(
                shape= RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 16.dp,
                    bottomStart = 16.dp
                )
            )
            .background(
                Brush.verticalGradient(
                    listOf(Color.Transparent, Color.White.copy(.2f))
                )
            )
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 16.dp,
                    bottomStart = 16.dp
                ),
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.White.copy(0.5f)
                    )
                )
            )
            .clickable(
                onClick = {},
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            color = Color.White,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp,
                shadow = Shadow(color = Color.Black.copy(alpha = 0.2f), blurRadius = 4f)
            )
        )
    }
}

@Composable
@Preview(showBackground = false)
private fun LoginButtonPreview(){
    LoginButton(
        "Login"
    )
}