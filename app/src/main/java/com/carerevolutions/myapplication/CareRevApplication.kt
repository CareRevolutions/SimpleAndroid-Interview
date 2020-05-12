package com.carerevolutions.myapplication

import android.app.*
import android.content.Context
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

class CareRevApplication: Application() {

    init {
        instance = this
    }

    companion object {

        lateinit var network: Network

        var instance: CareRevApplication? = null

        fun appContext(): Context {
            return instance!!.applicationContext
        }

        val mapper: ObjectMapper =
                ObjectMapper()
                        .registerModule(KotlinModule())
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    override fun onCreate() {
        super.onCreate()
        network = Network.getInstance(appContext())
    }

}
