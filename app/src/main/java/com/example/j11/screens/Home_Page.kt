package com.example.j11.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.RemoveModerator
import androidx.compose.material.icons.twotone.SatelliteAlt
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.j11.PremiumPackageCard
import com.example.j11.R
import com.example.j11.features.DetectionCard
import com.example.j11.features.UserInfo
import com.example.j11.features.UserPackageDelivation
import com.example.j11.ui.theme.LightBackgroundBlue


private val LatoBold = FontFamily(Font(R.font.lato_bold))
private val Lato = FontFamily(
    Font(R.font.lato_regular),
    Font(R.font.lato_bold, FontWeight.Bold)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {

    Scaffold { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LightBackgroundBlue)
                .padding(12.dp)
                .padding(contentPadding),
            verticalArrangement = Arrangement.spacedBy(13.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UserInfo()
            UserPackageDelivation()
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(
                    "Recommended Packages",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontFamily = Lato,
                        fontWeight = FontWeight.W600
                    )
                )
                AdPackageRow()
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(
                    "Devices Summary",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                )
                DeviceManagement()
            }
        }
    }
}


@Composable
fun DeviceManagement() {
    Row(
        modifier = Modifier.fillMaxWidth(),
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
fun AdPackageRow() {
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .horizontalScroll(scrollState),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        PremiumPackageCard(
            packageType = "Limited",
            netSpeed = 20,
            duration = 120,
            price = "4,400",
            dataAmount = "950"
        )
        PremiumPackageCard(
            packageType = "Limited",
            netSpeed = 4,
            duration = 90,
            price = "1,400",
            dataAmount = "250"
        )
        PremiumPackageCard(
            packageType = "Limited",
            netSpeed = 4,
            duration = 90,
            price = "1,400",
            dataAmount = "250"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HomePagePreview() {
    HomePage()
}

