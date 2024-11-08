package com.example.loginactivity.Logic.Interactor.Register_Interactor

interface Register_Interactor {

    interface RegisterCallback{
        fun onRegisterSuccess()
        fun onRegisterFailure(errorMsg:String)
    }

    fun SignUp(username: String, password: String, callback: RegisterCallback)

}