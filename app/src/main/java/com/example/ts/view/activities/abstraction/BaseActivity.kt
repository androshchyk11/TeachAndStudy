package com.example.ts.view.activities.abstraction

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ts.R
import com.example.ts.model.RequestError
import com.example.ts.utils.hideKeyBoard
import com.example.ts.utils.showMessageDialog
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.*

abstract class BaseActivity: AppCompatActivity() {

    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
    }

    protected fun showErrorMessage(error : RequestError, okClickListener: View.OnClickListener? = null) {
        when (error.type) {
            RequestError.CONNECTION_ERROR -> showMessageDialog(getString(R.string.connection_error), okClickListener)
            RequestError.WRONG_CREDENTIALS_ERROR -> showMessageDialog(getString(R.string.wrong_creds), okClickListener)
            RequestError.REQUEST_ERROR -> showMessageDialog("${getString(R.string.request_error)}${if (error.code != null) " ${error.code}" else ""}", okClickListener)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        hideKeyBoard()
        clearFindViewByIdCache()
        compositeDisposable.dispose()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}