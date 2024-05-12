package com.example.mentormatching.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentormatching.R
import com.example.mentormatching.R.drawable.signup
import com.example.mentormatching.database.repository.PessoaRepository
import com.example.mentormatching.model.Pessoa

val sedanregular = FontFamily(
    Font(R.font.sedanregular)
)

@Composable
fun SignUpScreen(navController: NavController) {
    Form(navController)
}

@Composable
fun Form(navController: NavController) {


    var nameState = remember {
        mutableStateOf("")
    }
    var emailState = remember {
        mutableStateOf("")
    }
    var passwordState = remember {
        mutableStateOf("")
    }
    var switchState = remember {
        mutableStateOf("")
    }

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
        PessoaForm(
            name = nameState.value,
            email = emailState.value,
            password = passwordState.value,
            switch = switchState.value,

            onNameChange = {
                nameState.value = it
            },
            onEmailChange = {
                emailState.value = it
            },
            onPasswordChange = {
                passwordState.value = it
            },
            onSwitchChange = {
                switchState.value = it
            },
        )

        Row() {
            Text(
                text = "Already have an account?",
                color = Color(0x99FFFFFF),
                fontSize = 15.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
                modifier = Modifier
                    .offset(x = 120.dp, y = 640.dp)
                    .clickable {
                        navController.navigate("login")
                    }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PessoaForm(
    name: String,
    email: String,
    password: String,
    switch: String,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSwitchChange: (String) -> Unit,
) {
    //obj que faz a chamada para o banco de dados
    val context = LocalContext.current
    val pessoaRepository = PessoaRepository(context)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()


    ) {
        TextField(
            modifier = Modifier
                .width(250.dp)
                .height(40.dp),

            value = name, //Usado para Mostrar o texto dentro da cx
            onValueChange = { onNameChange(it) }, // Assim que o valor muda a ação é disparada
            label = {
                Text(text = stringResource(id = R.string.name))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            ),
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
                .height(40.dp),
            value = switch,
            onValueChange = { onSwitchChange(it) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            label = {
                Text(text = stringResource(id = R.string.OcupationArea))
            },

            placeholder = {
                Text(text = "Mentor/Mentee")
            },
            leadingIcon = {
                Icon(
                    painterResource(id = R.drawable.baseline_group_24),
                    contentDescription = "Ícone de password"
                )
            }

        )
        Spacer(modifier = Modifier.height(25.dp))

        TextField(
            modifier = Modifier
                .width(250.dp)
                .height(40.dp),
            value = email,
            onValueChange = { onEmailChange(it) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            label = {
                Text(text = stringResource(id = R.string.email))
            },
            placeholder = {
                Text(text = "Email")
            },
            leadingIcon = {
                Icon(
                    painterResource(id = R.drawable.baseline_local_post_office_24),
                    contentDescription = "Ícone de password"
                )
            }
        )
        Spacer(modifier = Modifier.height(25.dp))

        TextField(
            modifier = Modifier
                .width(250.dp)
                .height(35.dp),
            value = password,
            onValueChange = { onPasswordChange(it) },
            label = {
                Text(text = stringResource(id = R.string.password))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            placeholder = {
                Text(
                    text = "Password",
                    color = Color.White
                )
            },
            leadingIcon = {
                Icon(
                    painterResource(id = R.drawable.baseline_admin_panel_settings_24),
                    contentDescription = "Ícone de password"
                )
            }

        )
        Spacer(modifier = Modifier.height(25.dp))

        Row(
            //modifier = Modifier.background(color = Color.White)
        ) {
            Button(
                onClick = {
                    val pessoa =
                        Pessoa(
                            id = 0,
                            name = name,
                            email = email,
                            password = password,
                            switch = switch
                        )
                    pessoaRepository.salvar(pessoa)
                },
                shape = RoundedCornerShape(3.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF5E60D1)),
                modifier = Modifier.
                size(100.dp, 35.dp)
            ) {
                Text(text = stringResource(id = R.string.Register))
            }
        }
    }
}


