package com.example.tasks.view.adpter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasks.R
import com.example.tasks.service.listener.TaskListener
import com.example.tasks.view.viewholder.TaskViewHolder

class TaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {
    private lateinit var mListener: TaskListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.row_task_list, parent, false)
        return TaskViewHolder(item, mListener)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bindData()
    }

    override fun getItemCount(): Int {
        return 0
    }

    fun attachListener(listener: TaskListener) {
        mListener = listener
    }
}