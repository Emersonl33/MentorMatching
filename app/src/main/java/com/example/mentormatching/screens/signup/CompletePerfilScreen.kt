package com.example.mentormatching.screens.signup

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mentormatching.R
import com.example.mentormatching.screens.profile.ExpandablePreferenceCard
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore


val selectedLocation = mutableStateOf("")
val selectedEducationLevel = mutableStateOf("")
val selectedInterest = mutableStateOf("")
val selectedMentorStatus = mutableStateOf("")
@Composable
    fun CompletePerfil(navController: NavController) {

    Box(
        modifier = Modifier.
            fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.
            fillMaxWidth().
            offset(0.dp, 200.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = "Complete seu perfil",
                color = Color.White,
                fontSize = 30.sp,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .offset(0.dp, 280.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

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

            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { saveProfileToFirestore(
                selectedLocation.value,
                selectedEducationLevel.value,
                selectedInterest.value,
                selectedMentorStatus.value
            ) })
            {
                Text("Salvar")
            }
        }
    }
    @Composable
    fun ExpandablePreferenceCard(title: String, options: List<String>) {
        var expanded by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf(" ") }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
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
                    Column {
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
}
fun saveProfileToFirestore(
    location: String,
    educationLevel: String,
    interest: String,
    mentorStatus: String
) {
    val db = Firebase.firestore
    val currentUser = FirebaseAuth.getInstance().currentUser
    currentUser?.let { user ->
        val profileData = hashMapOf(
            "location" to location,
            "educationLevel" to educationLevel,
            "interest" to interest,
            "mentorStatus" to mentorStatus
        )
        db.collection("profiles").document(user.uid)
            .set(profileData)
            .addOnSuccessListener {
                // Salvo com sucesso
            }
            .addOnFailureListener {
                // Falha ao salvar
            }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewCompletePerfil() {
    val navController = rememberNavController()
    CompletePerfil(navController = navController)
}