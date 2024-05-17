package com.example.mentormatching


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mentormatching.screens.HomeApp
import com.example.mentormatching.screens.login.LoginScreen
import com.example.mentormatching.screens.profile.PreferencesScreen
import com.example.mentormatching.screens.signup.CompletePerfil
import com.example.mentormatching.screens.signup.RegisterScreen
import com.example.mentormatching.ui.theme.MentorMatchingTheme
import com.google.firebase.FirebaseApp

private const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        setContent {
            MentorMatchingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable(route = "home") {
                            HomeApp(navController)
                        }
                        composable(route = "login") {
                            LoginScreen(navController)
                        }
                        composable(route = "register") {
                            RegisterScreen(navController)
                        }
                        composable(route = "complete") {
                            CompletePerfil(navController)
                        }
                        composable(route = "preferences") {
                            PreferencesScreen(navController)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MentorMatchingTheme {
        LoginScreen(navController = rememberNavController())
    }
}
