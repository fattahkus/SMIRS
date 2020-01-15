package com.example.udamedicalsmirs.home._donor.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ResultMemberDonor(

    @field:SerializedName("ticket")
	val ticket: List<MemberItem?>? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("status")
	val status: Int? = null
)