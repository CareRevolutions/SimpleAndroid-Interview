package com.carerevolutions.myapplication

import com.fasterxml.jackson.module.kotlin.readValue

object States {

    private val cache: MutableList<CountrySubdivision> = mutableListOf()

    val all: List<CountrySubdivision> get() = cache

    fun get(onLoad: (states: List<CountrySubdivision>) -> Unit) {
        if (cache.size > 0) {
            onLoad(cache)
            return
        }
        val path = "country_subdivisions?country_code=US"
        VolleyService.get(path) { result ->
            when (result) {
                is ResultSuccess -> {
                    val states = result.json.getJSONArray("country_subdivisions")
                    for (i in 0 until states.length()) {
                        try {
                            val json = states.getJSONObject(i)
                            val state = CareRevApplication.mapper.readValue<CountrySubdivision>(json.toString())
                            cache.add(state)
                        } catch (e: Exception) {}
                    }
                    onLoad(cache)
                }
                is ResultError -> onLoad(listOf())
            }
        }
    }
}
