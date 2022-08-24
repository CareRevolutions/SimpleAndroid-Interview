package com.carerevolutions.myapplication.di

import com.carerevolutions.myapplication.feature_country_subdivision.CountrySubdivisionApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    @ActivityScoped
    @Provides
    fun providesCountrySubdivisionApi(retrofit: Retrofit): CountrySubdivisionApi =
        retrofit.create(CountrySubdivisionApi::class.java)
}