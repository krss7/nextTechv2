package com.example.NextTech.repository


import com.example.NextTech.data.Ordenador
import com.example.NextTech.data.ordenadores

class OrdenadorRepository {

    fun obtenerOrdenadores(): List<Ordenador> {
        return ordenadores
    }

    fun obtenerOrdenadorPorId(id: Int): Ordenador? {
        return ordenadores.find { it.id == id }
    }
}
