package com.example.tocomp.core.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

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