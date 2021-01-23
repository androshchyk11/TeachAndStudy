package com.example.ts.view.fragments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.ts.R
import com.example.ts.databinding.FragmentAuthBinding
import com.example.ts.databinding.FragmentLoginBinding
import com.example.ts.utils.onThrottleClick
import com.example.ts.utils.showToast
import com.example.ts.view.fragments.abstraction.BaseFragment
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.android.synthetic.main.fragment_auth.*

@FragmentScoped
class AuthFragment : BaseFragment() {

    private lateinit var binding: FragmentAuthBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_auth, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //getCurrentUserLocation()
    }




    override fun setupClicks() {
        with(binding) {
            skipButton.onThrottleClick {
                context?.showToast("in development")
            }
            authButton.onThrottleClick {

            }
            loginButton.onThrottleClick {
                findNavController().navigate(R.id.action_authFragment_to_loginFragment)
            }
        }
    }
}