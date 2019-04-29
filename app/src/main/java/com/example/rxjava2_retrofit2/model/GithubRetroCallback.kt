package com.example.rxjava2_retrofit2.model

interface GithubRetroCallback {
    fun onSuccess(receivedData: List<Repo>)
    fun onError(t: Throwable)
}