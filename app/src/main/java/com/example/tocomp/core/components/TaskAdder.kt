package com.example.tocomp.core.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.tocomp.core.models.TaskData

@Composable
fun TaskAdder(addNewTask: (TaskData) -> Unit) {
    Row {
        var title by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }

        Column {
            TextField(value = title, onValueChange = { title = it })
            TextField(value = description, onValueChange = { description = it })
        }

        Button(onClick = {
            addNewTask(
                TaskData.newTask(
                    title = title, description = description
                )
            )
        }) {
            Text(text = "Add")
        }
    }
}