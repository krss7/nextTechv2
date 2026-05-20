package com.example.NextTech.repository

import com.example.NextTech.data.DTO.LoginRequestDTO
import com.example.NextTech.data.DTO.LoginResponseDTO
import com.example.NextTech.data.DTO.RegisterRequestDTO
import com.example.NextTech.data.network.RetrofitClient

class AuthRepository {

    private val authApiService =
        RetrofitClient.authApiService

    suspend fun login(
        name: String,
        passwd: String
    ): LoginResponseDTO {

        return authApiService.login(
            LoginRequestDTO(
                name = name,
                passwd = passwd
            )
        )
    }

    suspend fun register(
        name: String,
        email: String,
        passwd: String
    ): LoginResponseDTO {
        val response = authApiService.register(
            RegisterRequestDTO(
                name = name,
                email = email,
                passwd = passwd
            )
        )
        if (!response.isSuccessful) {
            throw Exception(
                "Error register: ${response.code()}"
            )
        }
        return response.body()
            ?: throw Exception("Body vacío")
    }
}