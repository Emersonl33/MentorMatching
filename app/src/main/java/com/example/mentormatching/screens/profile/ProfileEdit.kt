package com.example.mentormatching.screens.profile

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore


@Composable
fun UserProfileScreen(navController: NavController) {
    val db = Firebase.firestore
    val description by remember { mutableStateOf("") }
    val fullname by remember { mutableStateOf("") }
    var selectedLocation = remember { mutableStateOf("") }
    var selectedEducationLevel = remember { mutableStateOf("") }
    var selectedInterest = remember { mutableStateOf("") }
    var selectedMentorStatus = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .background(color = Color.Black)
                    .fillMaxWidth()
                    .height(50.dp)
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
                Spacer(modifier = Modifier.height(84.dp))
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset(x = 0.dp, y = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Edit your profile",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.picture),
                contentDescription = "Profile Icon",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Load a picture",
                color = Color.Gray,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                label = { Text("Name") },
                value = fullname,
                onValueChange = { })
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                label = { Text("Description") },
                value = description,
                onValueChange = { })
            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn(

                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                item {
                    ExpandablePreferenceCard(
                        title = "Localização",
                        options = listOf(
                            "Rio Grande do Sul",
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
                        )
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
                            "Arte"
                        )
                    )
                }
                item {
                    ExpandablePreferenceCard(
                        title = "Mentor ou Mentorado",
                        options = listOf("Mentor", "Mentorado")
                    )
                }
            }
        }

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()

        ) {
            Button(onClick = {
                saveEditProfileFirestore(
                    fullname,
                    description,
                    selectedLocation.value,
                    selectedEducationLevel.value,
                    selectedInterest.value,
                    selectedMentorStatus.value
                )
            })
            {
                Text("SAVE")

            }
        }
    }
}

fun saveEditProfileFirestore(
    fullname: String,
    description: String,
    location: String,
    educationLevel: String,
    interest: String,
    mentorStatus: String
) {
    val db = Firebase.firestore
    val currentUser = FirebaseAuth.getInstance().currentUser
    currentUser?.let { user ->
        val profileData = hashMapOf(
            "fullname" to fullname,
            "description" to description,
            "location" to location,
            "educationLevel" to educationLevel,
            "interest" to interest,
            "mentorStatus" to mentorStatus
        )
        db.collection("profiles").document(user.uid)
            .set(profileData)
            .addOnSuccessListener {
                Log.d("Firebase", "Edit has been saved")
            }
            .addOnFailureListener { e ->
                Log.w("Firebase", "Error adding document", e)
            }
    }
}

@Composable
fun ExpandablePreferenceCard(
    title: String,
    options: List<String>,
    backgroundColor: Color = Color.Transparent
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }

    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Card(
            modifier = Modifier
                .width(300.dp)
                .height(90.dp)
                .padding(12.dp)
                .background(color = Color.Transparent),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(color = Color.Transparent),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    title,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.ArrowDropDown,
                        contentDescription = "Expand or collapse"
                    )
                }
            }
            if (expanded) {
                Column() {
                    options.forEach { option ->
                        TextButton(
                            onClick = {
                                selectedOption = option
                                expanded = false
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp)
                        ) {
                            Text(option, color = Color.Black)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewUserProfileScreen() {
    val navController = rememberNavController()
    UserProfileScreen(navController = navController)
}
