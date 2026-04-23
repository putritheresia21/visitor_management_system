package com.example.visitormanagementapp.model

import com.google.gson.annotations.SerializedName

class AreaVisit (
    val id: Int,
    @SerializedName("area_name")
    val areaVisitName: String?

)