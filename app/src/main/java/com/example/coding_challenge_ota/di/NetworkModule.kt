package com.example.coding_challenge_ota.di

import android.content.Context
import com.example.coding_challenge_ota.utils.Constants.CONNECTION_TIME_OUT_INTERVAL
import com.example.coding_challenge_ota.utils.Constants.DEFAULT_BASE_URL
import com.example.coding_challenge_ota.utils.Constants.READ_CONNECTION_TIME_OUT_INTERVAL
import com.example.coding_challenge_ota.utils.Constants.WRITE_CONNECTION_TIME_OUT_INTERVAL
import com.example.coding_challenge_ota.utils.isNetworkConnected
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.CacheControl
import okhttp3.ConnectionPool
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(DEFAULT_BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        interceptor: Interceptor,
        connectionPool: ConnectionPool,
        cache: Cache
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(httpLoggingInterceptor)
            .connectTimeout(CONNECTION_TIME_OUT_INTERVAL, TimeUnit.SECONDS)
            .writeTimeout(WRITE_CONNECTION_TIME_OUT_INTERVAL, TimeUnit.SECONDS)
            .readTimeout(READ_CONNECTION_TIME_OUT_INTERVAL, TimeUnit.SECONDS)
            .connectionPool(connectionPool)
            .cache(cache)
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideCache(@ApplicationContext context: Context): Cache {
        val cacheSize: Long = 10 * 1024 * 1024
        val cache = Cache(context.cacheDir, cacheSize)
        return cache
    }

    @Provides
    @Singleton
    fun provideConnectionPool(): ConnectionPool =
        ConnectionPool(10, 10, TimeUnit.MINUTES)

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .setLenient()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideCachingInterceptor(
        @ApplicationContext context: Context
    ): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            var newRequest = chain.request().newBuilder().build()

            if (isNetworkConnected(context)) {
                val cacheControl = CacheControl.Builder()
                    .maxAge(5, TimeUnit.MINUTES).build()

                newRequest = newRequest.newBuilder()
                    .cacheControl(cacheControl)
                    .build()
            } else {
                newRequest = chain.request().newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build()
            }

            return@Interceptor chain.proceed(newRequest)
        }
    }


}

