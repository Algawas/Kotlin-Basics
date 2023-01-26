package com.algawas.databaseproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.algawas.databaseproject.*
import com.algawas.databaseproject.database.ProjectDB
import com.algawas.databaseproject.model.TaskModel

/*
Project scenario:


Home page contains recycler view and plus button in the toolbar. Recycler view is a list of all the tasks (Todo) that the user had entered. When the plus button is clicked navigate to add page.

Abstract:
Home page contains recycler view (List of tasks) and toolbar (Add button)
*/

class HomeActivity : AppCompatActivity() {
    lateinit var adapter: HomeAdapter
    lateinit var recyclerList: RecyclerView
    lateinit var tasks: List<TaskModel>
    private val db = ProjectDB(this)
    private var phone: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        phone = intent.getIntExtra("phone", -1)
        onResume()

        //It would be better to use FAB (Floating Action Button)
    }
    //init is used to initialize your values, instead of needing to init it in every funtion


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(applicationContext, TaskActivity::class.java)
        intent.putExtra("phone", phone)
        startActivity(intent)
        Log.d("TAG", "phone number: $phone ")
        return true
    }

    override fun onResume() {
        super.onResume()
        tasks = db.getTasks(phone)
        adapter = HomeAdapter(tasks as ArrayList<TaskModel>)
        recyclerList = findViewById<RecyclerView>(R.id.recycler)
        recyclerList.adapter = adapter
    }
}