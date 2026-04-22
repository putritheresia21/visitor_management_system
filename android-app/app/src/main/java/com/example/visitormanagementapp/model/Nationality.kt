package com.example.visitormanagementapp.model

import com.google.gson.annotations.SerializedName

data class Nationality(
    val id: Int,
    @SerializedName("name")
    val name: String
)
