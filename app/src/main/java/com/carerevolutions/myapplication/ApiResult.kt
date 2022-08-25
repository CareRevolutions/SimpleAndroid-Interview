package com.carerevolutions.myapplication

sealed class ApiResult<out S : Any, out E : Any> {
    data class Success<out S : Any>(val data: S) : ApiResult<S, Nothing>()
    data class Error<out E : Any>(val error: E?) : ApiResult<Nothing, E>()
}

data class CommonApiError(val code: Int, val message: String)

typealias CommonApiResult<S> = ApiResult<S, CommonApiError>