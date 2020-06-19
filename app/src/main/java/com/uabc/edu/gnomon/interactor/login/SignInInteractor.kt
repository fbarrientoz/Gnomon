package com.uabc.edu.gnomon.interactor.login

interface SignInInteractor {

    interface SingInCallBack {
        fun onSingInSucces()
        fun onSingInfailure(errorMsg:String)
    }

    fun signInWithEmailAndPassword(email:String,password:String,listener:SingInCallBack)
}