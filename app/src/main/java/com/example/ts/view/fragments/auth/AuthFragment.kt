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
import com.example.ts.model.entities.TestEntity
import com.example.ts.utils.onThrottleClick
import com.example.ts.utils.showToast
import com.example.ts.view.adapters.SlideImageAdapter
import com.example.ts.view.adapters.pager.OnBoardingAdapter
import com.example.ts.view.fragments.abstraction.BaseFragment
import com.example.ts.view.fragments.auth.onBoarding.OnBoardingFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.android.synthetic.main.fragment_auth.*
import javax.inject.Inject

@FragmentScoped
class AuthFragment : BaseFragment() {

    private lateinit var binding: FragmentAuthBinding

    private var onBoardingAdapter: OnBoardingAdapter? = null
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

        setupViewPager()
    }

    //todo edit the text in different languages
    private fun setupViewPager() {
        onBoardingAdapter =
            activity?.supportFragmentManager?.let {
                OnBoardingAdapter(
                    fragmentManager = it,
                    lifecycle = lifecycle,
                    onBoardingContentList = arrayListOf(
                        OnBoardingFragment.getInstance(
                            "Study",
                            "Our app is a studying platform for teachers and students\n",
                            R.drawable.ic_onboarding_first
                        ),
                        OnBoardingFragment.getInstance(
                            "Chat",
                            "Chat and attend lessons on the go, anytime, anywhere",
                            R.drawable.ic_onboarding_second
                        ),
                        OnBoardingFragment.getInstance(
                            "Test",
                            "Work with your tests in the most comfortable way",
                            R.drawable.ic_onboarding_third
                        )
                    )
                )
            }

        with(binding) {
            viewPager.adapter = onBoardingAdapter
            dotsIndicator.setViewPager2(viewPager)
        }
    }


    override fun setupClicks() {
        with(binding) {
            skipButton.onThrottleClick {
                context?.showToast("in development")
            }
            authButton.onThrottleClick {
                findNavController().navigate(R.id.action_authFragment_to_signUpFragment)
            }
            loginButton.onThrottleClick {
                findNavController().navigate(R.id.action_authFragment_to_loginFragment)
            }
        }
    }
}