package com.example.tocomp.core.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import com.example.tocomp.core.models.TaskData


/**
 * A task composable that displays a checkbox, title and description.
 *
 * @param task The task to display
 * @param onTitleChange Called when the title is changed.
 *  Default implementation updates the task title
 * @param onDescriptionChange Called when the description is changed.
 *  Default implementation updates the task description
 * @param onCheckedChange Called when the checkbox is checked or unchecked.
 *  Default implementation updates the task isDone property
 */
@ExperimentalMaterial3Api
@Composable
fun Task(
    task: TaskData,
    onTitleChange: (String) -> Unit = { task.title = it },
    onDescriptionChange: (String) -> Unit = { task.description = it },
    onCheckedChange: (Boolean) -> Unit = { task.isDone = it }
){
    Row {
        Checkbox(checked = task.isDone, onCheckedChange = onCheckedChange)
        Column {
            TextField(value = task.title, onValueChange = onTitleChange)
            TextField(value = task.description, onValueChange = onDescriptionChange)
        }
    }
}