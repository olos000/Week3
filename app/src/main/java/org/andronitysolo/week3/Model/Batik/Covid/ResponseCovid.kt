package org.andronitysolo.week3.Model.Batik.Covid

import com.google.gson.annotations.SerializedName

data class ResponseCovid(

	@field:SerializedName("missing_data")
	val missingData: Double,

	@field:SerializedName("tanpa_provinsi")
	val tanpaProvinsi: Int,

	@field:SerializedName("current_data")
	val currentData: Double,

	@field:SerializedName("list_data")
	val listData: List<ListDataItem>,

	@field:SerializedName("last_date")
	val lastDate: String
)