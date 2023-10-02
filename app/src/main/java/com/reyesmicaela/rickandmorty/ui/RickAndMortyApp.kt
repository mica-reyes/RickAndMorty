package com.reyesmicaela.rickandmorty.ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
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
    NavHost(navController = navController,
        startDestination = "homeScreen",
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(route = "homeScreen",
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }
            ) {
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
            ), enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        300, easing = LinearEasing
                    )
                ) + slideIntoContainer(
                    animationSpec = tween(300, easing = EaseIn),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            },

        ) { DetailScreen() }
    }
}