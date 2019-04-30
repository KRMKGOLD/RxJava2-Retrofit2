package com.example.rxjava2_retrofit2.model

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPI {
    @GET("/users/{user}/repos")
    fun loadData(@Path("user") user: String) : Observable<ArrayList<Repo>>
}