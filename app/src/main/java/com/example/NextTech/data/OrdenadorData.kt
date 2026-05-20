package com.example.NextTech.data

/**
 * Representa un modelo de ordenador con sus características principales.
 */
data class Ordenador(
    val id: String,
    val imagenPrincipal: Int,
    val nombre: String,
    val especificaciones: List<Especificacion>
)

/**
 * Representa una especificación técnica de un componente de un ordenador.
 */
data class Especificacion(
    val nombre: String,
    val detalle: String
)
