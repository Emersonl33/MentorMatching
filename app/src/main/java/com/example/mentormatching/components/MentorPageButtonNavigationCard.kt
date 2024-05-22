package com.example.mentormatching.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentormatching.R
import com.example.mentormatching.model.MentorPageButtonNavigation

@Composable
fun MentorPageButtonNavigationCard(
    mentorPageButtonNavigation: MentorPageButtonNavigation,
    navController: NavController)
{
    Card(
        modifier = Modifier
            .size(110.dp)
            .padding(4.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
       IconButton(onClick = {
                navController.navigate(mentorPageButtonNavigation.routeNavigation)
            }) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = ""
                )
            }
            Text(
                text = mentorPageButtonNavigation.buttonNavigationName,
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
            )
        }
    }
}