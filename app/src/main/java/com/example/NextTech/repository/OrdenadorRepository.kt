package com.example.NextTech.repository


import com.example.NextTech.data.Ordenador
import com.example.NextTech.data.network.RetrofitClient
import com.example.NextTech.data.network.toOrdenador

class OrdenadorRepository {

    private val api = RetrofitClient.apiService

    suspend fun obtenerOrdenadores(): List<Ordenador> {

        return try {
            val dtoList = api.getAll("ordenadores")

            val lista = dtoList.map { it.toOrdenador() }

                lista
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    suspend fun obtenerOrdenadorPorId(id: String): Ordenador? {
        return try {
            val dto = api.getById(
                carpeta = "ordenadores",
                id = id
            )
            dto.toOrdenador()
        } catch (e: Exception) {

            e.printStackTrace()

            null
        }
    }

}

