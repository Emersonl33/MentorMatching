package com.example.mentormatching

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mentormatching.ui.theme.MentorMatchingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MentorMatchingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    BasicsComponents()
                }

            }
        }

    }

}
    @Composable
    fun BasicsComponents() {
        Column(modifier = Modifier.padding(32.dp))
        {
            TextField(
                value = " ", //Usado para Mostrar o texto dentro da cx
                onValueChange = { }, // Assim que o valor muda a ação é disparada
                label = {
                    Text(text = ("Type your email"))
                },
                placeholder = {
                    Text(text = "Login")
                },
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.person_24),
                        contentDescription = "Ícone de login") //necessário para configurações de acessibilidade
                }

            )

            TextField(
                value = " ",
                onValueChange = { },
                label = {
                    Text(text = ("Type your password"))
                },
                placeholder = {
                    Text(text = "Password")
                },
                leadingIcon = {
                    Icon(painterResource(id = R.drawable.baseline_admin_panel_settings_24),
                        contentDescription = "Ícone de password")
                }

            )
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        MentorMatchingTheme {
            BasicsComponents()
        }
    }