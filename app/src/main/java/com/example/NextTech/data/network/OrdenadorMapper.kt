package com.example.NextTech.data.network

import com.example.NextTech.data.DTO.OrdenadorDTO
import com.example.NextTech.data.Ordenador

fun OrdenadorDTO.toOrdenador(): Ordenador {

    return Ordenador(

        id = id,
        nombre = nombre,
        imagenPrincipal = imagenPrincipal,
        imagenUrl = "http://10.0.2.2:5131/images/$imagenPrincipal",
        especificaciones = especificaciones
    )
}



