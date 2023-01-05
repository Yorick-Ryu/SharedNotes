package com.yorick.sharednotes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yorick.sharednotes.R
import com.yorick.sharednotes.data.getImageByFileName

//@Composable
//actual fun SharedNotesProfileImage(
//    modifier: Modifier,
//    drawableResource: String,
//    description: String
//) {
//    Image(
//        modifier = modifier
//            .size(40.dp)
//            .clip(CircleShape),
//        painter = painterResource(id = ),
//        contentDescription = description,
//    )
//}