package org.andronitysolo.week3.Activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_batik_detail.*
import org.andronitysolo.week3.Model.Batik.Covid.ListDataItem
import org.andronitysolo.week3.R

class Covid19DetailActivity : AppCompatActivity() {
    val data = MutableLiveData<List<ListDataItem?>>()
    val isLoading = MutableLiveData<Boolean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid19_detail)
        val data= Gson().fromJson(intent.getStringExtra("data"), ListDataItem::class.java)
        Glide.with(this)
            .load(R.drawable.cofid)
            .apply(RequestOptions().override(350, 550))
            .into(img_photo)

        progressDetailMovie.visibility = View.GONE
    }
}