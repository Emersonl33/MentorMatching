package com.example.mentormatching.model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DataViewModel: ViewModel() {
    val state = mutableStateOf(UserProfile())
    init{
        getData()
    }
    private fun getData() {
        viewModelScope.launch {
            state.value = getDataFromFireStore()
        }
    }
    suspend fun getDataFromFireStore(): UserProfile {
        val db = FirebaseFirestore.getInstance()
        val auth = FirebaseAuth.getInstance()
        var userProfile = UserProfile()

        val user = auth.currentUser
        if (user != null) {
            val userId = user.uid
            try {
                val document = db.collection("users").document(userId).get().await()
                userProfile = document.toObject(UserProfile::class.java) ?: UserProfile()
                Log.d("Firebase", "Data fetched for user: $userProfile")
            } catch (e: Exception) {
                Log.d("Firebase Error", "Failed to fetch user data: $e")
            }
        } else {
            Log.d("Firebase", "No user logged in")
        }
        return userProfile
    }
}


