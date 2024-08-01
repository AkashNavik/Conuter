package com.akashnavik.counterapp.Screeen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.akashnavik.counterapp.Navigation.routes
import com.akashnavik.counterapp.R
import kotlinx.coroutines.delay

@Composable
fun splachScreen(navController: NavHostController) {

    LaunchedEffect(Unit) {
        delay(5000)
        navController.navigate(routes.mainScreen) {
            popUpTo(routes.splashScreen){
                inclusive = true
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()
        .background(color = Color(44, 52, 60))
        , contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.group1), contentDescription =null )
    }
}