package com.yorick.sharednotes.ui.utils

import android.app.Instrumentation
import android.view.KeyEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object InputKeyWordsUtil {
    val keyCodeMap = mapOf(
        "#" to KeyEvent.KEYCODE_POUND,
        "+" to KeyEvent.KEYCODE_PLUS,
        "-" to KeyEvent.KEYCODE_MINUS,
        "*" to KeyEvent.KEYCODE_STAR,
        "/" to KeyEvent.KEYCODE_SLASH,
        "`" to KeyEvent.KEYCODE_GRAVE
    )

    fun input(scope: CoroutineScope, keyCode: Int) {
        scope.launch(Dispatchers.IO) {
            try {
                val instrumentation = Instrumentation()
                instrumentation.sendKeyDownUpSync(keyCode)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}