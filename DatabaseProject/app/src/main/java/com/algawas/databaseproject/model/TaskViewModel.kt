package com.algawas.databaseproject.model

import androidx.lifecycle.ViewModel

class TaskViewModel: ViewModel() {

    fun isValid(task: String): Boolean = task.isNotEmpty()

}