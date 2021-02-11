package com.example.ts.view.fragments.auth.onBoarding

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.ts.R
import com.example.ts.databinding.FragmentOnBoardingBinding
import com.example.ts.databinding.FragmentSignUpBinding
import com.example.ts.utils.glide.GlideApp
import com.example.ts.view.fragments.abstraction.BaseFragment
import dagger.hilt.android.scopes.FragmentScoped


@FragmentScoped
class OnBoardingFragment : BaseFragment() {

    companion object {
        private const val FIRST_TEXT = "FIRST_TEXT"
        private const val SECOND_TEXT = "SECOND_TEXT"
        private const val IMAGE_ID = "IMAGE"

        fun getInstance(
            firstText: String,
            secondText: String,
            image: Int
        ): OnBoardingFragment {
            val fragment = OnBoardingFragment()

            fragment.firstText = firstText
            fragment.secondText = secondText
            fragment.imageId = image

            return fragment
        }
    }

    private var firstText: String? = null
    private var secondText: String? = null
    private var imageId: Int? = null


    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_on_boarding, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupInfo()
    }

    private fun setupInfo() {
        with(binding) {

            onBoardingText.text = firstText
            secondaryText.text = secondText
//            firstTxt = firstText
//            secondTxt = secondText
            GlideApp
                .with(requireContext())
                .load(ContextCompat.getDrawable(requireContext(), imageId!!))
                .into(unboardingImage)
        }
    }


    override fun setupClicks() {

    }

}