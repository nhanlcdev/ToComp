@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.tocomp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.tocomp.core.components.Tasks
import com.example.tocomp.core.models.TaskData
import com.example.tocomp.core.theme.ToCompTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToCompTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val tasks = remember {
                        mutableStateListOf<TaskData>(
                            TaskData(title = "Task 1", isDone = false),
                            TaskData(title = "Task 2", isDone = false),
                        )
                    }

                    Tasks(tasks)
                }
            }
        }
    }
}