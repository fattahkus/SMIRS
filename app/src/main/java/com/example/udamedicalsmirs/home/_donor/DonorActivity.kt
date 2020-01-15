package com.example.udamedicalsmirs.home._donor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._donor.data.MemberItem
import com.example.udamedicalsmirs.home._donor.pesenter.DonorPresenter
import com.example.udamedicalsmirs.home._donor.pesenter.DonorView
import com.example.udamedicalsmirs.utils.SessionManager
import kotlinx.android.synthetic.main.activity_donor.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class   DonorActivity : AppCompatActivity(), DonorView {
    private lateinit var presenter: DonorPresenter
    private lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donor)
        sessionManager = SessionManager(this)
        presenter = DonorPresenter(this)
        getData()
        updateDonor.onClick {
            val fragmentBottom = UpdateDonorFragment()
            val bundle = Bundle()
            fragmentBottom.arguments = bundle
            fragmentBottom.show(supportFragmentManager,"")
            onResume()
        }
        presenter.getMember(sessionManager.phone)
    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    fun getData(){
        sessionManager = SessionManager(this)
        if (sessionManager.isLogin){
            typeBlood.text = sessionManager.goldar
            namePendonor.text = sessionManager.nama
            idMemberPendonor.text = sessionManager.phone
        }
    }

    override fun onSuccessMember(msg: String?, member: List<MemberItem?>?, position: Int?) {
    }

    override fun onFailedMember(msg: String?) {

    }
    override fun onSuccessDonor(msg: String?) {
        finish()
    }
    override fun onFailedDonor(msg: String?) {}
}
