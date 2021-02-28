package com.example.ts.view.fragments.auth.verification

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ts.R
import com.example.ts.databinding.FragmentCreatePasswordBinding
import com.example.ts.utils.isValidPass
import com.example.ts.utils.onThrottleClick
import com.example.ts.utils.showToast
import com.example.ts.view.activities.AuthActivity
import com.example.ts.view.activities.MainActivity
import com.example.ts.view.fragments.abstraction.BaseFragment
import com.example.ts.view.fragments.auth.signUp.companySignUp.CompanySignUpFragment
import com.example.ts.view.fragments.auth.signUp.companySignUp.CompanySignUpFragment.Companion.COMPANY_REGISTRATION_FLAG
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class CreatePasswordFragment : BaseFragment() {

    private lateinit var binding: FragmentCreatePasswordBinding

    private val viewModel: VerificationViewModel by viewModels()
    private var isCompanyCreatingPassword: Boolean? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_password, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parseBundle()
        setupViewModelCallbacks()
    }

    private fun parseBundle() {
        arguments?.getBoolean(COMPANY_REGISTRATION_FLAG)?.let {
            isCompanyCreatingPassword = it
        }
    }

    private fun setupViewModelCallbacks() {
    }

    private fun areFieldsValid(): Boolean {
        var isValid = true
        if (viewModel.password.value != viewModel.confirmPassword.value) {
            isValid = false
            context?.showToast("Passwords don`t match each other")
        }
        return isValid
    }

    override fun setupClicks() {
        with(binding) {
            saveButton.onThrottleClick {
                if (areFieldsValid()) {
                    if (isCompanyCreatingPassword == false) {
                        (activity as AuthActivity).finish()
                        startActivity(Intent(requireContext(), MainActivity::class.java))
                    } else if(isCompanyCreatingPassword == true) {
                        findNavController().navigate(R.id.action_createPasswordFragment_to_inviteMembersFragment)
                    }
                }
            }
        }
    }
}