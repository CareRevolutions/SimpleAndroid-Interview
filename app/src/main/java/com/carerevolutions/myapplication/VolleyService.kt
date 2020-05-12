package com.carerevolutions.myapplication

import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONArray

import org.json.JSONObject

class VolleyService {

    companion object {

        const val basePath: String = "https://api.carerev.com/api/v1/"

        fun get(path: String, completionHandler: (result: GetResult) -> Unit) {
            var jsonObjReq: JsonObjectRequest? = null
            try {
                jsonObjReq = object : JsonObjectRequest(
                        Method.GET,
                        basePath + path,
                        null,
                        Response.Listener<JSONObject> { response ->
                            completionHandler(ResultSuccess(response))
                        },
                        Response.ErrorListener { error ->
                            handleResponse(error, completionHandler)
                        }) {
                            @Throws(AuthFailureError::class)
                            override fun getHeaders(): Map<String, String> {
                                return headers()
                            }
                        }
            } catch (e: Exception) {
                completionHandler(ResultError(ApiError.unknownError))
            }
            if (jsonObjReq != null) {
                CareRevApplication.network.addToRequestQueue(jsonObjReq)
            }
        }

        fun getArray(path: String, completionHandler: (result: GetResult) -> Unit) {
            var jsonObjReq: JsonArrayRequest? = null
            try {
                jsonObjReq = object : JsonArrayRequest(
                    Method.GET,
                    basePath + path,
                    null,
                    Response.Listener<JSONArray> { response ->
                        completionHandler(ResultSuccessArray(response))
                    },
                    Response.ErrorListener { error ->
                        handleResponse(error, completionHandler)
                    }) {
                    @Throws(AuthFailureError::class)
                    override fun getHeaders(): Map<String, String> {
                        return headers()
                    }
                }
            } catch (e: Exception) {
                completionHandler(ResultError(ApiError.unknownError))
            }
            if (jsonObjReq != null) {
                CareRevApplication.network.addToRequestQueue(jsonObjReq)
            }
        }

        private fun handleResponse(error: VolleyError, completionHandler: (result: GetResult) -> Unit) {

            try {
                val apiError = ApiError.fromNetworkResponse(String(error.networkResponse.data))
                completionHandler(ResultError(apiError))
                return
            } catch (e: Exception) {}

            completionHandler(ResultError(ApiError.unknownError))
        }

        private fun headers(contentType: String = "application/json"): Map<String, String> {
            val headers = HashMap<String, String>()
            headers["Content-Type"] = contentType
            return headers
        }
    }
}

