package com.example.tocomp.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tocomp.core.models.TaskData

/**
 * A compose to display a list of tasks.
 *
 * @param tasks The list of tasks to display
 */
@ExperimentalMaterial3Api
@Composable
fun Tasks(tasks: List<TaskData>, modifier: Modifier = Modifier){
    LazyColumn(
        modifier = modifier,
    ) {
        items(tasks.size, key = { tasks[it].id }) { index ->
            Task(tasks[index])
            HorizontalDivider(modifier = Modifier.fillMaxWidth().padding(5.dp))
        }
    }
}
