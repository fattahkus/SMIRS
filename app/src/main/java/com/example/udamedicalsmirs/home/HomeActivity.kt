package com.example.udamedicalsmirs.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._dokter.JadwalDokterActivity
import com.example.udamedicalsmirs.home._donor.DonorActivity
import com.example.udamedicalsmirs.home._eticket.HomeEticketActivity
import com.example.udamedicalsmirs.home._healthy_news.HealthyNews
import com.example.udamedicalsmirs.home._jenguk.JengukPasien
import com.example.udamedicalsmirs.home._ruang.CekRuangActivity
import com.example.udamedicalsmirs.profile.ProfileActivity
import com.example.udamedicalsmirs.utils.SessionManager
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_home)

        sessionManager = SessionManager(this)
        getDataName()

        jenguk.onClick{
            startActivity<JengukPasien>()
        }
        jadwal.onClick {
            startActivity<JadwalDokterActivity>()
        }
        checkKamar.onClick {
            startActivity<CekRuangActivity>()
        }
        eticket.onClick {
            startActivity<HomeEticketActivity>()
        }
        donor.onClick{
            startActivity<DonorActivity>()
        }

        btnProfile.onClick{
            startActivity<ProfileActivity>()
        }

        news.onClick {
            startActivity<HealthyNews>()
        }
    }

    override fun onResume() {
        super.onResume()
        getDataName()
    }

    private fun getDataName() {
        sessionManager = SessionManager(this)
        if (sessionManager.isLogin){
            tvNameHome.text = sessionManager.nama
        }
    }
}
