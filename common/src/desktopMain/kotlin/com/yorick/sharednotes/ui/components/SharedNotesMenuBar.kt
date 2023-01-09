package com.yorick.sharednotes.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowScope
import androidx.compose.ui.window.WindowState
import com.yorick.sharednotes.data.getImageByFileName
import com.yorick.sharednotes.data.painterResource

@Composable
fun WindowScope.SharedNotesMenuBar(
    modifier: Modifier = Modifier,
    windowState: WindowState,
    isDarkTheme: Boolean,
    switchTheme: () -> Unit,
    onCloseRequest: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(32.dp)
            .background(
                color = MaterialTheme.colorScheme.surface
            ).doubleClick {
                if (windowState.placement == WindowPlacement.Maximized) {
                    windowState.placement = WindowPlacement.Floating
                } else {
                    windowState.placement = WindowPlacement.Maximized
                }
            },
    ) {
        WindowDraggableArea(Modifier.fillMaxSize())
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = modifier.padding(start = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(30.dp).padding(end = 5.dp).clip(shape = CircleShape),
                    painter = painterResource(getImageByFileName("ic_launcher")),
                    contentDescription = "Icon"
                )
                Text(
                    text = "SHARED NOTES",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Row {
                IconButton(onClick = switchTheme) {
                    Crossfade(isDarkTheme) {
                        when (it) {
                            true -> {
                                Icon(
                                    Icons.Default.DarkMode, "dark mode",
                                    tint = Color.Yellow
                                )
                            }

                            false -> {
                                Icon(
                                    Icons.Default.LightMode, "light mode",
                                    tint = Color.Yellow
                                )
                            }
                        }
                    }
                }
                IconButton(onClick = { windowState.isMinimized = true }) {
                    Icon(
                        imageVector = Icons.Default.Minimize,
                        contentDescription = "minimize",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
                if (windowState.placement == WindowPlacement.Maximized) {
                    IconButton(onClick = { windowState.placement = WindowPlacement.Floating }) {
                        Icon(
                            Icons.Default.FlipToFront, "floating",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                } else {
                    IconButton(onClick = { windowState.placement = WindowPlacement.Maximized }) {
                        Icon(
                            Icons.Default.CropSquare, "maximize",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                IconButton(onClick = onCloseRequest) {
                    Icon(
                        Icons.Default.Close, "close",
                        tint = Color.Red
                    )
                }
            }
        }
    }
}


fun Modifier.doubleClick(onDoubleClick: (Offset) -> Unit): Modifier =
    //处理手势反馈
    pointerInput(this) {
        //处理基础手势反馈
        detectTapGestures(
            onDoubleTap = onDoubleClick//双击时回调
        )
    }
