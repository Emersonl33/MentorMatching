package com.example.mentormatching.screens


import android.util.Log
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mentormatching.R
import com.example.mentormatching.components.ExpandablePreferenceCardSingle
import com.example.mentormatching.model.DataViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun ProfileScreen(navController: NavController, dataViewModel: DataViewModel = viewModel()) {
    val getData = dataViewModel.state.value
    var username = remember { mutableStateOf("") }
    var age = remember { mutableStateOf("") }
    var mentor by remember { mutableStateOf("") }
    var locations by remember { mutableStateOf("") }
    var educationLevels by remember { mutableStateOf("") }
    var interestAreas by remember { mutableStateOf("") }
    var atuationType by remember { mutableStateOf("") }
    var atuationArea by remember { mutableStateOf("") }


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

            Spacer(modifier = Modifier.height(16.dp))
            Row() {
                Text(
                    text = stringResource(id = R.string.welcome) + " " + getData.username,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 20.sp,
                    color = Color.White,
                )
                IconButton(
                    onClick = {
                        navController.navigate("homeScreen")
                    }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        tint = Color.White,
                        contentDescription = ""
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.personal),
                modifier = Modifier.fillMaxWidth(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )

            Text(
                text = stringResource(id = R.string.fullName),
                modifier = Modifier.fillMaxWidth(),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )

            TextField(
                value = username.value,
                onValueChange = { username.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = stringResource(id = R.string.typeFullName), fontSize = 14.sp)
                },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Text(
                text = stringResource(id = R.string.age),
                modifier = Modifier.fillMaxWidth(),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )

            TextField(
                value = age.value,
                onValueChange = { age.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = stringResource(id = R.string.typeAge), fontSize = 14.sp)
                },
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.mentoringPreferences),
                modifier = Modifier.fillMaxWidth(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
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

            Spacer(modifier = Modifier.height(30.dp))

            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    saveUserProfileData(
                        username = username,
                        age = age,
                        locations = locations,
                        educationLevels = educationLevels,
                        interestAreas = interestAreas,
                        mentor = mentor,
                        atuationType = atuationType,
                        atuationArea = atuationArea
                    )
                    navController.navigate("homeScreen")
                },
            ) {
                Text(
                    text = stringResource(id = R.string.saveButton), fontSize = 20.sp, color = Color.White
                )
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

fun saveUserProfileData(
    username: MutableState<String>,
    age: MutableState<String>,
    mentor: String,
    locations: String,
    educationLevels: String,
    interestAreas: String,
    atuationType: String,
    atuationArea: String
) {
    val db = FirebaseFirestore.getInstance()
    val currentUser = FirebaseAuth.getInstance().currentUser

    currentUser?.let { user ->
        val userData = mapOf(
            "username" to username.value,
            "age" to age.value,
            "locations" to locations,
            "educationLevels" to educationLevels,
            "interestAreas" to interestAreas,
            "mentor" to mentor,
            "atuationType" to atuationType,
            "AtuationArea" to atuationArea,
        )
        db.collection("users").document(user.uid).set(userData).addOnSuccessListener {
            Log.d("ProfileScreen", "Data saved successfully")
        }.addOnFailureListener { e ->
            Log.w("ProfileScreen", "Error saving data", e)
        }
    }
}

