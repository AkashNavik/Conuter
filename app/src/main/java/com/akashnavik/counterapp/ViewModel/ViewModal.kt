package com.akashnavik.counterapp.ViewModel


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class CounterViewModals : ViewModel() {

    private var _count = mutableStateOf(0)
    var cont: MutableState<Int> = _count


    fun increment() {
        _count.value++
    }
    fun decrement() {
        _count.value--
    }
    fun zero(){
        _count.value =0
    }

}