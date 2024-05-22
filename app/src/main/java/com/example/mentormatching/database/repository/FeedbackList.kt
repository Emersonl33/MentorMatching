package com.example.mentormatching.database.repository

import com.example.mentormatching.model.Feedback


/*
    val id: Long = 0,
    val messageDateTime: String = "",
    val messageTitle: String = "",
    val mentorNameT: String = "",
    val feedbackMessage: String = ""
*/

fun getAllFeedbacks(): List<Feedback> {
    return listOf(
        Feedback(
            id = 1,
            messageDateTime = "12/05/2024 15:30",
            messageTitle = "Excelente Progresso na Apresentação de Projetos",
            mentorNameT = "Dr. Silva",
            feedbackMessage = "Parabéns pelo seu progresso na clareza e impacto das apresentações! Seu domínio do conteúdo e sua confiança são notáveis. Continue assim!"
        ),
        Feedback(
            id = 2,
            messageDateTime = "18/04/2024 07:30",
            messageTitle = "Leadership Skills Development",
            mentorNameT = "Maria Torres",
            feedbackMessage = "Seu compromisso em ouvir e inspirar a equipe mostra uma grande evolução em suas habilidades de liderança. Continue cultivando essa empatia e visão estratégica!"
        ),
        Feedback(
            id = 3,
            messageDateTime = "09/03/2024 10:30",
            messageTitle = "Aperfeiçoamento na Resolução de Problemas",
            mentorNameT = "John Carter",
            feedbackMessage = "Your commitment to listen and inspire the team shows significant growth in your leadership skills. Keep nurturing that empathy and strategic vision!"
        ),
        Feedback(
            id = 4,
            messageDateTime = "25/02/2024 17:30",
            messageTitle = "Progreso Notable en Comunicación Interpersonal",
            mentorNameT = "Ana Oliveira",
            feedbackMessage = "Tu habilidad para comunicarte de manera clara y empática ha sido notable. Has demostrado un gran progreso en la construcción de relaciones y en la resolución de conflictos. ¡Sigue así, estás en el camino correcto para convertirte en un excelente comunicador!"
        ),
)
}

fun getFeedbacksByMentor(mentorName: String): List<Feedback> {
    return getAllFeedbacks().filter {
        it.mentorNameT.startsWith(prefix = mentorName, ignoreCase = true)
    }
}