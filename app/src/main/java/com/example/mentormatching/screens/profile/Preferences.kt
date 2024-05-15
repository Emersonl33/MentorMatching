package com.example.mentormatching.screens.profile

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.mentormatching.R

@Composable
fun PreferencesScreen(navController: NavController) {
    Box(

    ) {
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = "User Profile Image",
            modifier = Modifier
                .fillMaxSize()
                .height(430.dp),
            contentScale = ContentScale.Crop
        )
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .offset(0.dp, -200.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Defina suas preferências de busca",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .offset(0.dp, 220.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Defina preferências para sua busca",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {
                item {
                    ExpandablePreferenceCard(
                        title = "Localização",
                        options = listOf(
                            "Rio Grande do sul",
                            "Paraná",
                            "Santa Catarina",
                            "São Paulo",
                            "Rio de Janeiro",
                            "Minas Gerais",
                            "Espírito Santo",
                            "Mato Grosso",
                            "Mato Grosso do Sul",
                            "Goiás",
                            "Tocantins",
                            "Pará",
                            "Amazonas",
                            "Acre",
                            "Rondônia",
                            "Roraima",
                            "Amapá",
                            "Maranhão",
                            "Alagoas",
                            "Pernambuco",
                            "Rio Grande do Norte",
                            "Piauí",
                            "Ceará",
                            "Bahia",
                            "Sergipe"
                        ),
                    )
                }
                item {
                    ExpandablePreferenceCard(
                        title = "Nível de Escolaridade",
                        options = listOf(
                            "Ensino Médio",
                            "Graduação",
                            "Especialização",
                            "Mestrado",
                            "Doutorado"
                        )
                    )
                }
                item {
                    ExpandablePreferenceCard(
                        title = "Áreas de Interesse",
                        options = listOf(
                            "Computação",
                            "Física",
                            "Astronomia",
                            "Matemática",
                            "Biologia",
                            "Química",
                            "Engenharia Civil",
                            "Engenharia Elétrica",
                            "Engenharia Mecânica",
                            "Administração",
                            "Economia",
                            "Educação",
                            "Psicologia",
                            "Medicina",
                            "Nutrição",
                            "Sociologia",
                            "Filosofia",
                            "Idiomas",
                            "Literarura",
                            "Arte")
                    )
                }
                item {
                    ExpandablePreferenceCard(
                        title = "Mentor ou Mentorado",
                        options = listOf("Mentor", "Mentorado")
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { /* Implementar ação para salvar preferências ou iniciar busca */ }) {
                Text("Salvar Preferências")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewPreferencesForm() {
    val navController = rememberNavController()
    PreferencesScreen(navController = navController)
}
