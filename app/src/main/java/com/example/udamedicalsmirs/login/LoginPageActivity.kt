package com.example.udamedicalsmirs.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home.HomeActivity
import com.example.udamedicalsmirs.login.data.User
import com.example.udamedicalsmirs.login.presenter.LoginPresenter
import com.example.udamedicalsmirs.login.presenter.LoginView
import com.example.udamedicalsmirs.register.RegisterActivity
import com.example.udamedicalsmirs.utils.SessionManager
import kotlinx.android.synthetic.main.layout_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class LoginPageActivity : AppCompatActivity(), LoginView {


    private lateinit var presenter : LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login_page)

        manualRegister.onClick {
            startActivity<RegisterActivity>()
        }

        presenter = LoginPresenter(this)


        cirLoginButton.onClick {
            val email = editTextEmail.text.toString()
            val nohp = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            presenter.loginUser(email, password , nohp)

        }
    }

    override fun onSuccessLogin(user: User?, msg: String?) {
            val sesi = SessionManager(this)
            sesi.createLoginSession("")
            sesi.email = user?.userEmail
            sesi.nama = user?.userNama
            sesi.phone = user?.userHp
            sesi.alamat = user?.userAlamat
            sesi.id = user?.userId
            startActivity<HomeActivity>()
        finish()

    }

    override fun onErrorLogin(msg: String?) {
        alert {
            title = "Informasi Login"
            message = msg ?: "Email/NoHp atau Password Salah"
        }.show()
    }
}
