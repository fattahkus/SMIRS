package com.example.udamedicalsmirs.home._dokter.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ResultDokter(

	@field:SerializedName("dokter")
	val dokter: List<DokterItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)