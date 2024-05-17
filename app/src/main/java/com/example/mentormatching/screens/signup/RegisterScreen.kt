package com.example.mentormatching.screens.signup

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mentormatching.R
import com.google.firebase.auth.FirebaseAuth


@Composable
fun RegisterScreen(navController: NavController) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.backgroundmain),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Main Logo",
                modifier = Modifier
                    .size(110.dp)
                    .clickable {
                        navController.navigate("login")
                    }
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()

        ) {
            Image(
                painter = painterResource(id = R.drawable.signup),
                contentDescription = null,
                modifier = Modifier.size(320.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.width(250.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.width(250.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))

            TextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm your Password") },
                modifier = Modifier.width(250.dp)
            )
            Spacer(modifier = Modifier.height(35.dp))
            Button(onClick = {
                if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                    status = "Please fill in all fields"
                } else if (password != confirmPassword) {
                    status = "Passwords do not match"
                } else {
                    registerAndLogin(email, password, context, {
                        navController.navigate("main_screen_route")  // Assegure-se que esta rota está corretamente configurada
                    }, { errorMsg ->
                        status = errorMsg
                    })
                }
            }) {
                Text("Register")
            }

            if (status.isNotEmpty()) {
                Text(status, color = Color.Red)
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .align(Alignment.Center)
                .offset(x = 0.dp, y = 620.dp)

        ) {
            Text(
                text = "Already have an account?",
                color = Color(0x99FFFFFF),
                fontSize = 15.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
                modifier = Modifier
                    .clickable {
                        navController.navigate("login")
                    }
            )
        }
    }
}

fun registerAndLogin(
    email: String,
    password: String,
    context: Context,
    onSuccess: () -> Unit,
    onError: (String) -> Unit
) {
    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { registerTask ->
            if (registerTask.isSuccessful) {
                // Registro bem-sucedido, agora fazemos o login
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { loginTask ->
                        if (loginTask.isSuccessful) {
                            // Login bem-sucedido após o registro
                            onSuccess()
                        } else {
                            // Login falhou após o registro
                            onError("Login failed: ${loginTask.exception?.message}")
                        }
                    }
            } else {
                // Registro falhou
                onError("Registration failed: ${registerTask.exception?.message}")
            }
        }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    val navController = rememberNavController()
    RegisterScreen(navController = navController)
}