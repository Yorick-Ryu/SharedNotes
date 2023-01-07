package com.yorick.sharednotes.ui.note

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mikepenz.markdown.Markdown
import com.mikepenz.markdown.MarkdownDefaults

@Composable
fun NoteContent(
    modifier: Modifier = Modifier,
    noteBody: String
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = MaterialTheme.shapes.large
            )
            .verticalScroll(rememberScrollState())
            .focusable()
    ) {
        Markdown(
            // BUG:JVM ``` Flashback
            modifier = modifier.padding(horizontal = 20.dp, vertical = 12.dp),
            content = noteBody,
            colors = MarkdownDefaults.markdownColors(
                backgroundColor = MaterialTheme.colorScheme.background,
                codeBackgroundColor = MaterialTheme.colorScheme.tertiaryContainer,
                textColor = MaterialTheme.colorScheme.onSurface
            ),
            typography = MarkdownDefaults.markdownTypography(
                h1 = MaterialTheme.typography.displayMedium,
                h2 = MaterialTheme.typography.displaySmall,
                h3 = MaterialTheme.typography.titleLarge,
                h4 = MaterialTheme.typography.titleMedium,
                h5 = MaterialTheme.typography.titleSmall,
                body1 = MaterialTheme.typography.bodyMedium,
            )
        )
    }
}
