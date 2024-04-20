package com.example.mentormatching.screens

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mentormatching.R
import com.example.mentormatching.R.drawable.signup

@Composable
    fun SignUpScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.backgroundmain),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.BottomCenter
        )

        //Menu superior
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .background(color = Color.Black)
                .fillMaxWidth()
                .height(60.dp)
            )
            {
                Image(painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Main",
                    modifier = Modifier
                        .size(110.dp)
                        .clickable {
                        navController.navigate("login")
                    }
                )
            }

            // logo
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()

            ) {
                Image(
                    painter = painterResource(id = signup),
                    contentDescription = null,
                    modifier = Modifier.size(320.dp)
                )
            }


        //Formulário
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
        )
        {

            TextField(
                modifier = Modifier
                    .width(250.dp)
                    .height(35.dp),

                value = " ", //Usado para Mostrar o texto dentro da cx
                onValueChange = { }, // Assim que o valor muda a ação é disparada
                label = {
                    Text(text = ("Type your email"))
                },
                placeholder = {
                    Text(text = "Login")
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.person_24),
                        contentDescription = "Ícone de login"
                    ) //necessário para configurações de acessibilidade
                }

            )
            Spacer(modifier = Modifier.height(25.dp))

            TextField(
                modifier = Modifier
                    .width(250.dp)
                    .height(35.dp),
                value = " ",
                onValueChange = { },
                label = {
                    Text(text = ("Type your password"))
                },
                placeholder = {
                    Text(text = "Password")
                },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.baseline_admin_panel_settings_24),
                        contentDescription = "Ícone de password"
                    )
                }

            )
            Spacer(modifier = Modifier.height(25.dp))

            TextField(
                modifier = Modifier
                    .width(250.dp)
                    .height(35.dp),
                value = " ",
                onValueChange = { },
                label = {
                    Text(text = ("Type your password"))
                },
                placeholder = {
                    Text(text = "Password")
                },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.baseline_admin_panel_settings_24),
                        contentDescription = "Ícone de password"
                    )
                }

            )
            Spacer(modifier = Modifier.height(25.dp))

            TextField(
                modifier = Modifier
                    .width(250.dp)
                    .height(35.dp),
                value = " ",
                onValueChange = { },
                label = {
                    Text(text = ("Type your password"))
                },
                placeholder = {
                    Text(text = "Password")
                },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.baseline_admin_panel_settings_24),
                        contentDescription = "Ícone de password"
                    )
                }

            )
            Spacer(modifier = Modifier.height(25.dp))

            TextField(
                modifier = Modifier
                    .width(250.dp)
                    .height(35.dp),
                value = " ",
                onValueChange = { },
                label = {
                    Text(text = ("Type your password"))
                },
                placeholder = {
                    Text(text = "Password")
                },
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.baseline_admin_panel_settings_24),
                        contentDescription = "Ícone de password"
                    )
                }
            )
        }
        //BTNS

    }
}