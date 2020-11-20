package org.andronitysolo.week3.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_batik_detail.*
import org.andronitysolo.week3.Model.Batik.HasilItem
import org.andronitysolo.week3.R

class BatikDetailActivity : AppCompatActivity() {
    val data = MutableLiveData<List<HasilItem?>>()
    val isLoading = MutableLiveData<Boolean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batik_detail)
        val data= Gson().fromJson(intent.getStringExtra("data"), HasilItem::class.java)
        Glide.with(this)
                .load(data.linkBatik)
                .apply(RequestOptions().override(350, 550))
                .into(img_photo)
        txt_name.text = data.namaBatik
        txt_deskripsi.text = data.maknaBatik
        txt_asal.text = data.daerahBatik
        txt_hargard.text = data.hargaRendah.toString()
        txt_hargaMahl.text = data.hargaTinggi.toString()
        txt_view.text = data.hitungView.toString()
        progressDetailMovie.visibility = View.GONE
    }
}