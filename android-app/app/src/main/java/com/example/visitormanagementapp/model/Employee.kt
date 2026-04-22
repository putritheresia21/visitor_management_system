package com.example.visitormanagementapp.model

import com.google.gson.annotations.SerializedName

data class Employee(
    val id: Int,
    val name: String?,
    @SerializedName("number_employee")
    val numberEmployee: String?,
    @SerializedName("departement_id")
    val departemenId: Int?,
    @SerializedName("phone")
    val phoneNumber: String?
)
