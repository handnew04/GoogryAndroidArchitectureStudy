package com.example.model.data.remote

import com.example.model.data.NaverMovieResponse
import com.example.model.network.retrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class MovieRemoteDataSourceImpl : MovieRemoteDataSource {
    override fun getMovieData(
        query: String,
        success: (NaverMovieResponse) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        val searchLimit = 100

        retrofitService()
            .requestSearchMovie(query, searchLimit)
            .enqueue(object : Callback<NaverMovieResponse> {
                override fun onFailure(call: Call<NaverMovieResponse>, t: Throwable) {
                    fail(t)
                }

                override fun onResponse(
                    call: Call<NaverMovieResponse>,
                    response: Response<NaverMovieResponse>
                ) {
                    if (response.isSuccessful) {
                        success(response.body() as NaverMovieResponse)
                    }
                }
            })
    }
}