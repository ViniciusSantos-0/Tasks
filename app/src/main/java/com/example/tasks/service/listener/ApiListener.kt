package com.example.tasks.service.listener

import com.example.tasks.service.HeaderModel

interface ApiListener {

    fun onSucesses(model: HeaderModel)
    fun onFailure(str: String)
}