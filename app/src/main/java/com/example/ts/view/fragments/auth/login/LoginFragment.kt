package com.example.ts.view.fragments.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.ts.R
import com.example.ts.databinding.FragmentLoginBinding
import com.example.ts.utils.isValidEmail
import com.example.ts.utils.isValidPass
import com.example.ts.utils.onThrottleClick
import com.example.ts.utils.showToast
import com.example.ts.view.activities.AuthActivity
import com.example.ts.view.activities.MainActivity
import com.example.ts.view.fragments.abstraction.BaseFragment
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class LoginFragment : BaseFragment() {


    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun areFieldsValid(): Boolean {
        var isValid = true
        if (viewModel.email.value.isNullOrEmpty()) {
            context?.showToast("this field is empty")
            isValid = false
        }
        if (!viewModel.email.value.isValidEmail()) {
            context?.showToast("the mail is empty")
            isValid = false
        }
        if (!viewModel.password.value.isValidPass()) {
            context?.showToast("the password is not valid")
            isValid = false
        }
        if (viewModel.password.value.isNullOrEmpty()) {
            context?.showToast("the password is empty")
            isValid = false
        }
        return isValid
    }


    override fun setupClicks() {
        with(binding) {
            loginButton.onThrottleClick {
                if (areFieldsValid()) {
                    (activity as AuthActivity).finish()
                    startActivity(Intent(requireContext(), MainActivity::class.java))
                }
            }
        }
    }
}