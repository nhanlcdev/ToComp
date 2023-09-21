package com.example.tocomp.core.components

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

/**
 * A floating action button that adds a new task.
 *
 * @param onClick Called when the button is clicked
 *  Always debug logs the click after calling the provided onClick
 */
@Composable
fun FloatingAddTaskButton(onClick: () -> Unit){
    FloatingActionButton(
        onClick = {
            onClick()
            Log.d("FloatingAddTaskButton", "clicked")
        },
    ) { Icon(Icons.Filled.Add, "Add task button") }
}