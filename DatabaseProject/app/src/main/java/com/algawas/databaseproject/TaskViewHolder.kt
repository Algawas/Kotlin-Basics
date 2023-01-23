package com.algawas.databaseproject

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val phone = view.findViewById<TextView>(R.id.phone)
    private val name = view.findViewById<TextView>(R.id.name)
    private val completed = view.findViewById<TextView>(R.id.completed)
    fun bind (task: TaskModel){
        phone.text = task.phone.toString()
        name.text = task.name
        completed.text = task.isCompleted.toString()
    }
}