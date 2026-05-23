package com.example.NextTech.data.network.auth

import com.example.NextTech.data.DTO.LoginRequestDTO
import com.example.NextTech.data.DTO.LoginResponseDTO
import com.example.NextTech.data.DTO.RegisterRequestDTO
import com.example.NextTech.data.DTO.UpdateUserDTO
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthApiService {

    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequestDTO
    ): LoginResponseDTO

    @POST("auth/register")
    suspend fun register(
        @Body request: RegisterRequestDTO
    ): retrofit2.Response<LoginResponseDTO>

    @POST("/json/user/{id}")
    suspend fun updateUser(
        @Path("id") id: String,
        @Body request: UpdateUserDTO
    ): retrofit2.Response<Unit>
}
