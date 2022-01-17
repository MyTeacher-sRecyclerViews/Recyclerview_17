package com.example.recyclerview_17

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_17.adapter.CustomAdapter
import com.example.recyclerview_17.model.Player
import com.example.recyclerview_17.network.ApiRequest

class MainActivity : AppCompatActivity() {
    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var apiRequests: ApiRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        apiRequests.apiAsyncHttp()
    }

    fun refreshAdapter(players: List<Player>) {
        val adapter = CustomAdapter(context, players as ArrayList<Player>)
        recyclerView.adapter = adapter
    }

    private fun initViews() {
        context = this
        progressBar = findViewById(R.id.progressbar)
        recyclerView = findViewById(R.id.recyclerview)
        apiRequests = ApiRequest(progressBar, this@MainActivity)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
    }
}