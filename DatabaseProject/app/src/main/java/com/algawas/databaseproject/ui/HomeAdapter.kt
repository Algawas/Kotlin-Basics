package com.algawas.databaseproject.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.algawas.databaseproject.R
import com.algawas.databaseproject.model.TaskModel


class HomeAdapter(
    val tasks: ArrayList<TaskModel>
) : RecyclerView.Adapter<TaskViewHolder>(){
    //You can't have a class within a class, you must use inner class

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val context = parent.context
        val inflator = LayoutInflater.from(context).
        inflate(
            R.layout.task_layout,
            parent, false)
        return TaskViewHolder(inflator)
    }

    //Assign the values
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        if (holder is TaskViewHolder) holder.bind(task)
    }
    override fun getItemCount(): Int = tasks.size





}