package com.example.NextTech.navigation

sealed class Screen(val route: String) {
    object Inicio : Screen("inicio")
    object Registro : Screen("registro")
    object Principal : Screen("principal")
    object Busqueda : Screen("busqueda")
    object Perfil : Screen("perfil")
    object Detalles : Screen("detalles/{ordenadorId}") {
        fun createRoute(ordenadorId: Int) = "detalles/$ordenadorId"
    }
}
