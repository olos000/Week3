package org.andronitysolo.week3.Model.Batik

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HasilItem(

	@field:SerializedName("daerah_batik")
	val daerahBatik: String,

	@field:SerializedName("harga_rendah")
	val hargaRendah: Int,

	@field:SerializedName("harga_tinggi")
	val hargaTinggi: Int,

	@field:SerializedName("nama_batik")
	val namaBatik: String,

	@field:SerializedName("makna_batik")
	val maknaBatik: String,

	@field:SerializedName("link_batik")
	val linkBatik: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("hitung_view")
	val hitungView: Int
) : Parcelable