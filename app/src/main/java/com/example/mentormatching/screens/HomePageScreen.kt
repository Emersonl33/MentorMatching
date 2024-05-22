package com.example.mentormatching.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.fiap.mentormatching2.components.FeedbackCard
import br.com.fiap.mentormatching2.components.HomePageButtonNavigationCard
import com.example.mentormatching.R
import com.example.mentormatching.database.repository.getFeedbacksByMentor
import com.example.mentormatching.database.repository.getallHomePageButtonNavigation
import com.example.mentormatching.model.DataViewModel


@Composable
fun HomePageScreen(navController: NavController, dataViewModel: DataViewModel = viewModel()) {
    val getData = dataViewModel.state.value

    var mentorNameState by remember {
        mutableStateOf("")
    }

    var listFeedbackByMentor by remember {
        mutableStateOf(getFeedbacksByMentor(mentorNameState))
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

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.welcome) + " " + getData.username,
                    fontSize = 30.sp,
                    color = Color.White
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(18.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.age) + ": " + getData.age,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(18.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.location) + ": " + getData.locations,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(18.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.educationLevel) + ": " + getData.educationLevels,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(18.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.atuationArea) + ": " + getData.AtuationArea,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(18.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.atuationType) + ": " + getData.atuationType,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(18.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.interestArea) + ": " + getData.interestAreas,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            LazyRow() {
                items(getallHomePageButtonNavigation()) {
                    HomePageButtonNavigationCard(homePageButtonNavigation = it, navController)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.feedbackActivities),
                fontSize = 20.sp,
                color = Color.White
            )

            OutlinedTextField(
                value = mentorNameState,
                onValueChange = {
                    mentorNameState = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.mentorName))
                },
                trailingIcon = {
                    IconButton(onClick = {
                        listFeedbackByMentor = getFeedbacksByMentor(mentorNameState)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = ""
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn() {
                items(listFeedbackByMentor) {
                    FeedbackCard(feedback = it)
                }
            }
        }
    }
}

