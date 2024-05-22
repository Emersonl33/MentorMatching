package com.example.mentormatching.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentormatching2.model.Mentor
import com.example.mentormatching.R

@Composable
fun MentorCard(mentor: Mentor) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        modifier = Modifier.padding(bottom = 8.dp),
        border = BorderStroke(1.dp, Color.White),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .weight(3f)
            ) {

                Row(modifier = Modifier.fillMaxWidth().height(20.dp)) {
                    Text(
                        //modifier = Modifier.padding(end = 8.dp),
                        text = stringResource(id = R.string.name) + ": ",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = mentor.mentorNameT,
                        fontSize = 12.sp,
                        color = Color.White,
                    )
                }


                Row(modifier = Modifier.fillMaxWidth().height(20.dp)) {
                    Text(
                        text = stringResource(id = R.string.age)+ ": ",
                        //modifier = Modifier.padding(end = 8.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White

                    )

                    Text(
                        text = mentor.mentorAge,
                        fontSize = 12.sp,
                        color = Color.White

                    )

                }

                Row(modifier = Modifier.fillMaxWidth().height(20.dp)) {
                    Text(
                        text = stringResource(id = R.string.location)+ ": ",
                        //modifier = Modifier.padding(end = 8.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White

                    )

                    Text(
                        text = mentor.mentorLocation,
                        fontSize = 12.sp,
                        color = Color.White

                    )

                }

                Row(modifier = Modifier.fillMaxWidth().height(20.dp)) {
                    Text(
                        text = stringResource(id = R.string.education)+ ": ",
                        //modifier = Modifier.padding(end = 8.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White

                    )
                    Text(
                        text = mentor.mentorEducation,
                        fontSize = 12.sp,
                        color = Color.White

                    )
                }
            }
        }
    }
}