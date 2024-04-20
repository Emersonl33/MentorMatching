package com.example.mentormatching
import HomePageScreen
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
import com.example.mentormatching.screens.SignUpScreen
import com.example.mentormatching.ui.theme.MentorMatchingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                        composable(route = "login") {
                            HomePageScreen(navController)
                        }
                        composable(route = "signUp") {
                            SignUpScreen(navController)
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
                HomePageScreen(navController = rememberNavController())
            }
        }
