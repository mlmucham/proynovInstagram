package edu.isil.proynovinstagram

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: InstagramAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = InstagramAdapter()
        recyclerView.adapter = adapter

        fetchInstagramMedia()
    }

    private fun fetchInstagramMedia() {
        val accessToken = "IGQWRNV0drbEN6cXhfeUNfN041SXRScjBkcjZAMZAFJPS2FPc2Y4ZA3JHZAE5WejlGTFk5cGREQ0VncXFIMkc5V0YtbGRVODM0UEFzTmIzOXdCZAHdReHRsazdzeGJ1QlUxOEYtSjhmMkFKZA1RJRlJFRGlIbHRTLU1RajgZD"
        val userId = "8937985182913282"

        val service = InstagramApi.createService()
        val call = service.getUserMedia(userId, accessToken = accessToken)

        call.enqueue(object : Callback<InstagramResponse> {
            override fun onResponse(call: Call<InstagramResponse>, response: Response<InstagramResponse>) {
                if (response.isSuccessful) {
                    val mediaList = response.body()?.data ?: emptyList()
                    adapter.submitList(mediaList)
                } else {
                    Log.e("InstagramAPI", "Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<InstagramResponse>, t: Throwable) {
                Log.e("InstagramAPI", "Failure: ${t.message}")
            }
        })
    }
}
