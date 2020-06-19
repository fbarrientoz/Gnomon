package com.uabc.edu.gnomon.interactor.registro

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class RegisterInteractorImpl: RegisterInteractor{
    override fun signUp(
        fullname: String,
        email: String,
        password: String,
        listener: RegisterInteractor.RegisterCallback
    ) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {itSignUp ->
                if (itSignUp.isSuccessful) {
                    val profileUpdate: UserProfileChangeRequest =
                        UserProfileChangeRequest.Builder().setDisplayName(fullname).build()
                    FirebaseAuth.getInstance().currentUser?.updateProfile(profileUpdate)?.addOnCompleteListener {
                        if (it.isSuccessful){
                            listener.onRegisterSuccess()
                        }
                    }
                } else {
                    listener.onRegisterFailure(itSignUp.exception?.message.toString())

                }
            }
    }


}