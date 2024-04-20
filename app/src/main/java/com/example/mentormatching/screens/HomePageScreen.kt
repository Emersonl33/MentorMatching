
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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


@Composable
    fun HomePageScreen(navController: NavController) {
        val imagePainter = painterResource(R.drawable.backgroundmain1)
        Box(
            modifier = Modifier.fillMaxSize()

        ) {

            Image(
                painter = imagePainter,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.BottomCenter
            )

            Column(
            ) {

                // logo
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(450.dp)

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            // Formulário
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
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
            }
            //SignUp
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Click here to signUp!",
                    color = Color(0xFF0099FF),
                    modifier = Modifier.clickable {
                        navController.navigate("signUp")
                    }
                )
            }

        }
    }
