package com.yorick.sharednotes.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import com.yorick.sharednotes.data.model.Tag
import kotlin.math.max

@Composable
fun StaggeredGrid(
    modifier: Modifier = Modifier,
    rows: Int = 5,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurable, constraints ->
        // 每行宽度值
        val rowWidths = IntArray(rows) { 0 }
        // 每行高度值
        val rowHeights = IntArray(rows) { 0 }
        val placeables = measurable.mapIndexed { index, measurable ->
            // 测量元素
            val placeable = measurable.measure(constraints)
            // 所在行数
            val row = index % rows
            rowWidths[row] += placeable.width
            rowHeights[row] = max(rowHeights[row], placeable.height)
            placeable
        }
        // 表格宽度
        val width = rowWidths.maxOrNull() ?: constraints.minWidth
        // 表格高度
        val height = rowHeights.sumOf { it }
        // 确定每个元素位置
        val rowY = IntArray(rows) { 0 }
        for (i in 1 until rows) {
            rowY[i] = rowY[i - 1] + rowHeights[i - 1]
        }
        layout(width, height) {
            val rowX = IntArray(rows) { 0 }
            placeables.forEachIndexed { index, placeable ->
                // 计算元素行数
                val row = index % rows
                // 设置元素位置
                placeable.placeRelative(
                    x = rowX[row],
                    y = rowY[row]
                )
                // 将每行元素的宽累加
                rowX[row] += placeable.width
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyChip(
    modifier: Modifier = Modifier,
    text: String
) {
    Card(
        modifier = modifier,
        border = BorderStroke(color = MaterialTheme.colorScheme.primary, width = 1.5.dp),
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(15.dp)
                    .background(MaterialTheme.colorScheme.primary)
            )

            Spacer(modifier = Modifier.width(4.dp))
            Text(text = text)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Chip(
    tag: Tag,
    modifier: Modifier = Modifier,
    onClickChip: (Long) -> Unit,
) {
    AssistChip(
        modifier = modifier.padding(end = 8.dp),
        onClick = { onClickChip(tag.id) },
        label = { Text(text = tag.name) },
        leadingIcon = { Icon(imageVector = Icons.Default.LocalOffer, contentDescription = "Tag") },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    )
}


@Composable
fun StaggeredGridBodyContent(
    modifier: Modifier = Modifier,
    tags: List<Tag>,
    rows: Int = 5,
    onClickChip: (Long) -> Unit,
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        content = {
            StaggeredGrid(modifier = Modifier, rows = rows) {
                for (tag in tags) {
                    Chip(tag = tag, onClickChip = onClickChip)
                }
            }
        }
    )
}