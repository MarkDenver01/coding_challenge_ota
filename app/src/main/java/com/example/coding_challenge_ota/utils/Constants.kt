package com.example.coding_challenge_ota.utils

object Constants {
    const val HOME = "home"
    const val ACCOUNT = "account"
    const val JOURNEY = "journey"

    const val DATABASE_NAME = "challenge_db"

    const val REQUEST_TIME_OUT = 60L
    const val OTP_LENGTH = 6
    const val PER_PAGE_COUNT = 15

    const val DEFAULT_BASE_URL = "https://base-sample.com/"

    const val READ_CONNECTION_TIME_OUT_INTERVAL = 10L
    const val WRITE_CONNECTION_TIME_OUT_INTERVAL = 10L
    const val CONNECTION_TIME_OUT_INTERVAL = 30L

    const val SAMPLE_TOKEN_API = "S3IxRVXKxSNwPHyPJXpsc" // it depends on cloud services (AWS, AIM, etc) which generate a token for your API (as of now, I declare the token as STATIC)
}