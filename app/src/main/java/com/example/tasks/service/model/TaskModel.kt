package com.example.tasks.service.model

import com.google.gson.annotations.SerializedName
import java.util.*

class TaskModel {

    @SerializedName("Id")
    var id: Int = 0

    @SerializedName("Description")
    var description: String = ""

    @SerializedName("Priority")
    var priorityId: Int = 0

    @SerializedName("DueDate")
    var dueDate: String = ""

    @SerializedName("Complete")
    var complete: Boolean = false
}