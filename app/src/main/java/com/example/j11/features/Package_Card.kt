package com.example.j11


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.SignalCellularAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PremiumPackageCard(
    packageType: String,
    netSpeed: Int,
    duration: Int,
    price: String,
    dataAmount: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val changaOne = FontFamily(Font(R.font.changaone))
    val lato = FontFamily(
        Font(R.font.lato_regular),
        Font(R.font.lato_bold, FontWeight.Bold)
    )

    Surface(
        modifier = Modifier
            .padding(horizontal = .1.dp)
            .clip(RoundedCornerShape(20.dp))) {
        Card(
            modifier = modifier
                .width(185.dp)
                .height(235.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFE5E7EB),
                    shape = RoundedCornerShape(20.dp)
                ),
            shape = RoundedCornerShape(20.dp),
            onClick = onClick,
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                // ── Badge سرعت (مثل ProfileManagementCard — شروع از چپ)
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(Color(0xFF007AFF), Color(0xFF50C8CC))
                            ),
                            shape = RoundedCornerShape(
                                topEnd = 12.dp,
                                bottomEnd = 12.dp
                            )
                        )
                        .padding(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "$netSpeed",
                            fontFamily = changaOne,
                            fontSize = 32.sp,
                            color = Color.White,
                            lineHeight = 32.sp
                        )
                        Text(
                            text = "Mbps",
                            fontFamily = lato,
                            fontSize = 13.sp,
                            color = Color.White.copy(alpha = 0.85f),
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                }

                // ── نوع پکیج (مثل Welcome در profile)
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = packageType,
                        fontFamily = changaOne,
                        fontSize = 18.sp,
                        color = Color(0xFF111827)
                    )
                    Text(
                        text = "Internet Package",
                        fontFamily = lato,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }

                // ── جزئیات (مثل HorizontalDivider + info در profile)
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    PackageDetailRow(
                        icon = Icons.Outlined.SignalCellularAlt,
                        title = "Data",
                        value = if (dataAmount == "Unlimited") {
                            dataAmount
                        } else {
                            "$dataAmount GB"
                        },
                        lato = lato
                    )
                    PackageDetailRow(
                        icon = Icons.Outlined.CalendarMonth,
                        title = "Duration",
                        value = "$duration Days",
                        lato = lato
                    )
                }
                // ── قیمت (مثل SendUsEmail button در profile — تاکیدی)
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = price,
                            fontFamily = changaOne,
                            fontSize = 28.sp,
                            color = Color(0xFF007AFF),
                            lineHeight = 28.sp
                        )
                        Text(
                            text = "AFG",
                            fontFamily = lato,
                            fontSize = 13.sp,
                            color = Color(0xFF007AFF).copy(alpha = 0.7f),
                            modifier = Modifier.padding(bottom = 3.dp)
                        )
                    }

                    // دکمه کوچک خرید
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(
                                color = Color(0xFF007AFF).copy(alpha = 0.1f),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ShoppingCart,
                            contentDescription = "خرید",
                            tint = Color(0xFF007AFF),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PackageDetailRow(
    icon: ImageVector,
    title: String,
    value: String,
    lato: FontFamily
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(14.dp)
            )
            Text(
                title,
                fontFamily = lato,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
        Text(
            value,
            fontFamily = lato,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            color = Color(0xFF111827)
        )
    }
}

@Composable
@Preview
private fun PackagePreview(){
    PremiumPackageCard(
        packageType = "UnLimited",
        netSpeed = 5,
        duration = 90,
        price = "4500",
        dataAmount = "Unlimited"
    )
}