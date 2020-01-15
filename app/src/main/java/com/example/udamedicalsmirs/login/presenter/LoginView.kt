package com.example.udamedicalsmirs.login.presenter

import com.example.udamedicalsmirs.login.data.User


interface LoginView {
    fun onSuccessLogin (user : User?, msg: String?)
    fun onErrorLogin (msg: String?)
}