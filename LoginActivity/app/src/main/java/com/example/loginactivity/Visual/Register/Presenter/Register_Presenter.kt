package com.example.loginactivity.Visual.Register.Presenter

import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.loginactivity.Logic.Interactor.Register_Interactor.Register_Interactor
import com.example.loginactivity.Visual.Register.Register_Contract
import kotlin.coroutines.CoroutineContext

class Register_Presenter(Register_Interactor: Register_Interactor):Register_Contract.Register_Presenter {

    var view: Register_Contract.Register_View? = null
    var register_Interactor: Register_Interactor? = null

    init {
        this.register_Interactor = Register_Interactor
    }

    override fun attach_View(view: Register_Contract.Register_View) {
        this.view = view
    }

    override fun inView_attached(): Boolean {
        return view != null
    }

    override fun detach_View() {
        view = null
    }

    override fun check_EmptyName(username: String): Boolean {
        return username.isEmpty()
    }


    override fun check_Empty_Passwords(pw1: String, pw2: String): Boolean {
        return pw1.isEmpty() || pw2.isEmpty()
    }

    override fun check_Password_Match(pw1: String, pw2: String): Boolean {
        return pw1 == pw2
    }

    override fun signUp(username: String, password: String) {
        view?.Show_Progress()
        register_Interactor!!.SignUp(
            username,
            password,
            object : Register_Interactor.RegisterCallback {
                override fun onRegisterSuccess() {
                    if (inView_attached()) {
                        view?.hideProgress()
                        view?.showSuccessMessage("Registro exitoso")
                        view?.navigate_ToMain(username)
                    }
                }
                override fun onRegisterFailure(errorMsg: String) {
                    view?.hideProgress()
                    view?.showError("Error de registro")
                }
            })
    }
}
