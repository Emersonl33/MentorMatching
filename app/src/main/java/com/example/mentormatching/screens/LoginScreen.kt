package com.example.mentormatching.screens


import MyFirebaseMessagingService
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mentormatching.R
import com.example.mentormatching.model.DataViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import java.util.Locale

@Composable
fun LoginScreen(navController: NavController, dataViewModel: DataViewModel = viewModel()) {
    val context = LocalContext.current
    val currentContext = rememberUpdatedState(newValue = context)
    val getData = dataViewModel.state.value
    val auth = Firebase.auth //instância de autenticação Firebase
    var loginError by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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

            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(width = 200.dp, height = 100.dp),
                alignment = Alignment.Center
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
                value = email,
                onValueChange = { email = it },
                label = { Text(stringResource(id = R.string.email)) },
                placeholder = { Text(text = stringResource(id = R.string.email)) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.person_24),
                        contentDescription = "Login Icon"
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
                value = password,
                onValueChange = { password = it },
                label = { Text(stringResource(id = R.string.password)) },
                placeholder = { Text(text = stringResource(id = R.string.password)) },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.baseline_admin_panel_settings_24),
                        contentDescription = "Password Icon"
                    )
                },
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(40.dp))

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
                onClick = {
                    if (email.isBlank() || password.isBlank()) {
                        loginError = true
                    } else {
                        auth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    navController.navigate("homeScreen") {
                                        popUpTo("loginScreen") { inclusive = true }
                                    }
                                    // Utilize o contexto lembrado atualizado para garantir que está usando um contexto válido
                                    val safeContext = currentContext.value
                                    Log.d("LoginScreen", "Sending login notification...")
                                    NotificationHelper.sendLoginNotification(safeContext)
                                } else {
                                    loginError = true
                                }
                            }
                    }
                },
            )

            {
                Text(
                    text = stringResource(id = R.string.loginButton),
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
            if (loginError) {
                Text(
                    text = stringResource(id = R.string.loginError),
                    color = Color.Red
                )
            }

            Text(
                text = stringResource(id = R.string.signUp),
                color = Color(0xFFFFFFFF),
                fontSize = 15.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("registerScreen")
                    },
                textAlign = TextAlign.Center,
            )

        }
    }

}
