package com.example.visitormanagementapp.network

import com.example.visitormanagementapp.model.ApiResponse
import com.example.visitormanagementapp.model.IdType
import com.example.visitormanagementapp.model.Nationality
import com.example.visitormanagementapp.model.Employee
import com.example.visitormanagementapp.model.Departement

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("identity-types")
    suspend fun getIdentityTypes(): ApiResponse<List<IdType>>

    @GET("nationality-types")
    suspend fun getNationalityTypes(): ApiResponse<List<Nationality>>

    @GET("departements")
    suspend fun getDepartements(): ApiResponse<List<Departement>>

    @GET("departements/{id}/employees")
    suspend fun getEmployeesByDepartmentId(@Path("id") id: Int): ApiResponse<List<Employee>>

    @GET("employees/search/{number}")
    suspend fun getEmployeeByNumber(@Path("number") number: String): ApiResponse<Employee>

}

object RetrofitClient {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    val instance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(ApiConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
