package com.example.ts.view.adapters.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.example.ts.model.entities.TestEntity
import com.example.ts.view.fragments.auth.onBoarding.OnBoardingFragment


class OnBoardingAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val onBoardingContentList: List<OnBoardingFragment>
) : FragmentPagerAdapter(fragmentManager, lifecycle,onBoardingContentList) {}