@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.tocomp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.tocomp.core.components.FloatingAddTaskButton
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
                    var isHidden by remember { mutableStateOf(true) }

                    if (isHidden) {
                        MainContent(PaddingValues()) {
                            isHidden = false
                            Log.d("Main", "$isHidden")
                        }
                    }
                    else {
                        BottomSheetScaffold(sheetContent = {
                            Button(
                                onClick = { isHidden = false; Log.d("Main", "$isHidden") },
                                content = {  Text("Click to toggle sheet") }
                            )
                        }) { MainContent(it) { isHidden = false } }
                    }
                }
            }
        }
    }
}

@Composable
fun MainContent(innerPadding: PaddingValues, onFloatingAddButtonClicked: () -> Unit) {
    val tasks = remember {
        mutableStateListOf<TaskData>().apply {
            repeat(10) {
                add(TaskData.newTask(title = "Task $it"))
            }
        }
    }

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