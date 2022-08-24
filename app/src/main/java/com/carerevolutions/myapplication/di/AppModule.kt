package com.carerevolutions.myapplication.di

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesJacksonMapper(): ObjectMapper = ObjectMapper().registerModule(KotlinModule())
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun providesRetrofitClient(okHttpClient: OkHttpClient, jacksonMapper: ObjectMapper): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.carerev.com/api/v1/")
            .client(okHttpClient)
            .addConverterFactory(JacksonConverterFactory.create(jacksonMapper))
            .build()
    }
}