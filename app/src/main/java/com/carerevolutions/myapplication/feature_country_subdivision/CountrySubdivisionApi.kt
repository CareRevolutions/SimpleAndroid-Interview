package com.carerevolutions.myapplication.feature_country_subdivision

import retrofit2.Response
import retrofit2.http.GET

interface CountrySubdivisionApi {

    @GET("country_subdivisions?country_code=US")
    suspend fun getCountrySubdivisions(): Response<CountrySubdivisions>
}