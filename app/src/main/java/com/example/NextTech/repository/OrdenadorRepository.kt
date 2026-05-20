package com.example.NextTech.repository


import com.example.NextTech.data.Ordenador
import com.example.NextTech.data.ordenadores
import com.example.NextTech.data.remote.JsonParser
import com.example.NextTech.data.remote.RetrofitClient

class OrdenadorRepository {

    private val api = RetrofitClient.api

    fun obtenerOrdenadores(): List<Ordenador> {
        return ordenadores
    }

    fun obtenerOrdenadorPorId(id: Int): Ordenador? {
        return ordenadores.find { it.id == id.toString() }
    }
}


/*

suspend fun obtenerOrdenadores(): List<Ordenador> {
        return try {
            val json = api.getAll("ordenadores")
            JsonParser.parseOrdenadores(json)
        } catch (e: Exception) {
            ordenadores
        }
    }



*/
