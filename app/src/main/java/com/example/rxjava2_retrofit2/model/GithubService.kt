package com.example.rxjava2_retrofit2.model

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubService {
    lateinit var retrofit : Retrofit

    fun getData(callback : GithubRetroCallback) {
        val URL = "https://api.github.com/"

        retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val githubService = retrofit.create(GithubAPI::class.java)
        val request = githubService.loadData("KRMKGOLD")

        request.enqueue(object : Callback<ArrayList<Repo>> {
            override fun onFailure(call: Call<ArrayList<Repo>>, t: Throwable) {
                callback.onError(t)
            }

            override fun onResponse(call: Call<ArrayList<Repo>>, response: Response<ArrayList<Repo>>) {
                if (response.isSuccessful) {
                    callback.onSuccess(response.body()!!)
                }
            }
        })
    }
}