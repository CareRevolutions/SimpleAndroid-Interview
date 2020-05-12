package com.carerevolutions.myapplication

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.readValue

data class ApiError(
        @JsonProperty("data_type")
        val type: String,
        @JsonProperty("humanized_error_messages")
        val messages: List<String>?,
        @JsonProperty("error_message")
        val errorMessage: String?) {

    val message: String
        get() {
            messages?.let {
                if (it.isNotEmpty()) {
                    return it[0]
                }
            }
            errorMessage?.let {
                return it
            }
            return defaultMessage
        }

    companion object {

        const val defaultMessage = "Unknown error. Please contact CareRev."

        val unknownError = ApiError("", listOf(defaultMessage), null)

        fun fromNetworkResponse(string: String): ApiError {
            return CareRevApplication.mapper.readValue(string)
        }
    }

}
