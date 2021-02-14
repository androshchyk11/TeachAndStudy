package com.example.ts.view.adapters.pager

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.example.ts.view.fragments.abstraction.BaseFragment
import com.example.ts.view.fragments.auth.onBoarding.OnBoardingFragment

class SignUpPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val listOfFragments: List<BaseFragment>
) : FragmentPagerAdapter(fragmentManager, lifecycle, listOfFragments) {}