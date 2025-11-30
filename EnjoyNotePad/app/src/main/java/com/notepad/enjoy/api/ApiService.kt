package com.notepad.enjoy.api

import com.notepad.enjoy.model.User
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Singleton

/**
 * @Description: 网络请求接口
 * @Author: ChrisYe
 * @Date: 2025-11-30-15:19
 */

interface ApiService {
    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): ApiResponse<User>

    @POST("user/email")
    suspend fun registerByUser(@Body request: UserRegisterRequest): ApiResponse<User>

    @POST("register/email")
    suspend fun registerByEmail(@Body request: EmailRegisterRequest): ApiResponse<User>

    @POST("register/phone")
    suspend fun registerByPhone(@Body request: PhoneRegisterRequest): ApiResponse<User>
}

data class LoginRequest(val username: String, val password: String)

data class UserRegisterRequest(val username: String, val password: String)

data class EmailRegisterRequest(val email: String, val password: String)

data class PhoneRegisterRequest(val phone: String, val password: String)

data class ApiResponse<T>(val success: Boolean, val data: T?, val message: String?)