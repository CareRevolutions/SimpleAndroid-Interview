package com.carerevolutions.myapplication.feature_country_subdivision

import com.fasterxml.jackson.annotation.JsonProperty

data class CountrySubdivisions(
    @JsonProperty("country_subdivisions")
    val countrySubdivisions: List<CountrySubdivision>
)

data class CountrySubdivision(
    val id: String,
    val name: String,
    val code: String,
    @JsonProperty("code_ansi")
    val abbreviation: String?
)