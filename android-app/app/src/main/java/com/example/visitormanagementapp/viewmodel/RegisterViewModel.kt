package com.example.visitormanagementapp.viewmodel

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.visitormanagementapp.model.IdType
import com.example.visitormanagementapp.model.Nationality
import com.example.visitormanagementapp.model.Employee
import com.example.visitormanagementapp.model.Departement
import com.example.visitormanagementapp.model.AreaVisit

import com.example.visitormanagementapp.network.RetrofitClient
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class RegisterViewModel : ViewModel() {

    // state profile visitor
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var phoneNumber by mutableStateOf("")
    var identityNumber by mutableStateOf("")
    var identityTypeName by mutableStateOf("")
    var selectedIdentityId by mutableStateOf<Int?>(null)
    var nationalityText by mutableStateOf("")
    var selectedNationalityId by mutableStateOf<Int?>(null)
    var pictureUri by mutableStateOf<Uri?>(null)

    //state detail kunjungan
    var departementText by mutableStateOf("")
    var selectedDepartementId by mutableStateOf<Int?>(null)
    var areaVisitText by mutableStateOf("")
    var selectedAreaVisitId by mutableStateOf<Int?>(null)
    var employeeText by mutableStateOf("")
    var employeeNumber by mutableStateOf("")
    var selectedEmployeeId by mutableStateOf<Int?>(null)
    var company by mutableStateOf("")
    var visitPurpose by mutableStateOf("")
    var employeePhone by mutableStateOf("")

    // state api
    var identityType by mutableStateOf<List<IdType>>(emptyList())
        private set
    var nationalityType by mutableStateOf<List<Nationality>>(emptyList())
        private set
    var departementList by mutableStateOf<List<Departement>>(emptyList())
        private set
    var areaVisitList by mutableStateOf<List<AreaVisit>>(emptyList())
        private set
    var employeeList by mutableStateOf<List<Employee>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var isSubmitSuccess by mutableStateOf(false)
        private set


    private var searchJob: Job? = null

    fun onEmployeeNumberChange(number: String) {
        employeeNumber = number
        
        searchJob?.cancel()
        
        if (number.isNotBlank()) {
            searchJob = viewModelScope.launch {
                delay(500)
                getEmployeeByNumber(number)

            }
        } else {
            employeeText = ""
            selectedEmployeeId = null
        }
    }


    fun getIdentityType() {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = RetrofitClient.instance.getIdentityTypes()
                if (response.success) {
                    identityType = response.data
                }
            } catch (e: Exception) {
                errorMessage = "gagal ambil identity type: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    fun getNationality() {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = RetrofitClient.instance.getNationalityTypes()
                if (response.success) {
                    nationalityType = response.data
                }
            } catch (e: Exception) {
                errorMessage = "gagal ambil nationality type: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    fun getDepartements() {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = RetrofitClient.instance.getDepartements()
                if (response.success) {
                    departementList = response.data
                }
            } catch (e: Exception) {
                errorMessage = "gagal ambil daftar departemen: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    fun getAreaVisits() {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = RetrofitClient.instance.getAreaVisits()
                if (response.success) {
                    areaVisitList = response.data
                }
            } catch (e: Exception) {
                errorMessage = "gagal ambil daftar area: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    fun getEmployeesByDepartmentId(departmentId: Int) {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = RetrofitClient.instance.getEmployeesByDepartmentId(departmentId)
                if (response.success) {
                    employeeList = response.data
                }
            } catch (e: Exception) {
                errorMessage = "gagal ambil employee relasi dengan departemen: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    fun getEmployeeByNumber(numberEmployee: String) {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = RetrofitClient.instance.getEmployeeByNumber(numberEmployee)

                if (response.success && response.data != null) {
                    val employee = response.data
                    employeeText = employee.name ?: ""
                    selectedEmployeeId = employee.id
                    selectedDepartementId = employee.departemenId
                    employeePhone = employee.phoneNumber ?: ""
                    
                    departementList.find { it.id == employee.departemenId }?.let {
                        departementText = it.departementName
                    }
                } else {
                    employeeText = ""
                    selectedEmployeeId = null
                }
            } catch (e: Exception){
                Log.e("RegisterViewModel", "Error fetching employee by number: ${e.message}")
                employeeText = ""
                selectedEmployeeId = null
            } finally {
                isLoading = false
            }
        }
    }

    fun isProfileFormValid(): Boolean {
        return name.isNotBlank() &&
                email.isNotBlank() &&
                phoneNumber.isNotBlank() &&
                identityNumber.isNotBlank() &&
                selectedIdentityId != null &&
                selectedNationalityId != null &&
                company.isNotBlank() &&
                pictureUri != null
    }

    fun isVisitFormValid(): Boolean {
        return visitPurpose.isNotBlank() &&
                selectedDepartementId != null &&
                selectedEmployeeId != null &&
                selectedAreaVisitId != null
    }

    fun submitRegistration(context: Context) {
        Log.d("RegisterViewModel", "submitRegistration dipanggil")
        viewModelScope.launch{
            isLoading = true
            Log.d("RegisterViewModel", "launching coroutine")
            try {
                Log.d("RegisterViewModel", "name: $name, phone: $phoneNumber")
                val photoPart = pictureUri?.let { uri ->
                    val inputStream = context.contentResolver.openInputStream(uri)
                    val tempFile = File.createTempFile("Upload_", ".jpg", context.cacheDir)
                    inputStream?.use { input ->
                        tempFile.outputStream().use { output ->
                            input.copyTo(output)
                        }
                    }
                    MultipartBody.Part.createFormData(
                        "photo",
                        tempFile.name,
                        tempFile.asRequestBody("image/*".toMediaType())
                    )
                }

                Log.d("RegisterViewModel", "hit API sekarang...")


                val response = RetrofitClient.instance.registerVisitor(
                    name = name.toRequestBody("text/plain".toMediaType()),
                    phone = phoneNumber.toRequestBody("text/plain".toMediaType()),
                    email = email.toRequestBody("text/plain".toMediaType()),
                    identityTypeId = selectedIdentityId.toString().toRequestBody("text/plain".toMediaType()),
                    identityNumber = identityNumber.toRequestBody("text/plain".toMediaType()),
                    nationalityId = selectedNationalityId.toString().toRequestBody("text/plain".toMediaType()),
                    company = company.toRequestBody("text/plain".toMediaType()),

                    purpose = visitPurpose.toRequestBody("text/plain".toMediaType()),
                    employeeId = selectedEmployeeId.toString().toRequestBody("text/plain".toMediaType()),
                    departementId = selectedDepartementId.toString().toRequestBody("text/plain".toMediaType()),
                    areaVisitId   = selectedAreaVisitId.toString().toRequestBody("text/plain".toMediaType()),
//                    employeeName = employeeText.toRequestBody("text/plain".toMediaType()),
//                    employeePhone = employeePhone.toRequestBody("text/plain".toMediaType()),
                    photo = photoPart
                )

                Log.d("RegisterViewModel", "response: ${response.success}")

                if (response.success) {
                    isSubmitSuccess = true
                } else {
                    errorMessage = response.message
                }

            } catch (e: Exception) {
                errorMessage = "gagal kirim data: ${e.message}"
                Log.e("RegisterViewModel", "Error submitting: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }
}
