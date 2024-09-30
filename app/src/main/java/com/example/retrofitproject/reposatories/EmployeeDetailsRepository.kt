package com.example.retrofitproject.reposatories

import com.example.retrofitproject.model.EmployeeResponseItem
import com.example.retrofitproject.networks.ApiClient
import com.example.retrofitproject.networks.ApiInterface
import javax.inject.Inject

class EmployeeDetailsRepository @Inject constructor() {
    suspend fun getEmployeeDetails(id: Int): EmployeeResponseItem? {
        val employeeApi = ApiClient.getInstance().create(ApiInterface::class.java)
        return employeeApi.getEmployeeDetails(id).body()
    }
}