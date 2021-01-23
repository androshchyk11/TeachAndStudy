package com.example.ts.utils

import android.app.Activity
import android.content.Context
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.example.ts.R
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern

fun Activity.hideKeyBoard(): Unit {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
        view.clearFocus()
    }
}

fun Activity.showKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }
}

fun Activity.getScreenWidth() = this.resources.displayMetrics.widthPixels

fun Activity.getScreenHeight() = this.resources.displayMetrics.heightPixels

fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, "" + text, duration).show()
}

fun Context.generateProgressDialog(): MaterialDialog =
    MaterialDialog(this)
        .cornerRadius(literalDp = 8.0f)
        .cancelable(false)
        .cancelOnTouchOutside(false)
//        .customView(viewRes = R.layout.progress_dialog_view)


fun String?.isValidEmail(): Boolean {
    if (this.isNullOrBlank())
        return false

    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String?.isValidPass(): Boolean {
    return Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,30}$").matcher(this)
        .matches()
}

fun Context.showMessageDialog(
    message: String,
    okClickListener: View.OnClickListener? = null
) {
    MaterialDialog(this).show {
        cornerRadius(literalDp = 8.0f)
        cancelable(false)
        cancelOnTouchOutside(false)
        message(text = message) {
            messageTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        }
        positiveButton(res = R.string.ok, click = {
            it.dismiss()
            okClickListener?.onClick(null)
        })
    }
}
fun View.onThrottleClick(windowDuration: Long = 750, subscribeFunction: () -> Unit): Disposable =
    clicks()
        .throttleFirst(windowDuration, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {
            subscribeFunction.invoke()
        }