package com.example.ts.view.fragments.auth.signUp.companySignUp

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompanySignUpViewModel @ViewModelInject constructor(): ViewModel() {

    val companyName = MutableLiveData<String>("")
    val companyEmail = MutableLiveData<String>("")
}