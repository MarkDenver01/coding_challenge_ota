package com.example.coding_challenge_ota.di

import android.content.Context
import androidx.room.Room
import com.example.coding_challenge_ota.data.datasource.local.AppDatabase
import com.example.coding_challenge_ota.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun providesDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()

    @Provides
    fun provideLevelDao(appDatabase: AppDatabase) = appDatabase.levelDao()
}