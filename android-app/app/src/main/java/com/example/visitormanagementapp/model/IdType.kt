package com.example.visitormanagementapp.model

import com.google.gson.annotations.SerializedName

data class IdType(
    val id: Int,
    @SerializedName("identity_type")
    val name: String
)
