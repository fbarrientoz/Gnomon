package com.uabc.edu.gnomon.interactor.login

import com.google.firebase.auth.FirebaseAuth

class SingInInteractorimpl: SignInInteractor {


    override fun signInWithEmailAndPassword(email: String, password: String,
        listener: SignInInteractor.SingInCallBack) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener{
            if (it.isSuccessful)
                listener.onSingInSucces()
            else
                listener.onSingInfailure(it.exception?.message!!)
        }
    }

}