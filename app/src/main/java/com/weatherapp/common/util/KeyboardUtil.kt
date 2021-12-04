package com.weatherapp.common.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun showSoftKeyboard(view: View) {
    if (view.hasFocus()) {
        (view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).apply {
            showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}
