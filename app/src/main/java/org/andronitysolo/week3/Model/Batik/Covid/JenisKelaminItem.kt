package org.andronitysolo.week3.Model.Batik.Covid

import com.google.gson.annotations.SerializedName

data class JenisKelaminItem(

	@field:SerializedName("doc_count")
	val docCount: Int,

	@field:SerializedName("key")
	val key: String
)