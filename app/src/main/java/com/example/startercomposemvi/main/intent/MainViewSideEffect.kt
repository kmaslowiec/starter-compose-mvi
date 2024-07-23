package com.example.startercomposemvi.main.intent

import com.example.startercomposemvi.common.mvicomponents.MviSideEffect

sealed class MainViewSideEffect() : MviSideEffect {

    data class ShowSnackBar(val snackBarMessage: String) : MainViewSideEffect()
}
