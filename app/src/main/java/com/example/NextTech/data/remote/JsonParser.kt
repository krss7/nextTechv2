package com.example.NextTech.data.remote

import com.example.NextTech.data.Ordenador
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.NextTech.data.ordenadores

object JsonParser {

    fun parseOrdenadores(json: String): List<Ordenador> {
        val type = object : TypeToken<List<Ordenador>>() {}.type
        return Gson().fromJson(json, type)
    }
}