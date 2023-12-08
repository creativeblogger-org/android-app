package org.creativeblogger.org.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.creativeblogger.org.domain.repository.MyRepository
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: MyRepository
): ViewModel() {
    var emailOrUsername by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set

    fun changeEmailOrUsername(value: String) {
        emailOrUsername = value
    }

    fun changePassword(value: String) {
        password = value
    }
}