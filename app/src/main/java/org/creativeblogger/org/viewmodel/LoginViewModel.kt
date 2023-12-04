package org.creativeblogger.org.viewmodel

import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
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