package com.example.coding_challenge_ota.data.repository

import android.content.Context
import android.util.Log
import com.example.coding_challenge_ota.data.datasource.local.LocalDataSource
import com.example.coding_challenge_ota.data.datasource.local.db.entity.JourneyStatus
import com.example.coding_challenge_ota.data.datasource.local.db.entity.UserEntity
import com.example.coding_challenge_ota.data.datasource.remote.RemoteDataSource
import com.example.coding_challenge_ota.domain.models.Level
import com.example.coding_challenge_ota.domain.models.Levels
import com.example.coding_challenge_ota.utils.Constants.SAMPLE_TOKEN_API
import com.example.coding_challenge_ota.utils.Constants.isDebug
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.io.File
import javax.inject.Inject
import kotlin.random.Random

@ViewModelScoped
@OptIn(ExperimentalSerializationApi::class)
class LevelRepository @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    private val compositeDisposable by lazy { CompositeDisposable() }
    private val mockJourneyStatus: Int = Random.nextInt(100)
    private val mockFirePoints: Int = (mockJourneyStatus * 2)
    private val userName = "denver"

    suspend fun getUserLevel(): UserEntity {
        if (isDebug) {
            val json = Json.decodeFromStream<Levels>(context.assets.open("levels.json"))
            val entity = UserEntity(userName, mockFirePoints, JourneyStatus(mockJourneyStatus), json)
            Log.d("xxxxx-json-dummy", "usr: " + entity.userName)
            Log.d("xxxxx-json-dummy", "level: " + entity.levels.levels[0].level)
            Log.d("xxxxx-json-dummy", "title: " + entity.levels.levels[0].title)
            Log.d("xxxxx-json-dummy", "description: " + entity.levels.levels[0].description)
            Log.d("xxxxx-json-dummy", "state: " + entity.levels.levels[0].state)
            Log.d("xxxxx-json-dummy", "activities: " + entity.levels.levels[0].activities[0].title)

            return entity
        }

        val cached = getLevelFromLocal(userName)
        if (cached.levels.levels.isNotEmpty()) {
            Log.d("xxxxx-db", "usr: " + cached.userName)
            Log.d("xxxxx-db", "level: " + cached.levels.levels[0].level)
            Log.d("xxxxx-db", "title: " + cached.levels.levels[0].title)
            Log.d("xxxxx-db", "description: " + cached.levels.levels[0].description)
            Log.d("xxxxx-db", "state: " + cached.levels.levels[0].state)
            Log.d("xxxxx-db", "activities: " + cached.levels.levels[0].activities[0].title)
            return cached
        }

        val levels = getLevelFromApi(SAMPLE_TOKEN_API)
        val userEntity =
            UserEntity(userName, mockFirePoints, JourneyStatus(mockJourneyStatus), levels)
        localDataSource.insertLevel(userEntity)
        return userEntity
    }

    private suspend fun getLevelFromLocal(userName: String): UserEntity =
        withContext(Dispatchers.IO) {
            val localData = localDataSource.retrieveLevel(userName)

            return@withContext localData
        }

    private suspend fun getLevelFromApi(token: String): Levels {
        var levels = Levels(listOf())
        compositeDisposable.add(remoteDataSource.retrieveLevel(token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { responses ->
                Log.d("xxxxx-api", "level: " + responses.levels[0].level)
                Log.d("xxxxx-api", "title: " + responses.levels[0].title)
                Log.d("xxxxx-api", "description: " + responses.levels[0].description)
                Log.d("xxxxx-api", "state: " + responses.levels[0].state)
                Log.d("xxxxx-api", "activities: " + responses.levels[0].activities[0].title)
                levels = responses
            })
        return levels
    }
}