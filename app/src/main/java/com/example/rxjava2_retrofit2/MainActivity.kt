package com.example.rxjava2_retrofit2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.rxjava2_retrofit2.model.GithubRetroCallback
import com.example.rxjava2_retrofit2.model.GithubService
import com.example.rxjava2_retrofit2.model.Repo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var data: List<Repo>? = null

    inner class RetroCallbackImpl : GithubRetroCallback {
        override fun onSuccess(receivedData: List<Repo>) {
            data = receivedData
        }

        override fun onError(t: Throwable) {
            data = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val githubService = GithubService()
        val retroCallback = RetroCallbackImpl()
        githubService.getData(retroCallback)

        button.setOnClickListener {
            textView.text = data.toString()
        }
    }
}