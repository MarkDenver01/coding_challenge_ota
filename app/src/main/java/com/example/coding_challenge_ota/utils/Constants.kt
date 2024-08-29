package com.example.coding_challenge_ota.utils

import kotlin.random.Random
import kotlin.random.nextInt

object Constants {
    const val DATABASE_NAME = "challenge_db"
    const val DEFAULT_BASE_URL = "https://base-sample.com/"
    const val BASE_URL = "" // add your base url and end point

    const val READ_CONNECTION_TIME_OUT_INTERVAL = 10L
    const val WRITE_CONNECTION_TIME_OUT_INTERVAL = 10L
    const val CONNECTION_TIME_OUT_INTERVAL = 30L

    const val isDebug = true // SET TRUE IF LOCAL DB, OTHERWISE FALSE

    const val SAMPLE_TOKEN_API = "S3IxRVXKxSNwPHyPJXpsc" // it depends on cloud services (AWS, AIM, etc) which generate a token for your API (as of now, I declare the token as STATIC)
}