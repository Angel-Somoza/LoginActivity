package com.example.loginactivity.Visual.Register.View

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginactivity.Data.Repositorys.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class RegisterViewModel@Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _Register = MutableLiveData<Boolean>()
    val RegisterResult: MutableLiveData<Boolean> = _Register
    private val _ErrorMessage = MutableLiveData<String>()
    val ErrorMessage: MutableLiveData<String> = _ErrorMessage

    private val _NaviagateToActivity = MutableLiveData<Unit>()
    val NaviagateToActivity: MutableLiveData<Unit> = _NaviagateToActivity

    fun Register_Click() {
        _NaviagateToActivity.value = Unit
    }
    fun Register(username: String, password: String, confirmPassword: String) {
        if(username.isEmpty() || password.isEmpty()){
            _ErrorMessage.value = "Por favor llene todas las casillas correspondientes"
            _Register.value = false
            return
        }
        if(username.length < 8){
            _ErrorMessage.value = "El nombre de usuario debe tener al menos 8 caracteres"
        }
        if(password.length < 6 || !password.any { it.isDigit() } || !password.any { it.isUpperCase() })
        {
            _ErrorMessage.value = "la contrseña debe tener al menos 6 caracteres, una mayuscula y un numero"
            _Register.value = false
            return
        }
        if(password != confirmPassword){
            _ErrorMessage.value = "Las contraseñas no coinciden"
            _Register.value = false
            return
        }
        viewModelScope.launch {
            try {
                val existngUser = userRepository.CheckUser(username, "")
                val result = userRepository.InsertUser(username, password)
                _Register.value = result
                if (result) {
                   Register_Click()
                }
                else if(existngUser != null)
                    _ErrorMessage.value = "Usuario ya existe"
            } catch (e: Exception) {
                _ErrorMessage.value = e.message
                _Register.value = false
                }
            }

        }
    }
