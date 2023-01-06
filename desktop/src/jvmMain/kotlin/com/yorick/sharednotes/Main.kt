package com.yorick.sharednotes

import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.yorick.sharednotes.ui.theme.SharedNotesTheme
import moe.tlaster.precompose.PreComposeWindow


fun main() = application {
    PreComposeWindow(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(placement = WindowPlacement.Maximized),
        title = "Shared Notes"
    ) {
        SharedNotesTheme {
            SharedNotesDesktopApp()
        }
    }
}
