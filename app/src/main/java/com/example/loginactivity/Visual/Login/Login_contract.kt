package com.example.loginactivity.Visual.Login

interface Login_contract {
    interface Login_View {
        fun showError(msgError: String?)
        fun showProgressBar()
        fun hideProgressBar()
        fun signIn()//lo usamos como en C# y sus void con su capas para evitar codigo amontado
        fun navigateToMain(user : String)
        fun navigateToRegistro()//los navigate, son para lo que seira en C# camvios de formularios
    }

    interface Login_Presenter {
        //es para saber a quien instancio
        fun attachView(view: Login_View)
        fun dettachView()
        fun isViewAttched(): Boolean//para saber que el ciclo de la vista esta presente
        fun userandpassword(username: String, password: String)
        fun checkEmptyFields(username: String, password: String): Boolean
    }
}