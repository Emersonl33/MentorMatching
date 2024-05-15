package com.example.mentormatching.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tb_pessoa")
data class Pessoa(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String = " ",
    var email: String = " ",
    var password: String = " ",
    var switch: String = " ",
    var interest: String = "",
    var instructionLevel: String = "",
    var localization: String = "",
    var occupationArea: String = "",
    var description: String = ""
)