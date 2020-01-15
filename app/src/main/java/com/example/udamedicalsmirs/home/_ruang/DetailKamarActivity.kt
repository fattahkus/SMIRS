package com.example.udamedicalsmirs.home._ruang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.udamedicalsmirs.R
import kotlinx.android.synthetic.main.activity_detail_kamar.*

class DetailKamarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kamar)
        maintenance.setImageResource(R.drawable.maintenance)
    }
}
