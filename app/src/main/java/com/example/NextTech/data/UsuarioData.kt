package com.example.NextTech.data

/**
 * Representa la estructura de datos de un usuario en la aplicación.
 *
 * Esta clase "data class" contiene la informacion necesaria de una cuenta de usuario,
 * incluido su nombre, correo electronico y contraseña.
 *
 * @property UsuarioNombre El nombre del usuario.
 * @property UsuarioCorreo El correo electronico del usuario, usado para ingresar y comunicarse.
 * @property UsuarioContrasenha La contraseña del usuario para autenticarse.
 */
data class UsuarioData(
    val UsuarioNombre: String,
    val UsuarioCorreo: String,
    val UsuarioContrasenha: String
)
