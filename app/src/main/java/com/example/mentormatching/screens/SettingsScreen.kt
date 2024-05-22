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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentormatching.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SettingsScreen(navController: NavController) {
    val auth = FirebaseAuth.getInstance()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF000000))
            .padding(32.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.height(300.dp))

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate("homeScreen")
                },
                colors = ButtonDefaults.buttonColors(Color.Black),
            ) {
                Text(
                    text = "Home Page",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    auth.signOut()
                    navController.navigate("loginScreen")
                },
                colors = ButtonDefaults.buttonColors(Color.Black),
            ) {
                Text(
                    text = "Log Out",
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
