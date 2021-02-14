package com.example.ts.view.fragments.auth.signUp.userSignUp

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserSignUpViewModel @ViewModelInject constructor(): ViewModel() {

    val userName = MutableLiveData<String>()
    val userSurname =MutableLiveData<String>()
    val userEmail = MutableLiveData<String>()
}