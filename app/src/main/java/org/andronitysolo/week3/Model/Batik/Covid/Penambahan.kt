package org.andronitysolo.week3.Model.Batik.Covid

import com.google.gson.annotations.SerializedName

data class Penambahan(

	@field:SerializedName("meninggal")
	val meninggal: Int,

	@field:SerializedName("positif")
	val positif: Int,

	@field:SerializedName("sembuh")
	val sembuh: Int
)