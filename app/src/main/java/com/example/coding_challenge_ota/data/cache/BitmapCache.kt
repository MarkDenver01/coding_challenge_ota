package com.example.coding_challenge_ota.data.cache

import androidx.compose.ui.graphics.ImageBitmap

object BitmapCache {
    private val cacheMap = mutableMapOf<String, ImageBitmap>()

    operator fun get(key: String): ImageBitmap? {
        return cacheMap[key]
    }

    operator fun set(key: String, value: ImageBitmap) {
        cacheMap[key] = value
    }

    fun contains(key: String): Boolean {
        return cacheMap.containsKey(key)
    }
}
