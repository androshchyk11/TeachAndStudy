package com.example.ts.view.fragments.auth.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.ts.R
import com.example.ts.databinding.FragmentSignUpBinding
import com.example.ts.view.adapters.pager.SignUpPagerAdapter
import com.example.ts.view.fragments.abstraction.BaseFragment
import com.example.ts.view.fragments.auth.signUp.companySignUp.CompanySignUpFragment
import com.example.ts.view.fragments.auth.signUp.userSignUp.UserSignUpFragment
import dagger.hilt.android.scopes.FragmentScoped


@FragmentScoped
class SignUpFragment : BaseFragment() {

    private val TYPE_USER = "TYPE_USER"
    private val TYPE_COMPANY = "TYPE_COMPANY"
    private lateinit var binding: FragmentSignUpBinding
    private var signUpPagerAdapter: SignUpPagerAdapter? = null

    private var userType = TYPE_USER
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
    }


    private fun setupViewPager() {
        signUpPagerAdapter =
            activity?.supportFragmentManager?.let {
                SignUpPagerAdapter(
                    fragmentManager = it,
                    lifecycle = lifecycle,
                    listOfFragments = arrayListOf(
                        UserSignUpFragment(), CompanySignUpFragment()
                    )
                )
            }

        with(binding) {
            viewPager.adapter = signUpPagerAdapter
            viewPager.isUserInputEnabled = false
        }
    }


    override fun setupClicks() {
        with(binding) {
            userButton.setOnClickListener {
                if (userType == TYPE_USER) {
                    return@setOnClickListener
                } else {

                    userType = TYPE_USER

                    userButton.background = ContextCompat.getDrawable(requireContext(), R.drawable.left_rounded_black_bg)
                    userButton.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.blackButtonBg);
                    userButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.buttonBlue))


                    companyButton.background = ContextCompat.getDrawable(requireContext(), R.drawable.right_rounded_grey_bg)
                    companyButton.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.greyText);
                    companyButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackButtonBg))

                    binding.viewPager.currentItem = 0
                }


            }
            companyButton.setOnClickListener {
                if (userType == TYPE_COMPANY) {
                    return@setOnClickListener
                } else {
                    userType = TYPE_COMPANY
//                    ContextCompat.getDrawable(requireContext(), R.drawable.right_rounded_black_bg)?.let{
//                        companyButton.setBackgroundDrawable(it)
//                    }
                    companyButton.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.blackButtonBg);
                    companyButton.setBackgroundResource(R.drawable.right_rounded_black_bg)
                    companyButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.buttonBlue))


                    userButton.background = ContextCompat.getDrawable(requireContext(), R.drawable.left_rounded_grey_bg)
                    userButton.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.greyText);
                    userButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.blackButtonBg))

                    binding.viewPager.currentItem = 1
                }
            }
        }

    }
}
