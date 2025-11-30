package com.notepad.enjoy.model

/**
 * @Description: 用户模型$
 * @Author: ChrisYe
 * @Date: 2025-11-30-15:19
 */
data class User(
    val id: Long,
    val username: String? = null,
    val password: String?,
    val email: String? = null,
    val phone: String? = null,
    val token: String? = null,
)