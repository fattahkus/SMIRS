package com.example.udamedicalsmirs.home._ruang.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class RuangItem(

	@field:SerializedName("id_ruang")
	val idRuang: String? = null,

	@field:SerializedName("kamar_tersedia")
	val kamarTersedia: String? = null,

	@field:SerializedName("foto_ruang")
	val fotoRuang: String? = null,

	@field:SerializedName("jumlah_kamar")
	val jumlahKamar: String? = null,

	@field:SerializedName("nama_ruang")
	val namaRuang: String? = null
)