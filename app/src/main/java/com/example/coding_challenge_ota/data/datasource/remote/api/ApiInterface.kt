package com.example.coding_challenge_ota.data.datasource.remote.api

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Url

interface ApiInterface {

    @GET
    fun getSampleApi(
        @Url
        baseUrl: String,
        @HeaderMap
        header: Map<String, String>
    ): Observable<Response<JsonObject>>


}