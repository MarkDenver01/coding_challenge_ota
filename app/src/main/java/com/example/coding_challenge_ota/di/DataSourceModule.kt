package com.example.coding_challenge_ota.di

import com.example.coding_challenge_ota.data.datasource.local.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {
    @Provides
    @Singleton
    fun provideLocalDataSource(appDatabase: AppDatabase) =
        appDatabase.levelDao()

    @Provides
    @Singleton

}