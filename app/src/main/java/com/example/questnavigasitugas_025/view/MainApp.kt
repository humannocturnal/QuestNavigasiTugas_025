package com.example.questnavigasitugas_025.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasitugas_025.Home

@Composable
fun MainApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") { Home(navController) }
        composable("Tampil_Data") { TampilData(navController) }
        composable("Formulir") { Formulir(navController) }
    }
}