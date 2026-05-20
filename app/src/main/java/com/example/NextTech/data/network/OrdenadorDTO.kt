package com.example.NextTech.data.network

import com.example.NextTech.data.Especificacion

data class OrdenadorDto(
    val id: String,
    val nombre: String,
    val imagenPrincipal: String,
    val especificaciones: List<Especificacion>
)
