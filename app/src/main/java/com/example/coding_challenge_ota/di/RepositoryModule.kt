package com.example.coding_challenge_ota.di

import com.example.coding_challenge_ota.data.datasource.local.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMainChallengeRepository(localDataSource: LocalDataSource) = localDataSource
}