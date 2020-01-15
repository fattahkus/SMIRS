package com.example.udamedicalsmirs.home._eticket.presenter

import com.example.udamedicalsmirs.home._eticket.data.TicketItem

interface EticketView {
    fun onSuccessList (msg : String?, data : List<TicketItem?>?)
    fun onFailedlist (msg: String?)
    fun onSuccessAdd (msg: String?)
    fun onFailedAdd (msg: String?)
}