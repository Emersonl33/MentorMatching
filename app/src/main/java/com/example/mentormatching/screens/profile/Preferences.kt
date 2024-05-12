package com.example.mentormatching.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PreferencesForm() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "PREFERENCES",
            color = Color.White,
        )
        Spacer(modifier = Modifier.height(24.dp))
        // Formulário

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { /* Handle save action */ },
        ) {
            Text("Save", color = Color.White)
        }
    }
}

@Composable
fun PreferenceTextField(label: String, icon: ImageVector) {
    var text = remember { TextFieldValue("") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Icon(icon, contentDescription = label, tint = Color.Cyan)
        Spacer(modifier = Modifier.width(16.dp))
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(label, color = Color.Gray) },
            singleLine = true,
            )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPreferencesForm() {
    PreferencesForm()
}
