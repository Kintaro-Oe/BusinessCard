package com.kintaro.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kintaro.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding()
            ) {
                BusinessCardTheme {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background_soft)),
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        HeaderCard(
            painter = painterResource(R.drawable.android_logo),
            fullName = "Marcus Montrei",
            title = stringResource(R.string.title)
        )
        ContactInfoCard(
            phoneNumber = "+44(0)1234 567 890",
            socialMediaHandle = "@socialMedia",
            emailAddress = "email@domain.com"
        )
    }
}

@Composable
fun HeaderCard(painter: Painter, fullName: String, title:String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val brush = Brush.verticalGradient(
            listOf(Color(0xFF082b2b),colorResource(R.color.background_soft)),
            startY =100f
        )
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
//                .clip(CircleShape)
                .clip(RoundedCornerShape(24.dp))
                .background(brush)
                .padding(12.dp)
        )
        Text(
            text = fullName,
            modifier = Modifier.padding(vertical = 8.dp),
            fontSize = 38.sp,
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1c9753)
        )
    }
}

@Composable
fun ContactInfoCard(phoneNumber: String, socialMediaHandle: String, emailAddress: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val appIconTheme = Icons.Filled

        ContactRow(
            contactIcon = appIconTheme.Call,
            contactIconDescription = stringResource(R.string.call_icon),
            contactText = phoneNumber
        )
        ContactRow(
            contactIcon = appIconTheme.Share,
            contactIconDescription = stringResource(R.string.share_icon),
            contactText = socialMediaHandle,
            Modifier.padding(vertical = 12.dp)
        )
        ContactRow(
            contactIcon = appIconTheme.MailOutline,
            contactIconDescription = stringResource(R.string.email_icon),
            contactText = emailAddress
        )
    }
}

@Composable
fun ContactRow(
    contactIcon: ImageVector,
    contactIconDescription: String,
    contactText: String,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        Spacer(Modifier.weight(1f))
        Icon(
            contactIcon,
            contactIconDescription,
            modifier = Modifier.padding(end = 8.dp),
            tint = colorResource(R.color.icon_green)
        )
        Text(
            text = contactText,
            Modifier.weight(3f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}