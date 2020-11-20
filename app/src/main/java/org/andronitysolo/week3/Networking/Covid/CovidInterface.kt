package org.andronitysolo.week3.Networking.Covid

import io.reactivex.Flowable
import org.andronitysolo.week3.Model.Batik.Covid.ResponseCovid
import retrofit2.Response
import retrofit2.http.GET

interface CovidInterface {
    @GET("public/api/prov.json")
    fun GetCovid():Flowable<Response<ResponseCovid>>
}