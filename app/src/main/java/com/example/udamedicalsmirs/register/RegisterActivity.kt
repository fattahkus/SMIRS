package com.example.udamedicalsmirs.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Window
import android.view.WindowManager
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.login.LoginPageActivity
import com.example.udamedicalsmirs.register.presenter.RegisterPresenter
import com.example.udamedicalsmirs.register.presenter.RegisterView
import kotlinx.android.synthetic.main.layout_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class RegisterActivity : AppCompatActivity(), RegisterView {


    private lateinit var presenter: RegisterPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_register)


        presenter = RegisterPresenter(this)
        manualLogin.onClick {
            startActivity<LoginPageActivity>()

        }
        regPassword.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (regPassword.length() <= 6){
                    regPassword.setError("Password Harus Lebih Dari 6 Karakter!")
                }
            }
        })

        btnRegister.onClick {

            val nama = regName.text.toString()
            val email = regEmail.text.toString()
            val nohp = regPhone.text.toString()
            val password = regPassword.text.toString()

            presenter.registerUser(nama, email, nohp, password)

        }
    }

    override fun onSuccessRegister(msg: String?) {
        alert {
            title = "Information Register"
            message = "Successfully To Register"
        }.show()
        startActivity<LoginPageActivity>()
        finish()
    }

    override fun onErrorRegister(msg: String?) {
        alert {
            title = "Information Register"
            message = "Failed To Register"
        }.show()
    }
}
