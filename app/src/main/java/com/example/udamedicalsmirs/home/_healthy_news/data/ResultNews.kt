package com.example.udamedicalsmirs.home._healthy_news.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ResultNews(

	@field:SerializedName("berita")
	val berita: List<BeritaItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)