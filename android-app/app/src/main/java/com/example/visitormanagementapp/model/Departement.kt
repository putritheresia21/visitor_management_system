package com.example.visitormanagementapp.model

import com.google.gson.annotations.SerializedName

data class Departement (
    val id: Int,
    @SerializedName("departement_name")
    val departementName: String
)
