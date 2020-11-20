package org.andronitysolo.week3.Model.Batik.Covid

import com.google.gson.annotations.SerializedName

data class ListDataItem(

	@field:SerializedName("penambahan")
	val penambahan: Penambahan,

	@field:SerializedName("doc_count")
	val docCount: Double,

	@field:SerializedName("lokasi")
	val lokasi: Lokasi,

	@field:SerializedName("jumlah_meninggal")
	val jumlahMeninggal: Int,

	@field:SerializedName("kelompok_umur")
	val kelompokUmur: List<KelompokUmurItem>,

	@field:SerializedName("jumlah_kasus")
	val jumlahKasus: Int,

	@field:SerializedName("jumlah_sembuh")
	val jumlahSembuh: Int,

	@field:SerializedName("jenis_kelamin")
	val jenisKelamin: List<JenisKelaminItem>,

	@field:SerializedName("key")
	val key: String,

	@field:SerializedName("jumlah_dirawat")
	val jumlahDirawat: Int
)