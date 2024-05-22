package com.example.mentormatching.database.repository

import com.example.mentormatching.model.HomePageButtonNavigation

/*
val id: Long = 0,
val buttonNavigationName: String = ""
val routeNavigation: String = ""

*/

fun getallHomePageButtonNavigation(): List<HomePageButtonNavigation> {
    return listOf(
        HomePageButtonNavigation(id = 0, buttonNavigationName = "Profile", routeNavigation = "profileScreen"),
        HomePageButtonNavigation(id = 1, buttonNavigationName = "Find a mentor", routeNavigation = "findMentorScreen"),
        HomePageButtonNavigation(id = 2, buttonNavigationName = "Messages", routeNavigation = "messagesScreen"),
        HomePageButtonNavigation(id = 3, buttonNavigationName = "Settings", routeNavigation = "settingsScreen"),

    )
}

