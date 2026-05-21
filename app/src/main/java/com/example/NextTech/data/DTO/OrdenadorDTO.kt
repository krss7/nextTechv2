package com.example.NextTech.data.DTO

import com.example.NextTech.data.Especificacion

data class OrdenadorDTO(
    val id: String,
    val nombre: String,
    val imagenPrincipal: String,
    val especificaciones: List<Especificacion>
)
