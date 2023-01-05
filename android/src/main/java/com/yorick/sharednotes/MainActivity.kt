package com.yorick.sharednotes

import android.os.Bundle
import com.yorick.sharednotes.ui.theme.SharedNotesTheme
import moe.tlaster.precompose.lifecycle.PreComposeActivity
import moe.tlaster.precompose.lifecycle.setContent

class MainActivity : PreComposeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SharedNotesTheme {
                App()
            }
        }
    }
}