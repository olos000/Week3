package org.andronitysolo.week3.Networking.Indonesia

import io.reactivex.Flowable
import org.andronitysolo.week3.Model.Batik.Indo.ResponseDaerah
import retrofit2.Response
import retrofit2.http.GET

interface DaerahInterface {
    @GET("api/daerahindonesia/provinsi")
    fun getDaerah():Flowable<Response<ResponseDaerah>>
}