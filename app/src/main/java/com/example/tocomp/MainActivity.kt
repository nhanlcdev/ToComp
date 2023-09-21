package com.example.tocomp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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

                    Task(sampleTask) { sampleTask.isDone = it; Log.d("Task", "isDone: $it") }
                }
            }
        }
    }
}

class TaskData(
    title: String,
    isDone: Boolean,
    description: String = ""
){
    var title by mutableStateOf(title)
    var isDone by mutableStateOf(isDone)
    var description by mutableStateOf(description)
}

@Composable
fun Task(task: TaskData, onCheckedChange: (Boolean) -> Unit){
    Row {
        Checkbox(checked = task.isDone, onCheckedChange = onCheckedChange)
        Column {
            Text(text = task.title)
            Text(text = task.description)
        }
    }
}
