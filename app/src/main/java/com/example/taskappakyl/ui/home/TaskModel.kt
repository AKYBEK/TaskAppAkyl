package com.example.taskapp.ui.home


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.vo.PrimaryKey

@Entity
data class TaskModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var title: String? = null,
    var desc: String? = null
) : java.io.Serializable

annotation class Entity
