package com.example.mentormatching.database.repository

import android.location.Location
import br.com.fiap.mentormatching2.model.Mentor

/*
    val id: Long = 0,
    val mentorNameT: String = "",
    val mentorAge: String = "",
    val mentorEducation: String = "",
    val mentorArea: String = ""
*/

fun getAllMentors(): List<Mentor> {
    return listOf(
        Mentor(
            id = 1,
            mentorNameT = "Sofia Rodriguez",
            mentorAge = "34",
            mentorEducation = "Engeneering",
            mentorLocation = "São Paulo"
        ),
        Mentor(
            id = 2,
            mentorNameT = "Marcus Nguyen",
            mentorAge = "25",
            mentorEducation = "Archtecture",
            mentorLocation = "Amazonas"
        ),
        Mentor(
            id = 3,
            mentorNameT = "Emily Patel",
            mentorAge = "56",
            mentorEducation = "Sports",
            mentorLocation = "Rio de Janeiro"
        ),
        Mentor(
            id = 4,
            mentorNameT = "Javier Santos",
            mentorAge = "65",
            mentorEducation = "Technology",
            mentorLocation = "Tocantins"
        ),
        )
}

fun getMentorsByMentorEducation(mentorEducation: String): List<Mentor> {
    return getAllMentors().filter {
        it.mentorEducation.startsWith(prefix = mentorEducation, ignoreCase = true)
    }
}

