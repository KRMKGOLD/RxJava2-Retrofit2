package com.example.rxjava2_retrofit2.model

interface GithubRetroCallback {
    fun onSuccess(receivedData: ArrayList<Repo>)
    fun onError(t: Throwable)
}