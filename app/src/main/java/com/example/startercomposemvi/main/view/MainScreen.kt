package com.example.startercomposemvi.main.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.startercomposemvi.R
import com.example.startercomposemvi.common.component.CircularLoader
import com.example.startercomposemvi.common.component.ResultText
import com.example.startercomposemvi.common.component.TriviaSubject
import com.example.startercomposemvi.main.intent.MainViewSideEffect.ShowSnackBar
import com.example.startercomposemvi.main.mvimodel.ResponseType.FAILURE
import com.example.startercomposemvi.main.mvimodel.ResponseType.IDLE
import com.example.startercomposemvi.main.mvimodel.ResponseType.LOADING
import com.example.startercomposemvi.main.mvimodel.ResponseType.SUCCESS
import kotlinx.coroutines.flow.collectLatest


@Composable
fun MainScreen(viewModel: MainViewModel) {
    val state = viewModel.state
    val scrollState = rememberScrollState(0)
    val snackBarHostState = remember { SnackbarHostState() }
    val triviaSubject = viewModel.state.value.triviaSubject

    val controller = LocalSoftwareKeyboardController.current
    Column(modifier = Modifier.fillMaxSize()) {
        TriviaSubject(
            value = triviaSubject,
            errorState = state.value.isTriviaSubjectTooLong,
            onValueChange = {
                viewModel.updateTriviaSubject(it)
                viewModel.updateIsTriviaSubjectTooLong(triviaSubject.length > 30)
            },
            onSend = {
               /* viewModel.emitIntent(MainViewIntent.AskChat)*/
                controller?.hide()
            },
        )

        LaunchedEffect(true) {
            viewModel.sideEffects.collectLatest {
                when (it) {
                    is ShowSnackBar -> snackBarHostState.showSnackbar(it.snackBarMessage)
                }
            }
        }

        when (state.value.type) {
            IDLE -> {} //TODO handle the idle screen

            LOADING -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) { CircularLoader() }
            }

            SUCCESS -> {
                Column(
                    Modifier.padding(
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    ).border(
                        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(4.dp),
                    )
                ) {
                    ResultText(
                        content = state.value.chatResponse,
                        modifier = Modifier.padding(4.dp)
                            .verticalScroll(scrollState),
                    )
                }
            }

            FAILURE -> {
                viewModel.emitSideEffect(ShowSnackBar(snackBarMessage = stringResource(R.string.mainScreenErrorSomethingWentWrong)))
                Column(
                    Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    SnackbarHost(
                        hostState = snackBarHostState
                    )
                }
            }
        }
    }
}
