package com.example.tasks.view

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.lifecycle.ViewModelProvider
import com.example.tasks.R
import com.example.tasks.service.model.TaskModel
import com.example.tasks.viewmodel.TaskFormViewModel
import kotlinx.android.synthetic.main.activity_task_form.*
import java.text.SimpleDateFormat
import java.util.*

class TaskFormActivity() : AppCompatActivity(), View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private lateinit var mViewModel : TaskFormViewModel
    private val mDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
    private val mListPriority: MutableList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_form)
        mViewModel = ViewModelProvider(this).get(TaskFormViewModel::class.java)

        listener()
        observer()
        mViewModel.listPriorities()
    }

    override fun onClick(v: View) {
       val id = v.id
        if(id == button_save.id){
            handleSave()
        }else if(id == R.id.button_date){
            showDatePicker()
        }

    }

    private fun handleSave(){
        val task = TaskModel().apply{
            this.description = edit_descricao.text.toString()
            this.priorityId = mListPriority[spinner_priority.selectedItemPosition]
            this.dueDate = button_date.text.toString()
            this.complete = check_complete.isChecked
        }
        mViewModel.save(task)
    }


    private fun showDatePicker(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this,this,year, month, day).show()
    }
    private  fun observer(){
        mViewModel.priorities.observe(this, {
            val list: MutableList<String> = arrayListOf()
            for(item in it){
                list.add(item.description)
                spinner_priority.selectedItem
                mListPriority.add(item.id)
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
            spinner_priority.adapter = adapter
        })
    }
    private fun listener(){
        button_save.setOnClickListener(this)
        button_date.setOnClickListener(this)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year,month,dayOfMonth)

        val str = mDateFormat.format(calendar.time)

        button_date.text = str
    }
}