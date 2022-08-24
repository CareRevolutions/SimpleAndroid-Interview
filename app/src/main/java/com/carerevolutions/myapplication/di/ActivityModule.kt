package com.carerevolutions.myapplication.di

import com.carerevolutions.myapplication.feature_country_subdivision.CountrySubdivisionApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ActivityModule {

    @Singleton
    @Provides
    fun providesCountrySubdivisionApi(retrofit: Retrofit): CountrySubdivisionApi =
        retrofit.create(CountrySubdivisionApi::class.java)
}