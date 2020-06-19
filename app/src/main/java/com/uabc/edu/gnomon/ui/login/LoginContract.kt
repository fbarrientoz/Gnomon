package com.uabc.edu.gnomon.ui.login

interface LoginContract {
    interface View {
        fun showError(msgError:String)
        fun showProgressBar()
        fun hideprogressDialogBar()
        fun signIn()
        fun navigateToMain()
        fun navigateToRegister()
    }

    interface Presenter{
        fun attachView(view: View)
        fun dettachView()
        fun isViewAttached():Boolean
        fun signInUserWithEmailPassword(email:String,password:String)
        fun checkEmptyFields(email: String, password: String):Boolean
    }
}