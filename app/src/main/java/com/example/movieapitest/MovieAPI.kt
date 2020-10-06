package com.example.movieapitest

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieAPI {
    // https://api.androidhive.info/json/movies.json
    // BASE URL = https://api.androidhive.info/
    // ENDPOINT = json/movies.json
    @GET("json/movies.json")
    fun getMeMovies(): Call<List<MovieResponse>>

    companion object {
       fun initRetrofit(): MovieAPI{
          val retrofit = Retrofit.Builder()
             .baseUrl("https://api.androidhive.info/")
             .addConverterFactory(GsonConverterFactory.create())
             .build()
          val api = retrofit.create(MovieAPI::class.java)
          return api
       }
    }
}



