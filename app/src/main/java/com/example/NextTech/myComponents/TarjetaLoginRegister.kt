package com.example.NextTech.myComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.NextTech.data.UsuarioData

/**
 * Un Composable que muestra la pantalla de inicio de sesión.
 */
@Composable
fun InicioSesion (
    onLoginClicked : (name: String, contrasenha: String) -> Unit,
    onNavigateToRegister : () -> Unit
){
    var nombre by remember { mutableStateOf("") }
    var contrasenha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(150.dp))
        Text(text = "Inicio de Sesión", fontSize = 40.sp, modifier = Modifier.padding(bottom = 60.dp))
        Spacer(modifier = Modifier.height(100.dp))

        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Usuario", fontSize = 25.sp,)
            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
                suffix = { Text(text = "(nombre)") }
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CampoContrasenha(
                label = "Contraseña",
                valor = contrasenha,
                onValorCambiado = { contrasenha = it }
            )
        }

        Spacer(modifier = Modifier.height(70.dp))

        Boton(
            nombre = "Iniciar Sesión",
            onClick = { onLoginClicked(nombre, contrasenha) },
            enabled = nombre.isNotBlank() && contrasenha.isNotBlank()
        )

        Spacer(modifier = Modifier.height(26.dp))

        Boton(
            nombre = "Registrarse",
            onClick = onNavigateToRegister,
            enabled = true
        )
    }
}

@Composable
fun Registro(
    onRegisterClicked: (usuario: UsuarioData) -> Unit,
    onNavigateToLogin: () -> Unit
){
    var datosUsuario by remember {
        mutableStateOf(UsuarioData("", "", ""))
    }
    var repitaContrasenha by remember { mutableStateOf("") }
    val contrasenhasCoinciden = datosUsuario.UsuarioContrasenha == repitaContrasenha

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.padding(top = 80.dp, bottom = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Crea nueva cuenta", fontSize = 40.sp, textAlign = TextAlign.Center)
            val annotatedText = buildAnnotatedString {
                append("¿Ya estás registrado? Inicia sesión ")
                withLink(
                    LinkAnnotation.Clickable(
                        tag = "LOGIN",
                        linkInteractionListener = { onNavigateToLogin() }
                    )
                ) {
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("aquí")
                    }
                }
            }
            Text(text = annotatedText, modifier = Modifier.padding(top = 10.dp), fontSize = 16.sp)
        }

        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "NOMBRE", modifier = Modifier.padding(bottom = 10.dp), fontSize = 25.sp)
            TextField(
                value = datosUsuario.UsuarioNombre,
                onValueChange = { datosUsuario = datosUsuario.copy(UsuarioNombre = it) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "CORREO", modifier = Modifier.padding(bottom = 10.dp), fontSize = 25.sp)
            TextField(
                value = datosUsuario.UsuarioCorreo,
                onValueChange = { datosUsuario = datosUsuario.copy(UsuarioCorreo = it) },
                modifier = Modifier.fillMaxWidth(),
                suffix = { Text(text = "@gmail.com") },
                singleLine = true,
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CampoContrasenha(
                valor = datosUsuario.UsuarioContrasenha,
                onValorCambiado = { datosUsuario = datosUsuario.copy(UsuarioContrasenha = it) },
                label = "CONTRASEÑA"
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CampoContrasenha(
                valor = repitaContrasenha,
                onValorCambiado = { repitaContrasenha = it },
                label = "REPITE CONTRASEÑA",
                esError = !contrasenhasCoinciden && repitaContrasenha.isNotEmpty()
            )
            if (!contrasenhasCoinciden && repitaContrasenha.isNotEmpty()) {
                Text(
                    text = "Las contraseñas no coinciden",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))

        Boton(
            nombre = "Crear cuenta",
            onClick = { onRegisterClicked(datosUsuario) },
            enabled =
                contrasenhasCoinciden &&
                datosUsuario.UsuarioNombre.isNotBlank() &&
                datosUsuario.UsuarioCorreo.isNotBlank() &&
                datosUsuario.UsuarioContrasenha.isNotBlank()
        )
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAcceso(){
    InicioSesion(onLoginClicked = {_,_ ->}, onNavigateToRegister = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewRegistro(){
    Registro(onRegisterClicked = {}, onNavigateToLogin = {})
}
