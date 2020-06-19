package com.uabc.edu.gnomon.interactor.registro

interface RegisterInteractor {

    interface RegisterCallback{
        fun onRegisterSuccess()
        fun onRegisterFailure(errorMsg:String)
    }

    fun signUp(
        fullname:String,
        email:String,
        password:String,
        Listener: RegisterCallback
    )
}