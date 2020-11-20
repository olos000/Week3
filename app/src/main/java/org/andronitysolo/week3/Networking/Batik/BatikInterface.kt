package org.andronitysolo.week3.Networking.Batik

import io.reactivex.Flowable
import org.andronitysolo.week3.Model.Batik.ResponseBatik
import retrofit2.Response
import retrofit2.http.GET

interface BatikInterface {
    @GET("batik/all")
    fun getBatik(): Flowable<Response<ResponseBatik>>
}