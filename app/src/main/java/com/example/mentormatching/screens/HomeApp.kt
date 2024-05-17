package com.example.mentormatching.screens


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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentormatching.R

@Composable
fun HomeApp(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.BottomCenter
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.mentee),
                contentDescription = "User Profile Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(430.dp),
                contentScale = ContentScale.Crop
            )
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.
                offset(285.dp, -50.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.circuloverde),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.certo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(55.dp)
                        .offset(-2.dp, -80.dp)

                )
            }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.
                offset(15.dp, -200.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.circulovermelho),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.x),
                    contentDescription = null,
                    modifier = Modifier
                        .size(45.dp)
                        .offset(0.dp, -77.dp)

                )
            }

        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .background(color = Color.White)
                .align(Alignment.BottomStart)
                .fillMaxWidth()

        ) {
            Text(
                "Description",
                color = Color.LightGray,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .background(color = Color.White)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                "Description",
                color = Color.LightGray,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeApp() {
    HomeApp(navController = NavController(LocalContext.current))
}