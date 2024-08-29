package com.example.coding_challenge_ota.domain.repository

import com.example.coding_challenge_ota.domain.models.Levels
import io.reactivex.Observable

interface Remote {
    suspend fun retrieveLevel(token: String): Observable<Levels>
}