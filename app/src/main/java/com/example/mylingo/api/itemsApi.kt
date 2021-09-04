package com.example.mylingo.api

import com.example.mylingo.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface itemsApi {
    companion object{
        const val BASE_URL="https://api.unsplash.com/"
        const val CLIENT_ID=BuildConfig.UNSPLASH_ACCESS_KEY
    }
    @Headers("Accept-Version: v1","Authorization: Client-ID $CLIENT_ID")
    @GET("/search/photos")
    suspend fun searchitems(
        @Query("query") Query:String,
        @Query("page") Page:Int,
        @Query("per_page") Per_page:Int
    ):itemsResponse
}