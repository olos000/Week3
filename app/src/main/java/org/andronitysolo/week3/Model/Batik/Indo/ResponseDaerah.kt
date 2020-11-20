package org.andronitysolo.week3.Model.Batik.Indo

import com.google.gson.annotations.SerializedName

data class ResponseDaerah(

	@field:SerializedName("provinsi")
	val provinsi: List<ProvinsiItem?>? = null
)