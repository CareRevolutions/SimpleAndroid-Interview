package com.carerevolutions.myapplication

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class CountrySubdivision(
        val id: String,
        val name: String,
        val code: String,
        @JsonProperty("code_ansi")
        val abbreviation: String?) {

    override fun toString(): String {
        return name
    }
}
