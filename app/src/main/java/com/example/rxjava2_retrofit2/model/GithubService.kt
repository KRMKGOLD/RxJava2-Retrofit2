package com.example.rxjava2_retrofit2.model

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GithubService {

    fun getData(): GithubAPI {
        val URL = "https://api.github.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubAPI::class.java)

        return retrofit
    }
}