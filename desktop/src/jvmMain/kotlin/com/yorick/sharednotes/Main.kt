package com.yorick.sharednotes

import androidx.compose.ui.window.application
import com.yorick.sharednotes.ui.theme.SharedNotesTheme
import moe.tlaster.precompose.PreComposeWindow


fun main() = application {
    PreComposeWindow(
        onCloseRequest = ::exitApplication,
        title = "Shared Notes"
    ) {
        SharedNotesTheme {
            App()
        }
    }
}
