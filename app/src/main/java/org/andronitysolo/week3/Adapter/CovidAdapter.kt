package org.andronitysolo.week3.Adapter

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.Gson
import kotlinx.android.synthetic.main.covid19cardview.view.*
import org.andronitysolo.week3.Activity.Covid19DetailActivity
import org.andronitysolo.week3.Model.Batik.Covid.ListDataItem
import org.andronitysolo.week3.R

class CovidAdapter(val activity: Activity) :   RecyclerView.Adapter<CovidAdapter.CovidHolder>() {
    private var mData : MutableList<ListDataItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidAdapter.CovidHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.covid19cardview, parent, false)
        return CovidHolder(view)
    }

    override fun onBindViewHolder(holder: CovidAdapter.CovidHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int = mData.size
    fun setData(items: List<ListDataItem>) {
        Log.d("umar adapter", Gson().toJson(items))
        if (this.mData.size>= 0){
            this.mData.clear()
        }
        if (mData != null){
            this.mData.addAll(items)
        }
        notifyDataSetChanged()
    }

    inner class CovidHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(covid : ListDataItem){
            with(itemView){
                Glide.with(itemView.context)
                    .load(R.drawable.cofid)
                    .apply(RequestOptions().override(350, 550))
                    .into(img_photo)

                txt_pro.text = covid.lokasi.toString()
                txt_korban.text = covid.jumlahKasus.toString()

                card_viewco.setOnClickListener {
                    val movActivty = Intent(activity, Covid19DetailActivity::class.java)
                    activity?.startActivity(movActivty)
                }
            }

        }

    }
}