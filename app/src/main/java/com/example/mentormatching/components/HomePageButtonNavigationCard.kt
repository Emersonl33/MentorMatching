package br.com.fiap.mentormatching2.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mentormatching.model.HomePageButtonNavigation

@Composable
fun HomePageButtonNavigationCard(
    homePageButtonNavigation: HomePageButtonNavigation,
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
                navController.navigate(homePageButtonNavigation.routeNavigation)
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = ""
                )
            }
            Text(
                text = homePageButtonNavigation.buttonNavigationName,
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
            )
        }
    }
}