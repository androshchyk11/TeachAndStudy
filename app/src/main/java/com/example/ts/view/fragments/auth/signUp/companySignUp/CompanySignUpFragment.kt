package com.example.ts.view.fragments.auth.signUp.companySignUp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ts.R
import com.example.ts.databinding.FragmentCompanySignUpBinding
import com.example.ts.databinding.FragmentLoginBinding
import com.example.ts.utils.glide.GlideApp
import com.example.ts.utils.isValidEmail
import com.example.ts.utils.onThrottleClick
import com.example.ts.utils.showToast
import com.example.ts.view.activities.MainActivity
import com.example.ts.view.fragments.abstraction.BaseFragment
import com.example.ts.view.fragments.auth.signUp.userSignUp.UserSignUpViewModel

class CompanySignUpFragment : BaseFragment() {

    companion object{
        const val COMPANY_REGISTRATION_FLAG = "IsCompany"
    }

    private lateinit var binding: FragmentCompanySignUpBinding

    private val viewModel: CompanySignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_company_sign_up, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlideApp
            .with(requireContext())
            .load(R.mipmap.ic_company_sign_up)
            .into(binding.unboardingImage)

    }

    //todo edit all text
    private fun areFieldsValid(): Boolean {
        var isValid = true
        if (viewModel.companyEmail.value.isNullOrEmpty()) {
            context?.showToast("the mail is empty")
            isValid = false
        }
        if (!viewModel.companyEmail.value.isValidEmail()) {
            context?.showToast("the mail is not valid")
            isValid = false
        }
        if (viewModel.companyName.value.isNullOrEmpty()) {
            context?.showToast("Input company name")
            isValid = false
        }
        return isValid
    }

    override fun setupClicks() {
        with(binding) {
            nextButton.onThrottleClick {
                if (areFieldsValid()) {
                    val bundle = Bundle()
                    bundle.putBoolean(COMPANY_REGISTRATION_FLAG, true)
                    findNavController().navigate(R.id.action_signUpFragment_to_createPasswordFragment, bundle)
//                    startActivity(Intent(requireContext(), MainActivity::class.java))
                }
            }
        }
    }
}