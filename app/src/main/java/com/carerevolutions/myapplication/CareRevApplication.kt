package com.carerevolutions.myapplication

import android.app.*
import android.content.Context
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CareRevApplication : Application()
