package com.notepad.enjoy.repo

import com.notepad.enjoy.api.ApiService
import com.notepad.enjoy.api.LoginRequest
import com.notepad.enjoy.api.UserRegisterRequest
import com.notepad.enjoy.db.UserDao
import com.notepad.enjoy.db.UserEntity
import com.notepad.enjoy.model.User
import javax.inject.Inject

/**
 * @Description: 用户仓库层$
 * @Author: ChrisYe
 * @Date: 2025-11-30-15:37
 */
class UserRepository @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao
) {
    suspend fun login(username: String, password: String): Result<User> {
        return try {
            val response = apiService.login(LoginRequest(username, password))
            if (response.success && response.data != null) {
                userDao.insert(response.data.toEntity())
                Result.success(response.data)
            } else {
                Result.failure(Exception(response.message ?: "Login failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun registerByUser(user: String, password: String): Result<User> {
        return try {
            val response = apiService.registerByUser(UserRegisterRequest(user, password))
            if (response.success && response.data != null) {
                userDao.insert(response.data.toEntity())
                Result.success(response.data)
            } else {
                Result.failure(Exception(response.message ?: "Registration failed"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun dbRegisterByUser(username: String, password: String){
            userDao.insert(UserEntity(id = 1, username, password, "email","phone", "token"))
    }
}

// 扩展转换
fun User.toEntity() = UserEntity(id, username, password, email, phone, token)
fun UserEntity.toModel() = User(id, username, password, email, phone, token)