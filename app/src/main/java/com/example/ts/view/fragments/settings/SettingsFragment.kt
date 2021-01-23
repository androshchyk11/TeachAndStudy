package com.example.ts.view.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ts.R
import com.example.ts.databinding.FragmentSettingsBinding
import com.example.ts.utils.onThrottleClick
import com.example.ts.view.fragments.abstraction.BaseFragment

class SettingsFragment : BaseFragment() {

    private lateinit var binding: FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //getCurrentUserLocation()
    }


    override fun setupClicks() {
        with(binding){
            language.onThrottleClick {

            }
            rateApp.onThrottleClick {

            }
            feedback.onThrottleClick {

            }
            privacyPolicy.onThrottleClick {

            }
            aboutUs.onThrottleClick {

            }
        }
    }
}