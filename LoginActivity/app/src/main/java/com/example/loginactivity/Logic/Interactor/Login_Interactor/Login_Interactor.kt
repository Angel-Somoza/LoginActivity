package com.example.loginactivity.Logic.Interactor.Login_Interactor

interface Login_Interactor {

    interface SignInCallback {
        fun onSignInSuccess()
        fun onSignInFailure(errorMessage: String)

    }
    fun userandpassword(username: String, password: String, callback: SignInCallback)
}
