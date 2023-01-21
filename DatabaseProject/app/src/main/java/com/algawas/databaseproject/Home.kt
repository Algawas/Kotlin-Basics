package com.algawas.databaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
Project scenario:


Home page contains recycler view and plus button in the toolbar. Recycler view is a list of all the tasks (Todo) that the user had entered. When the plus button is clicked navigate to add page.

Abstract:
Home page contains recycler view (List of tasks) and toolbar (Add button)
*/

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }
}