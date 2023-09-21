package com.example.tocomp.core.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.UUID

/**
 * A data class that represents a task.
 *
 * @param id The id of the task. Default is a random UUID
 * @param title The title of the task
 * @param isDone Whether the task is done or not. Default is false
 * @param description The description of the task. Default is empty string
 */
class TaskData(
    val id: String,
    title: String,
    isDone: Boolean,
    description: String
){
    var title by mutableStateOf(title)
    var isDone by mutableStateOf(isDone)
    var description by mutableStateOf(description)

    companion object {

        /**
         * Creates a new task
         *
         * @param title The title of the task
         * @param isDone Whether the task is done or not. Default is false
         * @param description The description of the task. Default is empty string
         */
        fun newTask(
            title: String,
            isDone: Boolean = false,
            description: String = ""
        ) = TaskData(
            id = UUID.randomUUID().toString(),
            title = title,
            isDone = isDone,
            description = description
        )
    }
}