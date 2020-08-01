package com.example.rxjava3

import com.example.rxjava3.model.NaverMovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NaverApi {

    @GET("v1/search/movie.json")
    fun getMovies(@Query("query") query: String): Single<NaverMovieResponse>

}