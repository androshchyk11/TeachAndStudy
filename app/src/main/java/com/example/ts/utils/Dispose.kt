package com.example.ts.utils

import io.reactivex.disposables.CompositeDisposable

fun CompositeDisposable.disposeWithCheck() {
    if (!this.isDisposed) {
        this.dispose()
    }
}