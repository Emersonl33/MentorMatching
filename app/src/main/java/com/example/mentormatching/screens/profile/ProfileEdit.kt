package com.example.mentormatching.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mentormatching.R

@Composable
fun UserProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        ProfileImage()
        ProfileInfo()
        ProfileAttributes()
        ProfileDescription()
    }
}

@Composable
fun ProfileImage() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.mentee),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(80.dp)
                .background(Color.LightGray, CircleShape)
        )
    }
}

@Composable
fun ProfileInfo() {
    Text(
        "Mentor, User",
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontSize = 18.sp,
        modifier = Modifier.padding(8.dp)
    )
    Text(
        "View profile Preferences",
        color = Color.Gray,
        fontSize = 14.sp,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun ProfileAttributes() {

}

@Composable
fun AttributeItem(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Icon (icon, contentDescription = text, tint = Color.Cyan)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text, color = Color.White, fontSize = 14.sp)
    }
}

@Composable
fun ProfileDescription() {
    Text(
        "Description:",
        color = Color.White,
        fontSize = 14.sp,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
    // This could be replaced with a TextField if needed
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 16.dp)
            .background(Color.White)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewUserProfileScreen() {
    UserProfileScreen()
}
