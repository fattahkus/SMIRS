package com.example.udamedicalsmirs.home._ruang.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ResultRuang(

	@field:SerializedName("ruang")
	val ruang: List<RuangItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)