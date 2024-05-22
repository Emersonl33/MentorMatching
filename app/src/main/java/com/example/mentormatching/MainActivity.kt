package com.example.mentormatching

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mentormatching.screens.FindMentorScreen
import com.example.mentormatching.screens.HomePageScreen
import com.example.mentormatching.screens.LoginScreen
import com.example.mentormatching.screens.MatchScreen
import com.example.mentormatching.screens.MessageScreen
import com.example.mentormatching.screens.ProfileScreen
import com.example.mentormatching.screens.RegisterScreen
import com.example.mentormatching.screens.SettingsScreen
import com.example.mentormatching.screens.mentors.Mentor1Screen
import com.example.mentormatching.screens.mentors.Mentor2Screen
import com.example.mentormatching.screens.mentors.Mentor3Screen
import com.example.mentormatching.screens.mentors.Mentor4Screen
import com.example.mentormatching.ui.theme.MentorMatchingTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MentorMatchingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "loginScreen",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.End,
                                tween(2000)
                            ) + fadeOut(animationSpec = tween(2000))

                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Down,
                                animationSpec = tween(2000)
                            )
                        }
                    ) {
                        composable(route = "loginScreen") {
                            LoginScreen(navController)
                        }

                        composable(route = "homeScreen") {
                            HomePageScreen(navController)
                        }

                        composable(route = "profileScreen") {
                            ProfileScreen(navController)
                        }

                        composable(route = "findMentorScreen") {
                            FindMentorScreen(navController)
                        }

                        composable(route = "messagesScreen") {
                            MessageScreen(navController)
                        }

                        composable(route = "settingsScreen") {
                            SettingsScreen(navController)
                        }

                        composable(route = "registerScreen") {
                            RegisterScreen(navController)
                        }

                        composable(route = "Mentor1Screen") {
                            Mentor1Screen(navController)
                        }

                        composable(route = "Mentor2Screen") {
                           Mentor2Screen(navController)
                        }

                        composable(route = "Mentor3Screen") {
                            Mentor3Screen(navController)
                        }

                        composable(route = "Mentor4Screen") {
                            Mentor4Screen(navController)
                        }

                        composable(route = "matchScreen") {
                            MatchScreen(navController)
                        }

                    }
                }

            }
        }
    }
}







