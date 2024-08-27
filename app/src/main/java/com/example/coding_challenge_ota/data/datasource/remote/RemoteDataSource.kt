package com.example.coding_challenge_ota.data.datasource.remote

import com.example.coding_challenge_ota.data.datasource.remote.api.ApiService
import com.example.coding_challenge_ota.domain.models.Level
import com.example.coding_challenge_ota.domain.repository.Remote
import com.example.coding_challenge_ota.utils.JsonResponseTransfer
import com.example.coding_challenge_ota.utils.setHeader
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) : Remote {
    override suspend fun retrieveLevel(token: String): Observable<List<Level>> {
        val request: Observable<Response<JsonObject>> =
            apiService.getLevel("URL HERE", setHeader(token))
        return request.map { jsonResponse ->
            JsonResponseTransfer.jsonTransfer(jsonResponse)
        }
    }


}