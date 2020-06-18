package com.uabc.edu.gnomon.ui.login.presenter

import com.uabc.edu.gnomon.interactor.login.SignInInteractor
import com.uabc.edu.gnomon.interactor.login.SignInInteractor.SingInCallBack
import com.uabc.edu.gnomon.ui.login.LoginContract

class LoginPresenter(signInInteractor:SignInInteractor): LoginContract.Presenter {

    var signInInteractor: SignInInteractor? = null

    init {
        this.signInInteractor = signInInteractor
    }

    var view:LoginContract.View? = null

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun dettachView() {
        view = null
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }

    override fun signInUserWithEmailPassword(email: String, password: String) {
        view?.showProgressBar()
        signInInteractor?.signInWithEmailAndPassword(email,password,object : SingInCallBack{
            override fun onSingInSucces() {
                if(isViewAttached()){
                    view?.hideprogressDialogBar()
                    view?.navigateToMain()
                }
            }

            override fun onSingInfailure(errorMsg: String) {
                view?.hideprogressDialogBar()
                view?.showError(errorMsg)
            }

        })
    }

    override fun checkEmptyFields(email: String, password: String):Boolean {
        return email.isEmpty() || password.isEmpty()
    }

}