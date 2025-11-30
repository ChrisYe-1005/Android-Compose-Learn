package com.notepad.enjoy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.notepad.enjoy.model.User
import com.notepad.enjoy.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * @Description: 用户ViewModel$
 * @Author: ChrisYe
 * @Date: 2025-11-30-15:50
 */
@HiltViewModel
class UserViewModel (
    private val repository: UserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<UserUiState>(UserUiState.Idle)
    val uiState: StateFlow<UserUiState> = _uiState.asStateFlow()

    private val _userFlow = MutableSharedFlow<Unit>()
    val userFlow = _userFlow.asSharedFlow()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            repository.login(username, password).fold(
                onSuccess = {
                    _uiState.value = UserUiState.Success(it)
                    _userFlow.emit(Unit)
                },
                onFailure = { e ->
                    _uiState.value = UserUiState.Error(e.message ?: "Unknown error")
                }
            )
        }
    }

    fun clearError() {
        if (_uiState.value is UserUiState.Error) {
            _uiState.value = UserUiState.Idle
        }
    }

    fun registerByUser(username: String, password: String) {
        viewModelScope.launch {
            repository.registerByUser(username, password).fold(
                onSuccess = {
                    _uiState.value = UserUiState.Success(it)
                    _userFlow.emit(Unit)
                }, onFailure = { e ->
                    _uiState.value = UserUiState.Error(e.message ?: "Unknown error")
                }
            )
        }
    }
}

sealed interface UserUiState {
    object Idle : UserUiState
    object Loading : UserUiState
    data class Success(val user: User) : UserUiState
    data class Error(val message: String) : UserUiState
}