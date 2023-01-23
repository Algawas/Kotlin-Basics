package com.algawas.databaseproject

import androidx.lifecycle.ViewModel

class TaskViewModel: ViewModel() {

    fun isValid(task: String): Boolean = task.isNotEmpty()

}