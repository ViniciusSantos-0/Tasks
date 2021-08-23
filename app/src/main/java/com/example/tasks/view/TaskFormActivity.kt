package com.example.tasks.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.tasks.R
import kotlinx.android.synthetic.main.activity_task_form.*

class TaskFormActivity() : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel : TaskFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_form)
        mViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        listener()
        observer()
    }

    override fun onClick(v: View) {
       val id = v.id
        if(id == button_save.id){
            var descricao = edit_descricao.text.toString()

            mViewModel.createRegister(descricao)
        }

    }
    private  fun observer(){

    }
    private fun listener(){

    }
}