package com.example.mentormatching.database.repository

import com.example.mentormatching.model.MentorPageButtonNavigation

/*
val id: Long = 0,
val buttonNavigationName: String = ""
val routeNavigation: String = ""
*/


fun getMentorByMatch(): List<MentorPageButtonNavigation> {
    return listOf(
        MentorPageButtonNavigation(id = 0, buttonNavigationName = "Raul", routeNavigation = "Mentor1Screen"),
        MentorPageButtonNavigation(id = 1, buttonNavigationName = "Wagner", routeNavigation = "Mentor2Screen"),
        MentorPageButtonNavigation(id = 2, buttonNavigationName = "Aurora", routeNavigation = "Mentor3Screen"),
        MentorPageButtonNavigation(id = 3, buttonNavigationName = "Alana", routeNavigation = "Mentor4Screen")
    )
}