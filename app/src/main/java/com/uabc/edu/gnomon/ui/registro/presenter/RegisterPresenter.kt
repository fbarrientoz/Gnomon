package com.uabc.edu.gnomon.ui.registro.presenter

import androidx.core.util.PatternsCompat
import com.uabc.edu.gnomon.interactor.registro.RegisterInteractor
import com.uabc.edu.gnomon.ui.registro.RegisterContract

class RegisterPresenter(registerInteractor: RegisterInteractor):RegisterContract.RegisterPresenter{

    var view:RegisterContract.RegisterView? = null
    var registerInteractor:RegisterInteractor? = null

    init {
        this.registerInteractor = registerInteractor
    }

    override fun attachView(view: RegisterContract.RegisterView) {
        this.view = view
    }

    override fun isViewAttach(): Boolean {
        return view != null
    }

    override fun detachView() {
        view = null
    }

    override fun checkEmptyName(fullname: String): Boolean {
        return fullname.isEmpty()
    }

    override fun checkEmptyEmailAndName(fullname: String, email: String): Boolean {
        return fullname.isEmpty() or email.isEmpty()
    }

    override fun checkValidEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun checkEmptyPassword(pw1: String, pw2: String): Boolean {
        return pw1.isEmpty() or pw2.isEmpty()
    }

    override fun checkPasswordsMatch(pw1: String, pw2: String): Boolean {
        return pw1 == pw2
    }

    override fun singUp(fullname: String, email: String, password: String) {
        registerInteractor?.signUp(fullname,email,password, object: RegisterInteractor.RegisterCallback{
            override fun onRegisterSuccess() {
                view?.navigateToMain()
                view?.showHideProgress()
            }

            override fun onRegisterFailure(errorMsg: String) {
                view?.showError(errorMsg)
                view?.showHideProgress()
            }

        })
    }

}