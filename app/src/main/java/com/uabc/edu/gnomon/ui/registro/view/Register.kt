package com.uabc.edu.gnomon.ui.registro.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.uabc.edu.gnomon.MainActivity
import com.uabc.edu.gnomon.R
import com.uabc.edu.gnomon.base.BaseActivity
import com.uabc.edu.gnomon.interactor.registro.RegisterInteractorImpl
import com.uabc.edu.gnomon.ui.registro.RegisterContract
import com.uabc.edu.gnomon.ui.registro.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class Register : BaseActivity(), RegisterContract.RegisterView {

    lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = RegisterPresenter(RegisterInteractorImpl())
        presenter.attachView(this)
        btn_registrar.setOnClickListener {
            signUp()
        }
    }



    override fun getLayout(): Int {
        return R.layout.activity_register;
    }

    override fun navigateToMain() {
        val intent = Intent(this,MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun signUp() {
        val fullname:String = et_nombre.text.toString().trim()
        val email:String = et_email_registro.text.toString().trim()
        val pw1:String = et_password_1.text.toString().trim()
        val pw2:String = et_password_2.text.toString().trim()

        if(presenter.checkEmptyName(fullname)) {
            et_nombre.error = "Campo nombre vacìo"
            return
        }
        if (!presenter.checkValidEmail(email)) {
            et_email_registro.error = "Correo invalido"
            return
        }

        if (presenter.checkEmptyPassword(pw1)) {
            et_password_1.error = "Campo contraseña vacío"
            return
        }

        if (presenter.checkEmptyPassword(pw2)) {
            et_password_2.error = "Campo contraseña vacío"
            return
        }

        if (!presenter.checkPasswordsMatch(pw1,pw2)) {
            et_password_1.error = "contraseñas no coinciden"
            et_password_2.error = "contraseñas no coinciden"
            return
        }

        presenter.singUp(fullname,email,pw1)

    }

    override fun showProgress() {
        progress_registrar.visibility = View.VISIBLE
        btn_registrar.visibility = View.GONE


    }

    override fun showHideProgress() {
        progress_registrar.visibility = View.GONE
        btn_registrar.visibility = View.VISIBLE
    }

    override fun showError(errormsg: String) {
        Toast.makeText(this, errormsg, Toast.LENGTH_SHORT).show()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.detachView()
    }
}