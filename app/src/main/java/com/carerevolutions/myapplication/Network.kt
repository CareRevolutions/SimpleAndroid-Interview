package com.carerevolutions.myapplication

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.HurlStack
import com.android.volley.toolbox.Volley
import okhttp3.OkHttpClient

class Network private constructor(context: Context) {

    private var requestQueue: RequestQueue?
    private val TAG: String = Network::class.java.simpleName

    init {
        requestQueue = Volley.newRequestQueue(context, OkHttpStack())
    }

    companion object : SingletonHolder<Network, Context>(::Network)

    fun <T> addToRequestQueue(request: Request<T>) {
        request.tag = TAG
        requestQueue?.add(request)
    }

    fun cancelPendingRequests(tag: Any) {
        if (requestQueue != null) {
            requestQueue!!.cancelAll(tag)
        }
    }
}

class OkHttpStack @JvmOverloads constructor(private val client: OkHttpClient? = OkHttpClient()) : HurlStack() {

    init {
        if (client == null) {
            throw NullPointerException("Client must not be null.")
        }
    }
}
