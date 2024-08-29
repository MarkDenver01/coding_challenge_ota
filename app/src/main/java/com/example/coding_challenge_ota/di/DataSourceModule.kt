package com.example.coding_challenge_ota.di

import com.example.coding_challenge_ota.data.datasource.local.db.AppDatabase
import com.example.coding_challenge_ota.data.datasource.remote.RemoteDataSource
import com.example.coding_challenge_ota.data.datasource.remote.api.ApiService
import com.example.coding_challenge_ota.domain.repository.Remote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataSourceModule {
    @Provides
    @Singleton
    fun provideLocalDataSource(appDatabase: AppDatabase) = appDatabase.userDao()

    @Provides
    @Singleton
    fun provideRemoteDataSource(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}