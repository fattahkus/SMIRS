package com.example.udamedicalsmirs.home._dokter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._dokter.adapter.DokterAdapter
import com.example.udamedicalsmirs.home._dokter.data.DokterItem
import com.example.udamedicalsmirs.home._dokter.presenter.DokterPresenter
import com.example.udamedicalsmirs.home._dokter.presenter.DokterView
import kotlinx.android.synthetic.main.activity_jadwal_dokter.*

class JadwalDokterActivity : AppCompatActivity(), DokterView {


    private lateinit var dokterPresenter: DokterPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jadwal_dokter)

        dokterPresenter = DokterPresenter(this)
        dokterPresenter.getDokter()
    }
    override fun onSuccess(msg: String?, data: List<DokterItem?>?) {
        Log.d("Success Load Data", msg.toString())
        rvJadwalDokter.adapter = DokterAdapter(data)
    }

    override fun onFailed(msg: String?) {
        Log.d("Success Load Data", msg.toString())
    }
}
