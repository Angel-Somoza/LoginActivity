package com.example.loginactivity.Visual.Login.Presenter

import com.example.loginactivity.Logic.Interactor.Login_Interactor.Login_Interactor
import com.example.loginactivity.Visual.Login.Login_contract

class Login_Presenter(Login_Interactor: Login_Interactor): Login_contract.Login_Presenter {

    var view: Login_contract.Login_View? = null
    var loginInteractor: Login_Interactor? =null
    init {
       this.loginInteractor = Login_Interactor
    }

    override fun attachView(view: Login_contract.Login_View) {
            this.view =view
    }

    override fun dettachView() {
        view = null
    }

    override fun isViewAttched(): Boolean {
        return view != null
    }

    override fun userandpassword(username: String, password: String) {
          view?.showProgressBar()
          loginInteractor!!.userandpassword(username, password, object: Login_Interactor.SignInCallback{
              override fun onSignInSuccess() {
                  if (isViewAttched()) {
                      view?.hideProgressBar()
                      view?.navigateToMain(username)
                  }
              }
              override fun onSignInFailure(errorMessage: String) {
                  if (isViewAttched()) {
                      view?.showError(errorMessage)
                      view?.hideProgressBar()
                  }
              }
          })


    }

    override fun checkEmptyFields(username: String, password: String): Boolean {
        return username.isEmpty() || password.isEmpty()    }
}