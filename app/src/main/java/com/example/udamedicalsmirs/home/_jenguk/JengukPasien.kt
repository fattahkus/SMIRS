package com.example.udamedicalsmirs.home._jenguk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Window
import android.view.WindowManager
import androidx.core.view.isGone
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._jenguk.__detail.DetailPasien
import com.example.udamedicalsmirs.home._jenguk.adapter.JengukAdapter
import com.example.udamedicalsmirs.home._jenguk.data.DataPasien
import com.example.udamedicalsmirs.home._jenguk.presenter.PasienPresenter
import com.example.udamedicalsmirs.home._jenguk.presenter.PasienView
import kotlinx.android.synthetic.main.activity_jenguk_pasien.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class JengukPasien : AppCompatActivity(), PasienView {


    private lateinit var presenter: PasienPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_jenguk_pasien)
        presenter = PasienPresenter(this)

        presenter.getPasien()
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.searchPasien(etSearch.text.toString())
            }
        })

    }

    override fun onSuccessFilterPasien(data: List<DataPasien>?) {
        rvPasien.adapter = JengukAdapter(data,object : JengukAdapter.onItemClick{
            override fun item(pasien: DataPasien?) {
                startActivity<DetailPasien>("dataPasien" to pasien)
            }

        })
    }

    override fun onErrorFilterPasien(msg: String?) {
        toast(msg.toString()).show()
    }

    override fun onSuccessPasien(data: List<DataPasien>?) {
        if(etSearch.text.isEmpty()){
            rvPasien.adapter = JengukAdapter(data,object : JengukAdapter.onItemClick{
                override fun item(pasien: DataPasien?) {
                    startActivity<DetailPasien>("dataPasien" to pasien)
                }

            })
        }else{
            rvPasien.isGone
        }
    }

    override fun onErrorPasien(msg: String?) {
        toast("Gagal Load Data")
    }
}
