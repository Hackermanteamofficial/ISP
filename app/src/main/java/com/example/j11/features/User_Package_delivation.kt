package com.example.j11.features

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserPackageDelivation() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xffe8f2ff)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center

            ) {
            //Text("Ahmad")

            Column{
                Text(
                    "25.5 GB / 50 GB",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 23.sp,
                        color = Color.Black
                    )
                )
                Text(
                    "57 days / 70 days",
                    style = TextStyle(
                        color = Color.DarkGray.copy(alpha = .8f)
                    )
                )
            }
        }

        CustomLinearComponent(
            modifier = Modifier
                .fillMaxWidth(),
            indicatorValue = 50,
            backgroundColor = Color.Gray.copy(.7f),
        )
    }
}


@Composable
@Preview(showBackground = true)
private fun UserPackageDelivationPreview() {
    UserPackageDelivation()
}