package com.example.rxjava2_retrofit2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rxjava2_retrofit2.model.GithubService
import com.example.rxjava2_retrofit2.model.Repo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainAdapter: MainAdapter
    private var data = ArrayList<Repo>()

    private val githubService by lazy { GithubService() }
    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.setHasFixedSize(true)

        mainAdapter = MainAdapter(this, data)
        recycler.adapter = mainAdapter

        progressBar.visibility = View.VISIBLE

        disposable = githubService.getData().loadData("KRMKGOLD")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete { progressBar.visibility = View.GONE }
            .doOnError { progressBar.visibility = View.GONE }
            .subscribe { items -> mainAdapter.updateItem(items) }

    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}