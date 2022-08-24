package com.carerevolutions.myapplication.di

import com.carerevolutions.myapplication.feature_country_subdivision.CountrySubdivisionApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @ViewModelScoped
    @Provides
    fun providesCountrySubdivisionApi(retrofit: Retrofit): CountrySubdivisionApi =
        retrofit.create(CountrySubdivisionApi::class.java)
}