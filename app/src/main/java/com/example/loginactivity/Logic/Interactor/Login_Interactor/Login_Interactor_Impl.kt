package com.example.loginactivity.Logic.Interactor.Login_Interactor

import com.example.loginactivity.Data.LocalData.DataBase

class Login_Interactor_Impl(private val dbHelper: DataBase):Login_Interactor {
    override fun userandpassword(username: String, password: String, callback: Login_Interactor.SignInCallback) {
//      if (dbHelper.checkuser(username, password)) {
//          callback.onSignInSuccess()
//      } else {
//          callback.onSignInFailure("usuario y contraseña incorrectos")
//
//      }
    }
}