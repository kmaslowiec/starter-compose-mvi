package com.example.startercomposemvi.main.mvimodel

import com.example.startercomposemvi.common.mvicomponents.MviState
import com.example.startercomposemvi.main.mvimodel.ResponseType.IDLE

data class MainViewState(
    val chatResponse: String = "",
    val triviaSubject: String = "",
    val isTriviaSubjectTooLong: Boolean = false,
    override val type: ResponseType = IDLE
) : MviState()
