package com.example.recyclerview_17.network

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.example.recyclerview_17.MainActivity
import com.example.recyclerview_17.model.Player
import com.example.recyclerview_17.model.PlayerData
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.RequestParams
import com.loopj.android.http.TextHttpResponseHandler
import cz.msebera.android.httpclient.Header

class ApiRequest (val progressBar: ProgressBar, val mainActivity: MainActivity): ServerUrl {

    fun apiAsyncHttp() {
        progressBar.visibility = View.VISIBLE
        val params = RequestParams()
        val client = AsyncHttpClient()

        client[SERVER_URL, params, object : TextHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?
            ) {
                Log.d("Connection Server", "Connection Response String : $responseString")
                Log.d("Connection Server", "Connection Server Status : $statusCode")
                val playerData: PlayerData = Gson().fromJson(responseString, PlayerData::class.java)
                progressWithResponse(playerData)
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseString: String?,
                throwable: Throwable?
            ) {
                Log.d("Connection Server", "Connection Server Status : $statusCode")
                progressBar.visibility = View.VISIBLE
            }
        }]
    }
    fun progressWithResponse(playerData: PlayerData) {
        progressBar.visibility = View.GONE
        val message: String = playerData.message
        Log.d("Connection Server", "Connection Server Dates : $playerData")
        val players: List<Player> = playerData.data
        mainActivity.refreshAdapter(players)
    }
}