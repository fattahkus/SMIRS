package com.example.udamedicalsmirs.home._donor.pesenter

import com.example.udamedicalsmirs.home._donor.data.MemberItem

interface DonorView {
    fun onSuccessDonor (msg : String?)
    fun onFailedDonor (msg : String?)

    fun onSuccessMember(msg : String?, member : List<MemberItem?>?, position : Int?)
    fun onFailedMember(msg: String?)
}