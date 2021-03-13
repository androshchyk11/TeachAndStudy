package com.example.ts.view.activities

import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import androidx.core.animation.doOnEnd
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.LottieDrawable
import com.example.ts.R
import com.example.ts.managers.SharedPreferencesManager
import com.example.ts.view.activities.abstraction.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject


@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        checkIfUserIsAuthorized()
    }

    private fun checkIfUserIsAuthorized() {
        val animator = ValueAnimator.ofFloat(0f, 0.1f)
        animator.addUpdateListener {
            animationView.progress = animator.animatedValue as Float
        }
        animator.start()
        animator.doOnEnd {
            Observable.empty<Any>()
                .delay(2000L, java.util.concurrent.TimeUnit.MILLISECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .doOnComplete {
                    if (!this@SplashActivity.isFinishing) {
                        finish()
//                    if (sharedPreferencesManager.userAccessToken.isNullOrEmpty()) {
//                        startActivity(Intent(this@SplashActivity, AuthActivity::class.java))
//                    } else {
                        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
//                    }
                    }
                }
                .subscribe()
        }
//        animation.comp

    }
}