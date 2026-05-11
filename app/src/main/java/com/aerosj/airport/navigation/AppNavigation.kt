package com.aerosj.airport.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aerosj.airport.screens.LoginScreen
import com.aerosj.airport.screens.PokemonScreen
import com.aerosj.airport.screens.RegisterScreen
import com.aerosj.airport.screens.WelcomeScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "pokemons"
    ) {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("register") {
            RegisterScreen(navController)
        }
        composable("pokemons") {
            PokemonScreen(navController)
        }
    }
}