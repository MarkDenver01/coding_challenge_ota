package com.example.coding_challenge_ota.data.datasource.remote.api

import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getLevel(
        @Url baseUrl: String,
        @HeaderMap headerMap: Map<String, String>
    ): Observable<Response<JsonObject>>
}