package com.example.udamedicalsmirs.home._healthy_news.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Generated("com.robohorse.robopojogenerator")
data class BeritaItem(

	@field:SerializedName("tgl_berita")
	val tglBerita: String? = null,

	@field:SerializedName("jenis_berita")
	val jenisBerita: String? = null,

	@field:SerializedName("id_berita")
	val idBerita: String? = null,

	@field:SerializedName("judul_berita")
	val judulBerita: String? = null,

	@field:SerializedName("isi_berita")
	val isiBerita: String? = null
): Serializable