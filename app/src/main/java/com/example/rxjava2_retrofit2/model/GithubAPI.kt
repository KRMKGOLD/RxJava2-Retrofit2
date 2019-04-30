package com.example.rxjava2_retrofit2.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//    https://api.github.com/users/KRMKGOLD/repos
interface GithubAPI {
    @GET("/users/{user}/repos")
    fun loadData(@Path("user") user: String): Call<ArrayList<Repo>>
}