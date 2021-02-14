package com.example.ts.view.fragments.auth.signUp.userSignUp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.ts.R
import com.example.ts.databinding.FragmentUserSignUpBinding
import com.example.ts.utils.isValidEmail
import com.example.ts.utils.isValidPass
import com.example.ts.utils.onThrottleClick
import com.example.ts.utils.showToast
import com.example.ts.view.activities.MainActivity
import com.example.ts.view.fragments.abstraction.BaseFragment
import com.example.ts.view.fragments.auth.login.LoginViewModel

class UserSignUpFragment : BaseFragment() {

    private lateinit var binding: FragmentUserSignUpBinding

    private val viewModel: UserSignUpViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_sign_up, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    //todo edit all text
    private fun areFieldsValid(): Boolean {
        var isValid = true
        if (viewModel.userEmail.value.isNullOrEmpty()) {
            context?.showToast("input your email")
            isValid = false
        }
        if (!viewModel.userEmail.value.isValidEmail()) {
            context?.showToast("the mail is not valid")
            isValid = false
        }
        if (viewModel.userName.value.isNullOrEmpty()) {
            context?.showToast("Input your name")
            isValid = false
        }

        if (viewModel.userSurname.value.isNullOrEmpty()) {
            context?.showToast("Input your surname")
            isValid = false
        }
        return isValid
    }


    //todo add new fragment to validate code, than fragment to create password
    override fun setupClicks() {
        with(binding) {
            nextButton.onThrottleClick {
                if (areFieldsValid()) {
                    startActivity(Intent(requireContext(), MainActivity::class.java))
                }
            }
        }
    }
}