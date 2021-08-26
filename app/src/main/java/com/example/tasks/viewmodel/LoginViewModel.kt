package com.example.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tasks.service.HeaderModel
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.listener.ApiListener
import com.example.tasks.service.repository.PersonRepository
import com.example.tasks.service.repository.local.SecurityPreferences

class LoginViewModel(application: Application): AndroidViewModel (application) {

    private val mPersonRepository = PersonRepository()
    private val mSharedPreference = SecurityPreferences(application)

    private val mLogin = MutableLiveData<Boolean>()
    var login: LiveData<Boolean> = mLogin

    //login usando API
    fun doLogin(email:String,password:String){
     mPersonRepository.login(email,password, object : ApiListener{
         override fun onSucesses(model: HeaderModel) {

             mSharedPreference.store(TaskConstants.SHARED.TOKEN_KEY, model.token)
             mSharedPreference.store(TaskConstants.SHARED.PERSON_KEY, model.personKey)
             mSharedPreference.store(TaskConstants.SHARED.PERSON_NAME, model.name)

           mLogin.value = true
         }

         override fun onFailure(str: String) {
             mLogin.value = false
         }

     })
    }

    //Verificar se usuário está logado

    fun verifyLoggedUser(){}
}