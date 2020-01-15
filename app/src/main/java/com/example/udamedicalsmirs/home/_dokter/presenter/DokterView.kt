package com.example.udamedicalsmirs.home._dokter.presenter

import com.example.udamedicalsmirs.home._dokter.data.DokterItem

interface DokterView {
    fun onSuccess (msg : String?, data : List<DokterItem?>?)
    fun onFailed (msg : String?)

}