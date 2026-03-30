package com.example.j11.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.RemoveModerator
import androidx.compose.material.icons.twotone.SatelliteAlt
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.j11.R
import com.example.j11.features.DetectionCard
import com.example.j11.features.UserInfo
import com.example.j11.features.UserPackageDelivation


private val Lato = FontFamily(
    Font(R.font.lato_regular),
    Font(R.font.lato_bold, FontWeight.Bold)
)

@Composable
private fun SectionDivider() = HorizontalDivider(
    modifier = Modifier.padding(horizontal = 7.dp, vertical = 14.dp)
)

@Composable
fun HomePageSecond() {
    val scrollState = rememberScrollState()
    Scaffold (
        containerColor = Color(0xffe8f2ff)
    ){ contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(15.dp)
                .fillMaxSize()
                .verticalScroll(scrollState),

            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UserInfo()

            SectionDivider()

            UserPackageDelivation()


            Text(
                "Recommended Packages",
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 5.dp, start = 12.dp, bottom = 12.dp)
                    .fillMaxWidth(),
                fontFamily = Lato,
                fontSize = 17.sp
            )
            AdPackageRow()

            Text("Devices Summary",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 12.dp, bottom = 12.dp),
                fontFamily = Lato,
                fontSize = 17.sp,
                color = Color.Black
            )
            DevicesManagement()
        }
    }
}

@Composable
private fun DevicesManagement() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        DetectionCard(
            devices = 5,
            title = "Connected",
            icon = Icons.TwoTone.SatelliteAlt,
            modifier = Modifier
                .weight(1f)

        )
        DetectionCard(
            devices = 2,
            title = "Banned",
            icon = Icons.TwoTone.RemoveModerator,
            modifier = Modifier
                .weight(1f)

        )
    }
}

@Composable
@Preview(showBackground = true)
private fun HomePageSecondPreview() {
    HomePageSecond()
}