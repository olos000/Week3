package org.andronitysolo.week3.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_batik_detail.img_photo
import kotlinx.android.synthetic.main.activity_batik_detail.txt_name
import kotlinx.android.synthetic.main.activity_museum_detail.*
import org.andronitysolo.week3.Model.Batik.Museum.DataItem
import org.andronitysolo.week3.R

class MuseumDetailActivity : AppCompatActivity() {
    val data2 = MutableLiveData<List<DataItem?>>()
    val isLoading = MutableLiveData<Boolean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum_detail)
        val data2= Gson().fromJson(intent.getStringExtra("data"), DataItem::class.java)
        Glide.with(this)
                .load(R.drawable.museum)
                .apply(RequestOptions().override(350, 550))
                .into(img_photo)

        txt_name.text = data2.nama
        txt_provinsil.text = data2.propinsi
        txt_alamat.text = data2.alamatJalan
        txt_pengelola.text = data2.pengelola
        txt_kota.text = data2.kabupatenKota
        txt_kecamatan.text = data2.kecamatan
    }
}