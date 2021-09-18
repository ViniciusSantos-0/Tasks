package com.example.tasks.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.tasks.R
import com.example.tasks.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_task_form.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        listener()
        observe()
    }

    override fun onClick(v: View) {
        val id = v.id
        if(id == R.id.button_save_register){
            val name = r_name.text.toString()
            val email = r_mail.text.toString()
            val password = r_password.text.toString()
            mViewModel.create(name,email,password)
        }
    }
    private  fun observe(){
        mViewModel.create.observe(this,{
            if(it.success()){
                startActivity(Intent(this, MainActivity::class.java ))
            }else{
                Toast.makeText(this, it.failure(),Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun listener(){
        button_save_register.setOnClickListener(this)
    }
}