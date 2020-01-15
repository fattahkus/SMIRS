package com.example.udamedicalsmirs.home._jenguk.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Generated("com.robohorse.robopojogenerator")
data class DataPasien (

	@field:SerializedName("nama_pasien")
	val namaPasien: String? = null,

	@field:SerializedName("diagnosa_pasien")
	val diagnosaPasien: String? = null,

	@field:SerializedName("alamat_pasien")
	val alamatPasien: String? = null,

	@field:SerializedName("id_pasien")
	val idPasien: String? = null,

	@field:SerializedName("waktu_pasien")
	val waktuPasien: String? = null,

	@field:SerializedName("ruangan_pasien")
	val ruanganPasien: String? = null,

	@field:SerializedName("hp_pasien")
	val hpPasien: String? = null
): Serializable
