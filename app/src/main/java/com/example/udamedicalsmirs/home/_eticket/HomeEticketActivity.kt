package com.example.udamedicalsmirs.home._eticket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._eticket.adapter.EticketAdapter
import com.example.udamedicalsmirs.home._eticket.data.TicketItem
import com.example.udamedicalsmirs.home._eticket.presenter.EticketPresenter
import com.example.udamedicalsmirs.home._eticket.presenter.EticketView
import com.example.udamedicalsmirs.utils.SessionManager
import kotlinx.android.synthetic.main.activity_home_eticket.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class HomeEticketActivity : AppCompatActivity(), EticketView {

    private lateinit var sessionManager: SessionManager
    private lateinit var presenter : EticketPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_eticket)
        sessionManager = SessionManager(this)
        getData()
        btnAddTicket.onClick {
            startActivity<EticketActivity>()
            finish()
        }
    }
    override fun onSuccessList(msg: String?, data: List<TicketItem?>?) {
        rvTicket.adapter = EticketAdapter(data, object : EticketAdapter.onItemClickTicket{
            override fun item(item: TicketItem?) {
                alert {
                    title = "Informasi Pemesanan E-Ticket"
                    message = "Ticket Berhasil Dipesan"
                    yesButton {
                        startActivity<DetailEticketActivity>("dataTicket" to item)
                        finish()
                    }
                    noButton {  }
                }.show()
            }
        })
    }

    override fun onResume() {
        super.onResume()
        getData()
    }
    fun getData(){
        sessionManager = SessionManager(this)
        presenter = EticketPresenter(this)
        if (sessionManager.isLogin){
            presenter.getTicket(sessionManager.id)
        }
    }

    override fun onFailedlist(msg: String?) {
        toast(msg.toString()).show()
    }

    override fun onSuccessAdd(msg: String?) {}

    override fun onFailedAdd(msg: String?) {}
}
