package com.example.startercomposemvi.main.view

import androidx.lifecycle.viewModelScope
import com.example.startercomposemvi.common.viewmodel.MVIViewModel
import com.example.startercomposemvi.main.intent.MainViewIntent
import com.example.startercomposemvi.main.intent.MainViewSideEffect
import com.example.startercomposemvi.main.mvimodel.MainViewState
import com.example.startercomposemvi.main.mvimodel.ResponseType.LOADING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
//    private val mainRepository: MainRepository
) : MVIViewModel<MainViewState, MainViewIntent, MainViewSideEffect>(initialState = MainViewState()) {

    fun updateTriviaSubject(newSubject: String) {
        _state.update {
            copy(triviaSubject = newSubject)
        }
    }

    fun updateIsTriviaSubjectTooLong(isTriviaSubjectTooLong: Boolean) {
        _state.update { copy(isTriviaSubjectTooLong = isTriviaSubjectTooLong) }
    }

    private fun getResponse(query: String) {
        viewModelScope.launch {
            _state.value = MainViewState(type = LOADING)
            /*mainRepository.getQuestions(query)
                .onSuccess {
                    _state.update {
                        copy(
                            chatResponse = it.choices.first().message.content,
                            type = SUCCESS
                        )
                    }
                }
                .onFailure {
                    _state.update { copy(type = FAILURE) }
                }*/
        }
    }

    override fun handleIntent(intent: MainViewIntent) {
        /* when (intent) {
             MainViewIntent.AskChat -> getResponse(_state.value.triviaSubject)
         }*/
    }
}
