package com.example.j11.features

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NotificationCard(
    title: String,
    onClick: () -> Unit = {}
) {
    var isOn by remember { mutableStateOf(true) }
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = Color(0xffe8f2ff)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                // متن
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
            }

            Switch(
                checked = isOn,
                onCheckedChange = { isOn = !isOn },
                colors = SwitchDefaults.colors(
                    //checkedIconColor = Color(0xff007aff),
                    checkedTrackColor = Color(0xff007aff),
                    uncheckedTrackColor = Color.Red.copy(alpha = .6f),
                    uncheckedThumbColor = Color.White,
                    uncheckedBorderColor = Color.Red

                ),
                thumbContent = {
                    if (isOn) {
                        Text("1")
                    } else {
                        Text("0")
                    }
                }
            )
        }
    }
}


@Composable
@Preview
private fun Preview() {
    NotificationCard(
        title = "Push notification"
    )
}