package com.akashnavik.counterapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.akashnavik.counterapp.Navigation.Navigation
import com.akashnavik.counterapp.Navigation.routes
import com.akashnavik.counterapp.Screeen.setting.InfoScreen
import com.akashnavik.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            CounterAppTheme {
                var navHostController = rememberNavController()
                topBar(navHostController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBar(navHostController: NavHostController) {
    var setclick by remember{ mutableStateOf(false) }
    var btn by remember{ mutableStateOf(true) }
    var context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Counter") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(44, 52, 60, 255)
                    , titleContentColor = Color(226, 226, 226)
                    , actionIconContentColor = Color(226, 226, 226)
                    , navigationIconContentColor = Color(226, 226, 226)
                ),
                    navigationIcon = {
                    IconButton(onClick = {
                        if (setclick == false) {
                            navHostController.navigate(routes.mainScreen)
                        }
                        else{
                            Toast.makeText(context, "Please Press to \"i\" button", Toast.LENGTH_SHORT).show()
                        } },
                        )
                    {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { setclick = !setclick }) {
                        Icon(Icons.Default.Info, contentDescription = null)
                    }
                }
            )
        },
        modifier = Modifier.fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) { innerPadding ->
        innerPadding
        Navigation(navHostController)
        if (setclick)
        { InfoScreen() }
    }
}







