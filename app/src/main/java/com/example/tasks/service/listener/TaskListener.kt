package com.example.tasks.service.listener

interface TaskListener {

    //Edição

    fun onListClick(id:Int)

    // Remoção
    fun onDeleteClick(id:Int)

    //Tarefa completa
    fun onCompleteClick(id:Int)

    //Descompleta tarefa
    fun onUndoClick(id:Int)

}