package com.uabc.edu.gnomon.ui.registro

interface RegisterContract {

    interface RegisterView{
        fun navigateToMain()
        fun signUp()
        fun showProgress()
        fun showHideProgress()
        fun showError(errormsg:String)


    }

    interface RegisterPresenter{
        fun attachView(view:RegisterView)
        fun isViewAttach():Boolean
        fun detachView()
        fun checkEmptyName(fullname: String):Boolean
        fun checkEmptyEmailAndName(fullname:String,email:String):Boolean
        fun checkValidEmail(email:String):Boolean
        fun checkEmptyPassword(pw1:String):Boolean
        fun checkPasswordsMatch(pw1:String,pw2:String):Boolean
        fun singUp(fullname:String,email:String,password:String)
    }
}