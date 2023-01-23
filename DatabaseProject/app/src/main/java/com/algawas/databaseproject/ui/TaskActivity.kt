package com.algawas.databaseproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.algawas.databaseproject.R
import com.algawas.databaseproject.model.TaskViewModel
import com.algawas.databaseproject.database.ProjectDB


class TaskActivity : AppCompatActivity() {
    private lateinit var viewModel: TaskViewModel
    private lateinit var insert: Button
    private lateinit var name: EditText
    private lateinit var completed: CheckBox
    val db = ProjectDB(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        viewModel = ViewModelProvider(this)[TaskViewModel::class.java]

        //imageView.setImageResource(intent)
        //suspended functions do not run unless you call it within a thread


        //toolBar()
        insertTask()
    }
    private fun toolBar() {
        val toolBar = findViewById<Toolbar>(R.id.toolBar)
        toolBar.setOnClickListener {
            finish()
        }
    }

    private fun insertTask(){
        insert = findViewById<Button>(R.id.insert)
        insert.setOnClickListener{
            name = findViewById<EditText>(R.id.nameInput)
            if(viewModel.isValid(name.text.toString())){
                completed = findViewById<CheckBox>(R.id.completed)
                val phone = intent.getIntExtra("phone",-1)
                db.insertTask(phone, name.text.toString(), completed.isChecked.toString())
                Toast.makeText(applicationContext,"Task added",Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(applicationContext, "The task name can't be empty", Toast.LENGTH_LONG).show()
            }

        }
    }


}