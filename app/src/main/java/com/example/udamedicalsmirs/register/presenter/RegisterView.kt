package com.example.udamedicalsmirs.register.presenter

interface RegisterView {
    fun onSuccessRegister (msg: String?)
    fun onErrorRegister (msg: String?)
}