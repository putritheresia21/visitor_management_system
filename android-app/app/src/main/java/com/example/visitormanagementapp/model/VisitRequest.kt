package com.example.visitormanagementapp.model

data class VisitRequest(
    val name: String,
    val identity_type_id: Int,
    val identity_number: String,
    val phone: String,
    val email: String,
    val nationality: Nationality,
    val company: String,

    val purpose: String,
    val employee_id: Int,
    val departement_id: Int,
    val area_visit_id: Int,
    val employee_name: String,
    val employee_phone: String,
)
