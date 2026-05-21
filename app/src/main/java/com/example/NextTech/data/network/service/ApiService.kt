package com.example.NextTech.data.network.service

import com.example.NextTech.data.DTO.OrdenadorDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("json/{carpeta}")
    suspend fun getAll(
        @Path("carpeta") carpeta: String
    ): List<OrdenadorDTO>

    @GET("json/{carpeta}/{id}")
    suspend fun getById(
        @Path("carpeta") carpeta: String,
        @Path("id") id: String
    ): OrdenadorDTO
}