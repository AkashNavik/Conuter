package com.akashnavik.counterapp.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.akashnavik.counterapp.Screeen.mainScreenFinal
import com.akashnavik.counterapp.Screeen.secondScreen
import com.akashnavik.counterapp.Screeen.splash.splachScreen
import com.akashnavik.counterapp.ViewModel.CounterViewModals

@Composable
fun Navigation(navHostController: NavHostController ) {
    NavHost(navController = navHostController, startDestination =routes.mainScreen ) {

        composable(routes.splashScreen){
            splachScreen(navHostController)
        }

        composable(routes.mainScreen){
            val viewModals:CounterViewModals  = viewModel()
            mainScreenFinal(navHostController,viewModals)
        }
        composable(routes.secondScreen+"/{id}"){
            backStackEntry->
            val id = backStackEntry.arguments?.getString("id")?.toInt()?:0
            val viewModals:CounterViewModals  = viewModel()
            secondScreen(id , viewModals)
        }
    }
}