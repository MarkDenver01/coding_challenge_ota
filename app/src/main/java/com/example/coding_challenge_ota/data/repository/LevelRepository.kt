package com.example.coding_challenge_ota.data.repository

import com.example.coding_challenge_ota.data.datasource.local.LocalDataSource
import com.example.coding_challenge_ota.data.datasource.local.db.entity.UserEntity
import com.example.coding_challenge_ota.data.datasource.remote.RemoteDataSource
import com.example.coding_challenge_ota.domain.models.Level
import com.example.coding_challenge_ota.utils.Constants.SAMPLE_TOKEN_API
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ViewModelScoped
class LevelRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    private val compositeDisposable by lazy { CompositeDisposable() }
    private val isDebug: Boolean = true // SET TRUE IF LOCAL DB, OTHERWISE FALSE

    suspend fun getLevels(userName: String): List<Level> {
        val cachedLevels = getLevelFromLocal(userName)
        if (cachedLevels.isEmpty()) {
            return cachedLevels
        }


        val levels = getLevelFromApi(SAMPLE_TOKEN_API)
        localDataSource.insertUser(
            UserEntity("Denver", 198, levels)
        )
        return (if (isDebug) cachedLevels else levels)
    }

    private suspend fun getLevelFromLocal(userName: String): List<Level> {
        var levels: List<Level> = listOf()
        val cachedLevel = localDataSource.retrieveLevel(userName)
        if (cachedLevel.levels.isEmpty()) {
            levels = cachedLevel.levels
        }
        return levels
    }

    private suspend fun getLevelFromApi(token: String): List<Level> {
        var levels: List<Level> = listOf()
        compositeDisposable.add(remoteDataSource.retrieveLevel(token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                levels = response
            }
        )
        return levels
    }
}