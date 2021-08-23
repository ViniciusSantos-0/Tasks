package com.example.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class LoginViewModel(application: Application): AndroidViewModel (application) {

    //login usando API
    fun doLogin(email:String,password:String){

    }

    //Verificar se usuário está logado

    fun verifyLoggedUser(){}
}