package com.example.j11.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.twotone.Message
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.twotone.Lock
import androidx.compose.material.icons.twotone.Message
import androidx.compose.material.icons.twotone.PersonPin
import androidx.compose.material.icons.twotone.Phone
import androidx.compose.material.icons.twotone.QuestionMark
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.j11.R
import com.example.j11.features.ContactCard
import com.example.j11.features.LoginContactButton
import com.example.j11.features.NotificationCard
import com.example.j11.features.ProfileManagementCard

private val Lato = FontFamily(
    Font(R.font.lato_regular),
    Font(R.font.lato_bold, FontWeight.Bold)
)
private val LatoBold = FontFamily(Font(R.font.lato_bold))

@Composable
private fun SectionDivider() = HorizontalDivider(
    modifier = Modifier.padding(horizontal = 7.dp, vertical = 15.dp)
)

@Composable
fun ProfileScreen(
    userName: String = "UserName"
) {
    Scaffold(
        containerColor = Color(0xffe8f2ff)
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(12.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Text(
                "Profile",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 25.dp),
                fontSize = 30.sp,
                fontFamily = LatoBold,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            // User Info
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
                Column {
                    Text(
                        "Welcome",
                        style = TextStyle(fontSize = 14.sp, color = Color.Gray)
                    )
                    Text(
                        userName,
                        style = MaterialTheme.typography.headlineLarge,
                        fontFamily = Lato,
                        color = Color.Black
                    )
                }
            }

            SectionDivider()
            ProfileManagementCard(
                title = "User Profile",
                subTitle = "Manage your account",
                icon = Icons.TwoTone.PersonPin
            )
            SectionDivider()
            ProfileManagementCard(
                title = "Change Password",
                subTitle = "App login password",
                icon = Icons.TwoTone.Lock
            )
            SectionDivider()
            ProfileManagementCard(
                title = "FAQ",
                subTitle = "Feedback & Questions",
                icon = Icons.TwoTone.QuestionMark
            )
            SectionDivider()

            NotificationCard(title = "Push Notification")

            Spacer(modifier = Modifier.height(16.dp))

            ContactCard()

        }
    }
}

@Composable
@Preview
fun ProfilePagePreview() {
    ProfileScreen(
        userName = "Ahmad",
    )
}