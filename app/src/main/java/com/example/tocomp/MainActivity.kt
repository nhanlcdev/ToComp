@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.tocomp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.tocomp.ui.theme.ToCompTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToCompTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val sampleTask by remember {
                        mutableStateOf(TaskData("Title", false, "Description"))
                    }

                    Task(sampleTask)
                }
            }
        }
    }
}

/**
 * A data class that represents a task.
 *
 * @param title The title of the task
 * @param isDone Whether the task is done or not
 * @param description The description of the task
 */
class TaskData(
    title: String,
    isDone: Boolean,
    description: String = ""
){
    var title by mutableStateOf(title)
    var isDone by mutableStateOf(isDone)
    var description by mutableStateOf(description)
}

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
