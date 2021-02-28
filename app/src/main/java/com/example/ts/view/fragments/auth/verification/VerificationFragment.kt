package com.example.ts.view.fragments.auth.verification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.alimuzaffar.lib.pin.PinEntryEditText
import com.example.ts.R
import com.example.ts.databinding.FragmentVerificationBinding
import com.example.ts.view.fragments.abstraction.BaseFragment
import com.example.ts.view.fragments.auth.signUp.companySignUp.CompanySignUpFragment.Companion.COMPANY_REGISTRATION_FLAG
import com.example.ts.view.fragments.auth.signUp.userSignUp.UserSignUpViewModel
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class VerificationFragment : BaseFragment() {

    private lateinit var binding: FragmentVerificationBinding

    private val viewModel: VerificationViewModel by viewModels()
    private var isCompanyVerification: Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_verification, container, false)
        binding.lifecycleOwner = this
        binding.verificationText = viewModel
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parseBundle()
        setupViewModelCallbacks()
    }

    private fun parseBundle() {
        arguments?.getBoolean(COMPANY_REGISTRATION_FLAG)?.let {
            isCompanyVerification = it
        }
    }

    override fun setupClicks() {

        binding.backButton?.setOnClickListener {
            activity?.onBackPressed()
        }

        binding.continueButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putBoolean(COMPANY_REGISTRATION_FLAG, isCompanyVerification)
            findNavController().navigate(R.id.action_verificationFragment_to_createPasswordFragment, bundle)
        }

    }

    private fun setupViewModelCallbacks() {
        viewModel.apply {
            verificationCode.observe(viewLifecycleOwner) {
                if (it.length <= 3) {
                    binding.continueButton.isClickable = false
                    binding.continueButton.alpha = 0.3f
                } else {
                    binding.continueButton.isClickable = true
                    binding.continueButton.alpha = 1.0f
                }
            }
        }
    }
}