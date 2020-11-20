package org.andronitysolo.week3.Model.Batik


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseBatik(

	@field:SerializedName("max_price")
	val maxPrice: Int,

	@field:SerializedName("min_price")
	val minPrice: Int,

	@field:SerializedName("total_halaman")
	val totalHalaman: Int,

	@field:SerializedName("hasil")
	val hasil: List<HasilItem?>? = null,

	@field:SerializedName("total_element")
	val totalElement: Int? = null
) : Parcelable, List<ResponseBatik> {
	override val size: Int
		get() = TODO("Not yet implemented")

	override fun contains(element: ResponseBatik): Boolean {
		TODO("Not yet implemented")
	}

	override fun containsAll(elements: Collection<ResponseBatik>): Boolean {
		TODO("Not yet implemented")
	}

	override fun get(index: Int): ResponseBatik {
		TODO("Not yet implemented")
	}

	override fun indexOf(element: ResponseBatik): Int {
		TODO("Not yet implemented")
	}

	override fun isEmpty(): Boolean {
		TODO("Not yet implemented")
	}

	override fun iterator(): Iterator<ResponseBatik> {
		TODO("Not yet implemented")
	}

	override fun lastIndexOf(element: ResponseBatik): Int {
		TODO("Not yet implemented")
	}

	override fun listIterator(): ListIterator<ResponseBatik> {
		TODO("Not yet implemented")
	}

	override fun listIterator(index: Int): ListIterator<ResponseBatik> {
		TODO("Not yet implemented")
	}

	override fun subList(fromIndex: Int, toIndex: Int): List<ResponseBatik> {
		TODO("Not yet implemented")
	}
}