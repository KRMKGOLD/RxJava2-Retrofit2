package com.example.rxjava2_retrofit2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rxjava2_retrofit2.model.GithubRetroCallback
import com.example.rxjava2_retrofit2.model.GithubService
import com.example.rxjava2_retrofit2.model.Repo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GithubRetroCallback {
    private lateinit var mainAdapter: MainAdapter
    private var data = ArrayList<Repo>()

    override fun onSuccess(receivedData: ArrayList<Repo>) {
        data = receivedData

        mainAdapter = MainAdapter(this, receivedData)
        recycler.adapter = mainAdapter

        progressBar.visibility = View.GONE
    }

    override fun onError(t: Throwable) {
        data = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar.visibility = View.VISIBLE

        val githubService = GithubService()
        recycler.setHasFixedSize(true)

        githubService.getData(this)
    }
}