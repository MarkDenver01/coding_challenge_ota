package com.example.coding_challenge_ota.utils

import android.content.Context
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

object FileDownloader {

    private suspend fun download(
        context: Context,
        url: String,
        filename: String
    ): Boolean = withContext(Dispatchers.IO) {
        val newFile = File(context.filesDir, filename)

        if (newFile.exists()) {
            return@withContext true
        } else {
            newFile.createNewFile()
        }

        val fullUrl = if (url.startsWith("http")) url else "https:$url"
        var connection: HttpURLConnection? = null
        var result = false

        try {
            connection = URL(fullUrl).openConnection() as HttpURLConnection
            connection.connect()

            val statusCode = connection.responseCode
            if (statusCode != HttpURLConnection.HTTP_OK) {
                connection.disconnect()
                return@withContext false
            }

            connection.inputStream.use { inputStream ->
                newFile.outputStream().use { outputStream ->
                    outputStream.write(inputStream.readBytes())
                }
            }
            result = true
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            connection?.disconnect()
        }

        result
    }

    suspend fun downloadPdfAsImageBitmap(
        context: Context,
        url: String,
        filename: String
    ): ImageBitmap? = withContext(Dispatchers.IO) {
        if (BitmapCache.contains(filename)) {
            return@withContext BitmapCache[filename]
        }

        val result = download(context, url, filename)

        if (result) {
            val bitmap = PdfToBitmap.convert(context, filename)
            return@withContext bitmap.asImageBitmap()
        }

        return@withContext null
    }

}