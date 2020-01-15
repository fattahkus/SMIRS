package com.example.udamedicalsmirs.home._eticket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._eticket.data.TicketItem
import com.example.udamedicalsmirs.home._eticket.presenter.EticketAddPresenter
import com.example.udamedicalsmirs.home._eticket.presenter.EticketView
import com.example.udamedicalsmirs.utils.SessionManager
import kotlinx.android.synthetic.main.activity_eticket.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class EticketActivity : AppCompatActivity(), EticketView {


    private lateinit var sessionManager: SessionManager
    private lateinit var presenter : EticketAddPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eticket)

        sessionManager = SessionManager(this)
        val adapter = ArrayAdapter.createFromResource(this,R.array.jenis, android.R.layout.simple_spinner_dropdown_item)
        jenisperiksa.adapter = adapter
        val adapter1 = ArrayAdapter.createFromResource(this,R.array.dokter, android.R.layout.simple_spinner_dropdown_item)
        namadokter.adapter = adapter1
        presenter = EticketAddPresenter(this)
        btnPesanTicket.onClick {
            val booking = (0..1000).random().toString()
            val orderticket = sessionManager.id
            val name = etNamePasien.text.toString()
            val phone = etPhonePasien.text.toString()
            val jenis = jenisperiksa.selectedItem.toString()
            val dokter = namadokter.selectedItem.toString()

            presenter.addTicket(booking,orderticket,name,phone,jenis,dokter)
            startActivity<HomeEticketActivity>()
            finish()
        }
    }
    override fun onSuccessAdd(msg: String?) {
        Log.d("Success Add", msg.toString())
    }
    override fun onFailedAdd(msg: String?) {
        Log.d("Failed Add",msg.toString())
    }
    override fun onSuccessList(msg: String?, data: List<TicketItem?>?) {}
    override fun onFailedlist(msg: String?) {}
}
