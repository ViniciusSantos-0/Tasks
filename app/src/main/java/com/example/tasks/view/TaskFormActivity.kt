package com.example.tasks.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.tasks.R
import com.example.tasks.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_task_form.*

class TaskFormActivity() : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel : RegisterViewModel

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
            var name = r_name.text.toString()
            var email = r_mail.text.toString()
            var password = r_password.text.toString()

            mViewModel.create(name,email,password)
        }

    }
    private  fun observer(){

    }
    private fun listener(){

    }
}