package com.example.ts.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class RequestError(
    var type: String,
    var code: Int? = null
) : Parcelable {
    companion object {
        const val CONNECTION_ERROR = "CONNECTION_ERROR"
        const val REQUEST_ERROR = "REQUEST_ERROR"
        const val WRONG_CREDENTIALS_ERROR = "WRONG_CREDENTIALS_ERROR"
    }
}