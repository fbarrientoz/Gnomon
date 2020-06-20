package com.uabc.edu.gnomon.interactor.login

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthMultiFactorException;
import com.google.firebase.auth.FirebaseUser;

class SingInInteractorimpl: SignInInteractor {

    private lateinit var auth: FirebaseAuth



    override fun signInWithEmailAndPassword(email: String, password: String,
        listener: SignInInteractor.SingInCallBack) {
        auth = FirebaseAuth.getInstance()
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener{
            if (it.isSuccessful)
                listener.onSingInSucces()
            else
                listener.onSingInfailure(it.exception?.message!!)
        }
    }

}