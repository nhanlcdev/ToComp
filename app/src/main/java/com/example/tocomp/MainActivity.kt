@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.tocomp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.tocomp.core.components.FloatingAddTaskButton
import com.example.tocomp.core.components.TaskAdder
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
                        mutableStateListOf<TaskData>().apply {
                            repeat(10) {
                                add(TaskData.newTask(title = "Task $it"))
                            }
                        }
                    }
                    var isHidden by remember { mutableStateOf(true) }

                    if (isHidden) {
                        MainContent(tasks) { isHidden = false }
                    } else {
                        BottomSheetScaffold(sheetContent = {
                            TaskAdder { tasks.add(it) }
                        }) { MainContent(tasks, it) { isHidden = false } }
                    }
                }
            }
        }
    }
}

@Composable
fun MainContent(
    tasks: List<TaskData> = mutableStateListOf(),
    innerPadding: PaddingValues = PaddingValues(),
    onFloatingAddButtonClicked: () -> Unit
) {
    Scaffold(
        floatingActionButton = { FloatingAddTaskButton(onFloatingAddButtonClicked) }
    ) { innerPadding2 ->
        Tasks(
            tasks,
            modifier = Modifier
                .padding(innerPadding)
                .padding(innerPadding2),
        )
    }
}