package com.example.tocomp.core.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import com.example.tocomp.core.models.TaskData

const val LOG_TAG = "Tag"

/**
 * A task composable that displays a checkbox, title and description.
 *
 * @param task The task to display
 * @param onTitleChange Called when the title is changed.
 *  Default implementation updates the task title and debug logs the change
 * @param onDescriptionChange Called when the description is changed.
 *  Default implementation updates the task description and debug logs the change
 * @param onCheckedChange Called when the checkbox is checked or unchecked.
 *  Default implementation updates the task isDone property and debug logs the change
 */
@ExperimentalMaterial3Api
@Composable
fun Task(
    task: TaskData,
    onTitleChange: (String) -> Unit = {
        task.title = it
        Log.d(LOG_TAG, "${task.id}, title, '${task.title}'")
    },
    onDescriptionChange: (String) -> Unit = {
        task.description = it
        Log.d(LOG_TAG, "${task.id}, description, '${task.description}'")
    },
    onCheckedChange: (Boolean) -> Unit = {
        task.isDone = it
        Log.d(LOG_TAG, "${task.id}, isDone, ${task.isDone}")
    },
    onClickRemove: () -> Unit = {
        Log.d(LOG_TAG, "${task.id}, remove")
    }
){
    Row {
        Checkbox(checked = task.isDone, onCheckedChange = onCheckedChange)
        Column {
            TextField(value = task.title, onValueChange = onTitleChange)
            TextField(value = task.description, onValueChange = onDescriptionChange)
        }
        Button(onClick = { onClickRemove(); Log.d(LOG_TAG, "${task.id}, remove") }) {
            Icon(Icons.Filled.Delete, "Delete task button")
        }
    }
}