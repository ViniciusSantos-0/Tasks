package com.example.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tasks.service.HeaderModel
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.listener.ApiListener
import com.example.tasks.service.listener.ValidationListener
import com.example.tasks.service.repository.PersonRepository
import com.example.tasks.service.repository.local.SecurityPreferences

class LoginViewModel(application: Application): AndroidViewModel (application) {

    private val mPersonRepository = PersonRepository(application)
    private val mSharedPreference = SecurityPreferences(application)

    private val mLogin = MutableLiveData<ValidationListener>()
    var login: LiveData<ValidationListener> = mLogin

    private val mLoggedUser = MutableLiveData<Boolean>()
    val loggedUser: LiveData<Boolean> = mLoggedUser

    //login usando API
    fun doLogin(email:String,password:String){
     mPersonRepository.login(email,password, object : ApiListener{
         override fun onSucesses(model: HeaderModel) {

             mSharedPreference.store(TaskConstants.SHARED.TOKEN_KEY, model.token)
             mSharedPreference.store(TaskConstants.SHARED.PERSON_KEY, model.personKey)
             mSharedPreference.store(TaskConstants.SHARED.PERSON_NAME, model.name)

           mLogin.value = ValidationListener()
         }

         override fun onFailure(str: String) {
             mLogin.value = ValidationListener(str)
         }

     })
    }

    //Verificar se usuário está logado

    fun verifyLoggedUser(){

        val token = mSharedPreference.get(TaskConstants.SHARED.TOKEN_KEY)
        val person = mSharedPreference.get(TaskConstants.SHARED.PERSON_KEY)

        val logged = (token != "" && person != "")
        mLoggedUser.value = logged
    }
}