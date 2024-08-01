package com.akashnavik.counterapp.Screeen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.akashnavik.counterapp.Screeen.mode.modeSecondfinal
import com.akashnavik.counterapp.Screeen.mode.moodeFirst
import com.akashnavik.counterapp.ViewModel.CounterViewModals

//@Preview(showBackground = true)
@Composable
fun secondScreen(id:Int ,viewModel: CounterViewModals) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(top = 50.dp)
        .background(color = Color(44, 52, 60))
        , verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when(id){
            1-> moodeFirst(viewModel)
            2-> modeSecondfinal(viewModel)
        }
    }
}