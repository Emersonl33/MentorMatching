package com.example.mentormatching.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentormatching.R

@Composable
fun MessageScreen(navController: NavController) {
    Box() {

        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
        ) {

            Text(
                text = stringResource(id = R.string.messages),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.comingSoon),
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )


            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate("homeScreen")
                },
            ) {
                Text(
                    text = stringResource(id = R.string.homePage),
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }

    }

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(color = Color.Transparent)
            .height(100.dp)
            .width(150.dp)
    ) {
        Image( // Botão para voltar para a tela de login
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Main Logo",
            modifier = Modifier
                .size(110.dp)
                .clickable {
                    navController.navigate("homeScreen")
                }
        )
    }
}