package com.example.ts.view.fragments.auth.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel @ViewModelInject constructor(): ViewModel() {

    var email = MutableLiveData<String>("")
    var password = MutableLiveData<String>("")
}