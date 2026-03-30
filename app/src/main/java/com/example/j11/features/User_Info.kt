package com.example.j11.features

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.j11.R

@SuppressLint("ModifierParameter")
@Composable
fun UserInfo(
    userName: String = "UserName",
    userId: Int = 123456789,
    remainingGb: Float = 43f,
    isOnline: Boolean = true,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    userName,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
                Text(
                    "ID: $userId",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.DarkGray
                )
                Text(
                    " Remaining: ${remainingGb}GB",
                    style = MaterialTheme.typography.labelMedium,
                    color = if (remainingGb < 2f)
                        MaterialTheme.colorScheme.error
                    else
                        Color.Black
                )
            }

            Box {
                Image(
                    painter = painterResource(R.drawable.avatar),
                    contentDescription = "$userName avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(52.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color(0xFF007AFF), CircleShape)
                )
                Box(
                    modifier = Modifier
                        .size(13.dp)
                        .background(
                            if (isOnline) Color(0xFF34C759) else Color.Gray,
                            CircleShape
                        )
                        .border(2.dp, Color.White, CircleShape)
                        .align(Alignment.BottomEnd)
                )
            }
        }
    }
}


@Composable
@Preview
private fun UserInfoPreview(){
    UserInfo(
        userName = "Ahmad",
        remainingGb = 66f,
        isOnline = false,
        userId = 5456576
    )
}