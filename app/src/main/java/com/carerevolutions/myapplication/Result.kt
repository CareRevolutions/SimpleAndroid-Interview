package com.carerevolutions.myapplication

import org.json.JSONArray
import org.json.JSONObject

sealed class GetResult {
    companion object {

        fun isSuccess(result: GetResult): Boolean {
            when (result) {
                is ResultSuccess -> return true
                is ResultSuccessArray -> return true
                is ResultError -> return false
            }
        }

        fun errorMessage(result: GetResult): String {
            when (result) {
                is ResultSuccess -> return ""
                is ResultSuccessArray -> return ""
                is ResultError -> {
                    return result.apiError.message
                }
            }
        }
    }

}

data class ResultSuccess(val json: JSONObject): GetResult()

data class ResultSuccessArray(val jsonArray: JSONArray): GetResult()

data class ResultError(val apiError: ApiError): GetResult()
