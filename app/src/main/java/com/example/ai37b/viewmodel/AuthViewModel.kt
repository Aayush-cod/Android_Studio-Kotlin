package com.example.ai37b.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ai37b.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {



    private val auth = Firebase.auth

    private val firestore = Firebase.firestore




    fun login(email : String, password: String, onResult: (Boolean, String?) -> Unit){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    onResult(true, null)
                }else{
                    onResult(false, it.exception?.localizedMessage)
                }
            }

    }


    fun signup(email : String, password : String, onResult : (Boolean, String?)-> Unit){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if (it.isSuccessful){

                    var userId = it.result?.user?.uid

                    val userModel = UserModel(email, password, userId!!)

                    firestore.collection("users").document()
                        .set(userModel)
                        .addOnCompleteListener { dbTask ->
                            if (dbTask.isSuccessful){
                                onResult(true, null)
                            }else{
                                onResult(false, "Something went Wrong!")
                            }
                        }

                }else{
                    onResult(false, it.exception?.localizedMessage)
                }
            }

    }

}