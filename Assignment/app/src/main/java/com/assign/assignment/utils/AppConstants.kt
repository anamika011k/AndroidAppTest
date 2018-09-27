package com.assign.assignment.utils

import android.content.Context
import android.net.ConnectivityManager

object AppConstants {
    val SAVE_ACTIVITY_STATE = "activity"
    val SAVE_FRAGMENT_STATE = "fragment"

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
