package com.example.ts.view.fragments.auth.verification

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// todo propably rename if logic will be added
class VerificationViewModel @ViewModelInject constructor(): ViewModel() {

    val verificationCode = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")
    val confirmPassword = MutableLiveData<String>("")
}