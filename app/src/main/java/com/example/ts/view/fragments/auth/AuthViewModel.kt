package com.example.ts.view.fragments.auth

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel @ViewModelInject constructor(): ViewModel() {

    var email = MutableLiveData<String>("")
    var password = MutableLiveData<String>("")
}