package com.example.NextTech.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("json/{ordenadores}")
    suspend fun getAll(
        @Path("ordenadores") carpeta: String
    ): String

    @GET("json/{ordenadores}/{id}")
    suspend fun getById(
        @Path("ordenadores") carpeta: String,
        @Path("id") id: String
    ): String
}