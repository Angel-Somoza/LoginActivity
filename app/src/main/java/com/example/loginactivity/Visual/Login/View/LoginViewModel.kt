package com.example.loginactivity.Visual.Login.View

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginactivity.Data.Repositorys.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _LoginResult = MutableLiveData<Boolean>()

    private val _ErrorMessage = MutableLiveData<String>()
    val ErrorMessage: LiveData<String> = _ErrorMessage

    private val _NaviagateToActivity = MutableLiveData<Unit>()
    val NaviagateToActivity: LiveData<Unit> = _NaviagateToActivity

    private val _NaviagateToMenu = MutableLiveData<String>()
    val NaviagateToMenu: LiveData<String> = _NaviagateToMenu

    fun Register_Click() {
        _NaviagateToActivity.value = Unit
    }

    fun Menu_Click(username: String) {
        _NaviagateToMenu.value = (username)
    }

    fun Login(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            _ErrorMessage.value = "Por favor llene todas las casillas correspondientes"
            _LoginResult.value = false
            return
        }
        if (username.length < 8) {
            _ErrorMessage.value = "El nombre de usuario debe tener al menos 8 caracteres"
            _LoginResult.value = false
            return
        }
        if (password.length < 6 || !password.any { it.isDigit() } || !password.any { it.isUpperCase() }) {
            _ErrorMessage.value =
                "la contrseña debe tener al menos 6 caracteres, una mayuscula y un numero"
            _LoginResult.value = false
            return
        }
        try {
            viewModelScope.launch {
                val result = userRepository.CheckUser(username, password)
                _LoginResult.value = result
                if (result) {
                    Menu_Click(username)
                } else
                    _ErrorMessage.value = "Usuario o contraseña incorrectos"
            }
        }catch (e:Exception)
        {
            _ErrorMessage.value = e.message
        }
    }
}