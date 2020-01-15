package com.example.udamedicalsmirs.home._ruang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._ruang.adapter.RuangAdapter
import com.example.udamedicalsmirs.home._ruang.data.RuangItem
import com.example.udamedicalsmirs.home._ruang.presenter.RuangPresenter
import com.example.udamedicalsmirs.home._ruang.presenter.RuangView
import kotlinx.android.synthetic.main.activity_cek_ruang.*
import org.jetbrains.anko.startActivity

class CekRuangActivity : AppCompatActivity(), RuangView {

    private lateinit var ruangPresenter: RuangPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_ruang)

        ruangPresenter = RuangPresenter(this)
        ruangPresenter.getRuang()
    }
    override fun onSuccess(msg: String?, data: List<RuangItem?>?) {
        rvCekRuang.adapter = RuangAdapter(data, object : RuangAdapter.onItemClickRuang{
            override fun item(item: RuangItem?) {
                startActivity<DetailKamarActivity>()
            }

        })
        Log.d("Success Data Ruang", msg.toString())
    }

    override fun onFailed(msg: String?) {
        Log.d("Error  Data Ruang", msg.toString())
    }

}
