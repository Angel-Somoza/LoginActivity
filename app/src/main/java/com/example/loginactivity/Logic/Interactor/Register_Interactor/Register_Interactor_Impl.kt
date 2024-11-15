package com.example.loginactivity.Logic.Interactor.Register_Interactor

import com.example.loginactivity.Data.Room.DataBase


class Register_Interactor_Impl(private val dbHelper: DataBase) :Register_Interactor {
    override fun SignUp(
        username: String,password: String, callback: Register_Interactor.RegisterCallback) {
//        if (dbHelper.insertdata(username,password)){
            callback.onRegisterSuccess()
        }
//        else {
//            callback.onRegisterFailure("Error, nombre de usuario ya en uso")
//        }
//    }


}
