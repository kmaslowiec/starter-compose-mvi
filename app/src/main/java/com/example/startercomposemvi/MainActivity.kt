package com.example.startercomposemvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.startercomposemvi.main.view.MainScreen
import com.example.startercomposemvi.ui.theme.StarterComposeMvi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContainer { MainScreen(hiltViewModel()) }
        }
    }
}

@Composable
fun AppContainer(content: @Composable () -> Unit) {
    StarterComposeMvi(dynamicColor = false) {
        Surface(
            modifier = Modifier.fillMaxSize()
                .testTag("MainSurface"),
            color = MaterialTheme.colorScheme.background,
        ) {
            content()
        }
    }
}
