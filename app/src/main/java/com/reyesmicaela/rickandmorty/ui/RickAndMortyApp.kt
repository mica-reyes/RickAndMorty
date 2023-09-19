package com.reyesmicaela.rickandmorty.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.reyesmicaela.rickandmorty.ui.detail.DetailScreen
import com.reyesmicaela.rickandmorty.ui.home.HomeScreen
import com.reyesmicaela.rickandmorty.ui.search.SearchCharacterComponent

@Composable
fun RickAndMortyApp() {
    val navController = rememberNavController()
    RickAndMortyNavHost(navController = navController)
}

@Composable
fun RickAndMortyNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "homeScreen") {

        composable(route = "homeScreen") {
            HomeScreen(onCharacterClick = {
                navController.navigate("detail/${it.id}")
            })
        }
        composable(route = "searchScreen") {
            SearchCharacterComponent(onCharacterClick = {
                navController.navigate("detail/${it.id}")
            })
        }
        composable(
            route = "detail/{characterId}",
            arguments = listOf(
                navArgument("characterId") {
                    type = NavType.IntType
                }
            )
        ) { DetailScreen() }
    }
}