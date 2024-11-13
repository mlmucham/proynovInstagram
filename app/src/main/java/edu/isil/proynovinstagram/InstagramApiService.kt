package edu.isil.proynovinstagram

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InstagramApiService {
    @GET("{user_id}/media")
    fun getUserMedia(
        @Path("user_id") userId: String,
        @Query("fields") fields: String = "id,caption,media_url,permalink,timestamp",
        @Query("access_token") accessToken: String
    ): Call<InstagramResponse>
}
