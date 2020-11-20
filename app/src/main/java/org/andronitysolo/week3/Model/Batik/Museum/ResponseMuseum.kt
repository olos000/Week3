package org.andronitysolo.week3.Model.Batik.Museum

import com.google.gson.annotations.SerializedName

data class ResponseMuseum(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null
)