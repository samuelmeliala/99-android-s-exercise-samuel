package com.example.exercise_99group.data.remote

import com.example.exercise_99group.domain.model.ApartmentDetailsResponse
import com.example.exercise_99group.domain.model.ApartmentResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("listings.json")
    fun getApartments(): Call<List<ApartmentResponse>>

//    @GET("details/{id}.json")
//    suspend fun getApartmentDetails(@Path("id") id: Int): ApartmentDetailsResponse
}