package org.andronitysolo.week3.Networking.Batik

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.andronitysolo.week3.Networking.Api
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class BatikApi {
    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(60 * 5, TimeUnit.SECONDS)
        .readTimeout(60 * 5, TimeUnit.SECONDS)
        .writeTimeout(60 * 5, TimeUnit.SECONDS)
    private val loggingInterceptor = HttpLoggingInterceptor()

    private fun retrofit(): Retrofit? {
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        okHttpClient.addInterceptor(loggingInterceptor)
        return Retrofit.Builder()
            .client(okHttpClient.build())
            .baseUrl(Api.BATIK_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun instance() = retrofit()!!.create<BatikInterface>(BatikInterface::class.java)
}