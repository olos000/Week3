package org.andronitysolo.week3.Networking.Museum

import io.reactivex.Flowable
import org.andronitysolo.week3.Model.Batik.Museum.ResponseMuseum
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MuseumInterface {
    @GET("CcariMuseum/searchGET?nama=museum")
    fun GetMuseum() : Flowable<Response<ResponseMuseum>>

    @GET("CcariMuseum/searchGET?nama=museum")
    fun SeacrhMuseum(
        @Query("nama") name : String
    ): Flowable<Response<ResponseMuseum>>
}