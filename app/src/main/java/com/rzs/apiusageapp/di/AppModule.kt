package com.rzs.apiusageapp.di

import android.app.Application
import androidx.room.Room
import com.rzs.apiusageapp.BuildConfig
import com.rzs.apiusageapp.data.data_sorce.NetworkService
import com.rzs.apiusageapp.data.repository.NetworkRepoImpl
import com.rzs.apiusageapp.domain.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = "http://private-2a065d-testnapify.apiary-mock.com/"

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor =HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }else{
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL:String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): NetworkService = retrofit.create(NetworkService::class.java)


    @Provides
    @Singleton
    fun provideApiHelper(networkRepoImpl: NetworkRepoImpl): NetworkRepository = networkRepoImpl

}