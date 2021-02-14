package com.example.ts.view.fragments.auth.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ts.R
import com.example.ts.databinding.FragmentUserSignUpBinding
import com.example.ts.view.fragments.abstraction.BaseFragment

class UserSignUpFragment:BaseFragment() {

    private lateinit var binding: FragmentUserSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_sign_up, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun setupClicks() {
    }
}