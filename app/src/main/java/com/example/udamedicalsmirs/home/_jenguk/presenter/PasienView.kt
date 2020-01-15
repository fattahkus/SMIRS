package com.example.udamedicalsmirs.home._jenguk.presenter

import com.example.udamedicalsmirs.home._jenguk.data.DataPasien

interface PasienView {
    fun onSuccessPasien(data : List<DataPasien>?) //Sesuaikan dengan result produk
    fun onErrorPasien(msg: String?)

    fun onSuccessFilterPasien(data : List<DataPasien>?) //Sesuaikan dengan result produk
    fun onErrorFilterPasien(msg: String?)


}