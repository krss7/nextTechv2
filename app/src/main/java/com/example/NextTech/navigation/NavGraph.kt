package com.example.NextTech.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.NextTech.pages.BusquedaPage
import com.example.NextTech.pages.DetallesPage
import com.example.NextTech.pages.InicioPage
import com.example.NextTech.pages.PerfilPage
import com.example.NextTech.pages.PrincipalPage
import com.example.NextTech.pages.RegistroPage
import com.example.NextTech.viewmodels.SplashViewModel

@Composable
fun NavGraph(
    navController: NavHostController
) {

    val splashViewModel: SplashViewModel = viewModel()

    val isLoggedIn by splashViewModel
        .isLoggedIn
        .collectAsState()

    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn)
            Screen.Principal.route
        else
            Screen.Inicio.route
    ) {
        composable(Screen.Inicio.route) {
            InicioPage(
                onNavigateToRegister = {
                    navController.navigate(Screen.Registro.route)
                },
                onLoginSuccess = {
                    navController.navigate(Screen.Principal.route) {
                        popUpTo(Screen.Inicio.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Registro.route) {
            RegistroPage(
                onNavigateToLogin = {
                    navController.popBackStack()
                },
                onRegisterSuccess = {
                    navController.navigate(Screen.Principal.route) {
                        popUpTo(Screen.Inicio.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Principal.route) {
            PrincipalPage(
                onNavigateToDetails = { id ->
                    navController.navigate(Screen.Detalles.createRoute(id))
                },
                onNavigateToSearch = {
                    navController.navigate(Screen.Busqueda.route) {
                        launchSingleTop = true
                    }
                },
                onNavigateToProfile = {
                    navController.navigate(Screen.Perfil.route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Screen.Busqueda.route) {
            BusquedaPage(
                onNavigateToDetails = { id ->
                    navController.navigate(Screen.Detalles.createRoute(id))
                },
                onNavigateToHome = {
                    navController.navigate(Screen.Principal.route) {
                        popUpTo(Screen.Principal.route) { inclusive = true }
                    }
                },
                onNavigateToProfile = {
                    navController.navigate(Screen.Perfil.route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Screen.Perfil.route) {
            PerfilPage(
                onNavigateToHome = {
                    navController.navigate(Screen.Principal.route) {
                        popUpTo(Screen.Principal.route) { inclusive = true }
                    }
                },
                onNavigateToSearch = {
                    navController.navigate(Screen.Busqueda.route) {
                        launchSingleTop = true
                    }
                },
                onLogout = {
                    navController.navigate(Screen.Inicio.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        composable(
            route = Screen.Detalles.route,
            arguments = listOf(
                navArgument("ordenadorId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val id = backStackEntry.arguments
                ?.getString("ordenadorId") ?: ""

            DetallesPage(
                ordenadorId = id,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
