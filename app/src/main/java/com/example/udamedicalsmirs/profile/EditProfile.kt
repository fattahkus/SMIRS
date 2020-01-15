package com.example.udamedicalsmirs.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.profile.presenter.UpdatePresenter
import com.example.udamedicalsmirs.profile.presenter.UpdateView
import com.example.udamedicalsmirs.utils.SessionManager
import kotlinx.android.synthetic.main.activity_edit_profile.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick

class EditProfile : AppCompatActivity(), UpdateView {

    private lateinit var sessionManager: SessionManager
    private lateinit var presenter: UpdatePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        sessionManager = SessionManager(this)
        if (sessionManager.isLogin) {
            etProfileName.setText(sessionManager.nama)
            etProfileAlamat.setText(sessionManager.alamat)
            etProfilePhone.setText(sessionManager.phone)
        }

        presenter = UpdatePresenter(this)
        btnProfileUpdate.onClick {

            val name = etProfileName.text.toString()
            val alamat = etProfileAlamat.text.toString()
            val phone = etProfilePhone.text.toString()
            val password = etProfilePassword.text.toString()
            presenter.updateUser(sessionManager.id,name,phone,alamat,password)
            newBuild(name,alamat,password,phone)
        }
    }

    private fun newBuild(name : String?, alamat : String?, password : String? , phone : String?) {
        val sesi = SessionManager(this)
        sesi.createLoginSession("")
        sesi.nama = name
        sesi.phone = phone
        sesi.alamat = alamat
    }

    override fun onSuccessUpdate(msg: String?) {
        alert {
            title = "Success Update"
        }.show()
        finish()
    }

    override fun onFailedUpdate(msg: String?) {
    }
}


//            alert {
//                title = "Informasi Data"
//                message = "${sessionManager.nama}\n${sessionManager.email}\n" +
//                        "${sessionManager.phone}\n${sessionManager.alamat}\n" +
//                        "${sessionManager.id}\n"
//            }.show()
