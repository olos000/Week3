package org.andronitysolo.week3.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.cardviewindonesia.view.*
import org.andronitysolo.week3.Model.Batik.Indo.ProvinsiItem
import org.andronitysolo.week3.R

class DaerahAdapter() : RecyclerView.Adapter<DaerahAdapter.DRVieHolde>(){
    private var mData : MutableList<ProvinsiItem> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaerahAdapter.DRVieHolde {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardviewindonesia, parent, false)
        return DRVieHolde(view)
    }

    override fun onBindViewHolder(holder: DaerahAdapter.DRVieHolde, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int = mData.size

    inner class DRVieHolde(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(indo : ProvinsiItem){
            itemView.tv_daerah.text = indo.nama
        }

    }
    fun setData(items: List<ProvinsiItem>) {
        Log.d("umar adapter", Gson().toJson(items))
        if (this.mData.size>= 0){
            this.mData.clear()
        }
        if (mData != null){
            this.mData.addAll(items)
        }
        notifyDataSetChanged()
    }
}