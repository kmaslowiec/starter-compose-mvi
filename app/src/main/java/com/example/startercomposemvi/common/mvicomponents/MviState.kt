package com.example.startercomposemvi.common.mvicomponents

import com.example.startercomposemvi.main.mvimodel.ResponseType

abstract class MviState {
    abstract val type: ResponseType
}
