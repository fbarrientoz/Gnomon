package com.uabc.edu.gnomon.ui.login.view
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.uabc.edu.gnomon.MainActivity
import com.uabc.edu.gnomon.R
import com.uabc.edu.gnomon.base.BaseActivity
import com.uabc.edu.gnomon.interactor.login.SingInInteractorimpl
import com.uabc.edu.gnomon.ui.login.LoginContract
import com.uabc.edu.gnomon.ui.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*


class Login : BaseActivity(),LoginContract.View{

    lateinit var presenter:LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter(SingInInteractorimpl())
        presenter.attachView(this)
        btn_signIn.setOnClickListener{
            signIn()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_login;
    }

    override fun showError(msgError: String) {
        Toast.makeText(this, msgError, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        progressBar_singIn.visibility = View.VISIBLE
    }

    override fun hideprogressDialogBar() {
        progressBar_singIn.visibility = View.GONE
    }

    override fun signIn() {
        val email = et_name.text.toString().trim()
        val password = et_password.text.toString().trim()
        if (presenter.checkEmptyFields(email,password))
            Toast.makeText(this, "Existen Campos Vacíos", Toast.LENGTH_SHORT)
            .show()
        else
            presenter.signInUserWithEmailPassword(email, password)

    }

    override fun navigateToMain() {
        //startActivity(Intent(this,MainActivity::class.java))
    }

    override fun navigateToRegister() {
        //startActivity(Intent(this,MainActivity::class.java))
    }
}