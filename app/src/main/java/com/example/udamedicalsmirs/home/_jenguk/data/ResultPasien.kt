package com.example.udamedicalsmirs.home._jenguk.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ResultPasien(

    @field:SerializedName("data")
	val data: List<DataPasien>? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("status")
	val status: Int? = null
)