package com.example.ts.view.fragments.auth.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ts.R
import com.example.ts.databinding.FragmentCompanySignUpBinding
import com.example.ts.databinding.FragmentLoginBinding
import com.example.ts.utils.glide.GlideApp
import com.example.ts.view.fragments.abstraction.BaseFragment

class CompanySignUpFragment:BaseFragment() {


    private lateinit var binding: FragmentCompanySignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_company_sign_up, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlideApp
            .with(requireContext())
            .load(R.drawable.ic_company_sign_up)
            .into(binding.unboardingImage)

    }

    override fun setupClicks() {

    }
}