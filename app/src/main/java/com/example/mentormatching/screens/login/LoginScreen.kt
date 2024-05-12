
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentormatching.R


@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf(" ") }
    var password by remember { mutableStateOf(" ") }
    var isLoading by remember { mutableStateOf(false) }

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
        // logo
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                //.height(450.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(500.dp)
            )
        }

        // Formulário
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(1000.dp)
        )
        {
            if (isLoading) {
                LoadingAnimation()
            } else {
                TextField(
                    modifier = Modifier
                        .width(250.dp)
                        .height(35.dp),

                    value = email, //Usado para Mostrar o texto dentro da cx
                    onValueChange = { email = it }, // Assim que o valor muda a ação é disparada
                    label = {
                        Text(text = stringResource(id = R.string.email))
                    },
                    placeholder = {
                        Text(text = "Login")
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.person_24),
                            contentDescription = "Ícone de login"
                        ) //necessário para configurações de acessibilidade

                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

                )

                Spacer(modifier = Modifier.height(25.dp))

                TextField(
                    modifier = Modifier
                        .width(250.dp)
                        .height(35.dp),
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(text = stringResource(id = R.string.password))
                    },
                    placeholder = {
                        Text(text = "Password")
                    },
                    leadingIcon = {
                        Icon(
                            painterResource(id = R.drawable.baseline_admin_panel_settings_24),
                            contentDescription = "Ícone de password"
                        )
                    },
                    visualTransformation = PasswordVisualTransformation()

                )
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .height(680.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {

            Text(
                text = stringResource(id = R.string.signUp),
                color = Color(0x99FFFFFF),
                modifier = Modifier
                    .clickable {
                        navController.navigate("signUp")
                    }
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .height(600.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom

        ) {
            Button(
                onClick = { isLoading = true },
                shape = RoundedCornerShape(3.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF5E60D1)),

            )
            {
                Text(text = stringResource(id = R.string.login))
            }
        }
    }
}

@Composable
fun LoadingAnimation() {
    CircularProgressIndicator(
        color = Color.Red,
        modifier = Modifier.size(50.dp)
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text("Loading...", color = Color.White, fontSize = 16.sp)
}
