package com.example.udamedicalsmirs.home._donor


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.udamedicalsmirs.R
import com.example.udamedicalsmirs.home._donor.data.MemberItem
import com.example.udamedicalsmirs.home._donor.pesenter.DonorPresenter
import com.example.udamedicalsmirs.home._donor.pesenter.DonorView
import com.example.udamedicalsmirs.utils.SessionManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_update_donor.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

/**
 * A simple [Fragment] subclass.
 */
class UpdateDonorFragment : BottomSheetDialogFragment(), DonorView {


    private lateinit var sessionManager: SessionManager
    private lateinit var presenter : DonorPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_donor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = DonorPresenter(this)
        sessionManager = SessionManager(activity)


        if (bottomNote.text.isEmpty()){
            bottomNote.addTextChangedListener(object : TextWatcher{
                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (bottomNote.text.isEmpty()){
                        bottomNote.setError("Golongan Darah Tidak Boleh Kosong")
                    }
                }
            })
        }
        bottomNewMember.onClick {
            val iddonor = sessionManager.phone
            val idUser = sessionManager.id
            val pointdonor = "0"
            val donasidonor = "0"
            val goldarah = bottomNote.text.toString()
            presenter.newMember(iddonor,idUser,goldarah,pointdonor,donasidonor)
            newBuild(goldarah,iddonor)
        }

    }
    private fun newBuild(goldar : String? , phone : String?) {
        val sesi = SessionManager(context)
        sesi.createLoginSession("")
        sesi.goldar = goldar
        sesi.phone = phone
    }
    override fun onSuccessDonor(msg: String?) {
        toast(msg.toString()).show()
        startActivity<DonorActivity>()
        dismiss()
    }

    override fun onFailedDonor(msg: String?) {
        toast(msg.toString()).show()
    }
    override fun onFailedMember(msg: String?) {}
    override fun onSuccessMember(msg: String?, member: List<MemberItem?>?, position: Int?) {}
}
