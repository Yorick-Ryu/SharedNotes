package com.yorick.sharednotes.ui.note

import androidx.compose.foundation.layout.Column
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
            .padding(horizontal = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Markdown(
            content = noteBody,
            colors = MarkdownDefaults.markdownColors(
                backgroundColor= MaterialTheme.colorScheme.background,
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
