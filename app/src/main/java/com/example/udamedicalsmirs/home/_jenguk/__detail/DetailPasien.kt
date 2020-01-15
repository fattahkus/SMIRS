package com.example.udamedicalsmirs.home._jenguk.__detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._jenguk.data.DataPasien
import kotlinx.android.synthetic.main.activity_detail_pasien.*


class DetailPasien : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_detail_pasien)
        val data  = intent.getSerializableExtra("dataPasien") as DataPasien

        tvDetpasien.text = data.namaPasien.toString()
        tvDetJam.text = data.waktuPasien.toString()
        tvDetRoom.text = data.ruanganPasien.toString()
        tvDetAddress.text = data.alamatPasien.toString()
        tvDetPhone.text = data.hpPasien.toString()
        tvDetDiagnostic.text = data.diagnosaPasien.toString()
    }
}
