package com.example.mentormatching.screens.mentors


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentormatching.R


@Composable
fun Mentor4Screen(navController: NavController) {
    val context = LocalContext.current
    val currentContext = rememberUpdatedState(newValue = context)
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.BottomCenter
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.menteef2),
                contentDescription = "User Profile Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(430.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = "Alana, Mentor",
                fontSize = 28.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .offset(-60.dp, 70.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.offset(285.dp, -50.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.circuloverde),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.certo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(55.dp)
                        .offset(-2.dp, -80.dp)
                        .clickable {
                            navController.navigate("matchScreen")

                            //Botão de like que envia uma notificação ao usuário através de uma API
                            //Se os likes corresponderem, o match acontece
                            val safeContext = currentContext.value
                            NotificationMatch.sendMatchNotification(safeContext)
                        }
                )
            }
            Column(

            ){ Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp)
            ) {
                Text(text = stringResource(id = R.string.location)+ ": ", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "São Paulo", color = Color.White, fontSize = 20.sp)
                Spacer(modifier = Modifier.weight(1f))
            }
                Spacer(modifier = Modifier.height(8.dp))

                Row (
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp)
                ) {
                    Text(text = stringResource(id = R.string.education)+ ": ", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = R.string.graduation), color = Color.White, fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))

                Row (
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp)
                ) {
                    Text(text = stringResource(id = R.string.interestArea)+ ": ", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = R.string.literature), color = Color.White, fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))

                Row (
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp)
                ) {
                    Text(text = stringResource(id = R.string.atuationArea)+ ": ", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = R.string.philosophy), color = Color.White, fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))

                Row (
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp)
                ) {
                    Text(text = stringResource(id = R.string.atuationType)+ ": ", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = stringResource(id = R.string.corporate), color = Color.White, fontSize = 20.sp)
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
}

@Preview(showBackground = true)
@Composable
fun PreviewMentor4Screen() {
    Mentor4Screen(navController = NavController(LocalContext.current))
}