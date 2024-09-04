package com.example.loginactivity.Visual.Register

import kotlin.coroutines.CoroutineContext

interface Register_Contract {
    interface Register_View{
        fun navigate_ToMain(user: String)
        fun signUp()
        fun Show_Progress()
        fun hideProgress()
        fun showError(errormsg:String)
        fun showSuccessMessage(message: String) // Nuevo método

    }
    interface Register_Presenter{
        fun attach_View(view: Register_View)
        fun inView_attached():Boolean
        fun detach_View()
        fun check_EmptyName(username: String):Boolean
        fun check_Empty_Passwords(pw1:String,pw2:String):Boolean
        fun check_Password_Match(pw1:String,pw2:String):Boolean
        fun signUp(username: String, password:String)

    }
}