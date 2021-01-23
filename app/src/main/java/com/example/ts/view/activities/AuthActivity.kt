package com.example.ts.view.activities

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.ts.R

import com.example.ts.managers.SharedPreferencesManager
import com.example.ts.view.activities.abstraction.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthActivity : BaseActivity() {

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        setupNavController()
    }


    private fun setupNavController() {
        navController = Navigation.findNavController(this, R.id.auth_host_fragment)
    }

}