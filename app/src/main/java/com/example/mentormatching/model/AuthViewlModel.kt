package com.example.mentormatching.model

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthViewlModel : ViewModel() {
    private val firebaseAuth = FirebaseAuth.getInstance()

    fun signIn(email: String, password: String, onSuccess: (FirebaseUser?) -> Unit, onFailure: (Exception) -> Unit) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { authResult ->
                onSuccess(authResult.user)
            }
            .addOnFailureListener { exception ->
                onFailure(exception)
            }
    }

    fun signUp(email: String, password: String, onSuccess: (FirebaseUser?) -> Unit, onFailure: (Exception) -> Unit) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { authResult ->
                onSuccess(authResult.user)
            }
            .addOnFailureListener { exception ->
                onFailure(exception)
            }
    }

    fun signOut() {
        firebaseAuth.signOut()
    }
}