package com.example.coding_challenge_ota.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import dagger.hilt.android.qualifiers.ApplicationContext


fun isNetworkConnected(context: Context): Boolean {
    val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = manager.activeNetwork ?: return false
    val capabilities = manager.getNetworkCapabilities(network) ?: return false
    return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}

fun setHeader(token: String): Map<String, String> {
    val header = mutableMapOf<String, String>()
    header["Content-Type"] = "application/json"
    header["Authorization"] = token
    header["Connection"] = "keep-alive"
    return header
}