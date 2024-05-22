package com.example.mentormatching.screens

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mentormatching.R
import com.example.mentormatching.components.ExpandablePreferenceCardSingle
import com.example.mentormatching.components.MentorCard
import com.example.mentormatching.components.MentorPageButtonNavigationCard
import com.example.mentormatching.database.repository.getMentorByMatch
import com.example.mentormatching.database.repository.getMentorsByMentorEducation
import com.example.mentormatching.model.DataViewModel

@Composable
fun FindMentorScreen(navController: NavController, dataViewModel: DataViewModel = viewModel()) {
    val getData = dataViewModel.state.value
    var mentor by remember { mutableStateOf("") }
    var locations by remember { mutableStateOf("") }
    var educationLevels by remember { mutableStateOf("") }
    var interestAreas by remember { mutableStateOf("") }
    var atuationType by remember { mutableStateOf("") }
    var atuationArea by remember { mutableStateOf("") }
    var mentorEducationState by remember { mutableStateOf("") }
    var listMentorsByMentorEducation by remember {
        mutableStateOf(getMentorsByMentorEducation(mentorEducationState))
    }
    Box() {

        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
        ) {

            Spacer(modifier = Modifier.height(60.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Black)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Hey, " + getData.username + "!",
                        fontSize = 20.sp,
                        //modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(text = stringResource(id = R.string.possibleMatches), fontSize = 20.sp, color = Color.White)
            LazyRow() {
                items(getMentorByMatch()) {

                    MentorPageButtonNavigationCard(mentorPageButtonNavigation = it, navController)
                }
            }
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.advancedSearch),
                fontSize = 14.sp,
                color = Color.White
            )

            LazyColumn {
                item {
                    ExpandablePreferenceCardSingle(
                        title = stringResource(id = R.string.location),
                        options = listOf(
                            "Acre",
                            "Alagoas",
                            "Amapá",
                            "Amazonas",
                            "Bahia",
                            "Ceará",
                            "Espírito Santo",
                            "Goiás",
                            "Maranhão",
                            "Mato Grosso do Sul",
                            "Mato Grosso",
                            "Minas Gerais",
                            "Pará",
                            "Paraná",
                            "Pernambuco",
                            "Piauí",
                            "Rio de Janeiro",
                            "Rio Grande do Norte",
                            "Rio Grande do sul",
                            "Rondônia",
                            "Roraima",
                            "Santa Catarina",
                            "São Paulo",
                            "Sergipe",
                            "Tocantins"
                        ),
                        selectedOption = locations,
                        onOptionSelected = { locations = it }
                    )
                }
                item {
                    ExpandablePreferenceCardSingle(
                        title = stringResource(id = R.string.educationLevel),
                        options = listOf(
                            stringResource(id = R.string.highSchool),
                            stringResource(id = R.string.graduation),
                            stringResource(id = R.string.specialization),
                            stringResource(id = R.string.masterDegree),
                            stringResource(id = R.string.doctorateDegree)
                        ),
                        selectedOption = educationLevels,
                        onOptionSelected = { educationLevels = it }
                    )
                }
                item {
                    ExpandablePreferenceCardSingle(
                        title = stringResource(id = R.string.interestArea),
                        options = listOf(
                            stringResource(id = R.string.administration),
                            stringResource(id = R.string.art),
                            stringResource(id = R.string.astronomy),
                            stringResource(id = R.string.biology),
                            stringResource(id = R.string.computing),
                            stringResource(id = R.string.economy),
                            stringResource(id = R.string.education),
                            stringResource(id = R.string.civilEngineering),
                            stringResource(id = R.string.electricalEngineering),
                            stringResource(id = R.string.mechanicalEngineering),
                            stringResource(id = R.string.philosophy),
                            stringResource(id = R.string.physical),
                            stringResource(id = R.string.languages),
                            stringResource(id = R.string.literature),
                            stringResource(id = R.string.mathematics),
                            stringResource(id = R.string.medicine),
                            stringResource(id = R.string.nutrition),
                            stringResource(id = R.string.psychology),
                            stringResource(id = R.string.chemical),
                            stringResource(id = R.string.sociology),
                        ),
                        selectedOption = interestAreas,
                        onOptionSelected = { interestAreas = it }
                    )
                }
                item {
                    ExpandablePreferenceCardSingle(
                        title = stringResource(id = R.string.atuationArea),
                        options = listOf(
                            stringResource(id = R.string.administration),
                            stringResource(id = R.string.art),
                            stringResource(id = R.string.astronomy),
                            stringResource(id = R.string.biology),
                            stringResource(id = R.string.computing),
                            stringResource(id = R.string.economy),
                            stringResource(id = R.string.education),
                            stringResource(id = R.string.civilEngineering),
                            stringResource(id = R.string.electricalEngineering),
                            stringResource(id = R.string.mechanicalEngineering),
                            stringResource(id = R.string.philosophy),
                            stringResource(id = R.string.physical),
                            stringResource(id = R.string.languages),
                            stringResource(id = R.string.literature),
                            stringResource(id = R.string.mathematics),
                            stringResource(id = R.string.medicine),
                            stringResource(id = R.string.nutrition),
                            stringResource(id = R.string.psychology),
                            stringResource(id = R.string.chemical),
                            stringResource(id = R.string.sociology)
                        ),
                        selectedOption = atuationArea,
                        onOptionSelected = { atuationArea = it }
                    )
                }
                item {
                    ExpandablePreferenceCardSingle(
                        title = stringResource(id = R.string.atuationType),
                        options = listOf(
                            stringResource(id = R.string.academic),
                            stringResource(id = R.string.corporate),
                            stringResource(id = R.string.entrepreneur)
                        ),
                        selectedOption = atuationType,
                        onOptionSelected = { atuationType = it }
                    )
                }
                item {
                    ExpandablePreferenceCardSingle(
                        title = stringResource(id = R.string.userType),
                        options = listOf(
                            stringResource(id = R.string.mentor),
                            stringResource(id = R.string.mentee)
                        ),
                        selectedOption = mentor,
                        onOptionSelected = { mentor = it }
                    )
                }
            }

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { // BOTÃO PARA REALIZAR BUSCA DE MENTORES
                    },

            ) {
                Text(
                    text = "SEARCH",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(4.dp))


            LazyColumn() {
                items(listMentorsByMentorEducation) {
                    MentorCard(mentor = it)
                }
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

