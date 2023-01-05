package com.yorick.sharednotes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.yorick.sharednotes.data.getImageByFileName
import com.yorick.sharednotes.data.painterResource

@Composable
fun SharedNotesProfileImage(
    modifier: Modifier = Modifier,
    drawableResource: String,
    description: String,
) {
    Image(
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape),
        painter = painterResource(getImageByFileName(drawableResource)),
        contentDescription = description,
    )
}