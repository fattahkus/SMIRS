package com.example.udamedicalsmirs.home._ruang.presenter

import com.example.udamedicalsmirs.home._ruang.data.RuangItem

interface RuangView {
    fun onSuccess(msg : String?, data : List<RuangItem?>?)
    fun onFailed(msg : String?)
}