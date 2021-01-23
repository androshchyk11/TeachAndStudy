package com.example.ts.view.fragments.abstraction

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.ts.utils.disposeWithCheck
import com.example.ts.utils.hideKeyBoard
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment: Fragment() {

    lateinit var compositeDisposable: CompositeDisposable
    var lockBackStack = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        compositeDisposable = CompositeDisposable()
        activity?.hideKeyBoard()

        setupClicks()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        compositeDisposable.disposeWithCheck()
    }

    abstract fun setupClicks()
}