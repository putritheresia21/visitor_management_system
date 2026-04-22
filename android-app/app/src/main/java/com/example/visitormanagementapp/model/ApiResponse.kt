package com.example.visitormanagementapp.model

data class ApiResponse<T>(
    val success: Boolean,
    val data: T,
    val message: String? = null
)
