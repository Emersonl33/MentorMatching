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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentormatching.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun RegisterScreen(navController: NavController) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }



    Box() {

        Image(
            painter = painterResource(id = R.drawable.backgroundmain),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = R.drawable.signup),
                contentDescription = null,
                modifier = Modifier.size(width = 200.dp, height = 100.dp),
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(stringResource(id = R.string.typeEmail)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(stringResource(id = R.string.password)) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text(stringResource(id = R.string.confirmpassword)) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
                onClick = {
                    if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                        status = "Please, complete all fields"
                    } else if (password != confirmPassword) {
                        status = "Passwords don't match"
                    } else {
                        registerAndLogin(email, password, context , {
                            navController.navigate("homeScreen")
                        }, { errorMsg ->
                            status = errorMsg
                        })
                    }
                }) {
                Text(
                    stringResource(id = R.string.register),
                    fontSize = 16.sp,
                    color = Color.White,
                )
            }

            if (status.isNotEmpty()) {
                Text(status, color = Color.Red)
            }

            Text(
                text = stringResource(id = R.string.already),
                color = Color(0xFFFFFFFF),
                fontSize = 15.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("loginScreen")
                    },
                textAlign = TextAlign.Center,
            )


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
                    navController.navigate("loginScreen")
                }
        )
    }
}
fun registerAndLogin(
    email: String,
    password: String,
    context: android.content.Context,
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
