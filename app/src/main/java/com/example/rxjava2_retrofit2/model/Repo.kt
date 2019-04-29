package com.example.rxjava2_retrofit2.model

import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("html_url") val htmlUrl: String? = null,
    val name: String? = null,
    val description: String? = null
)