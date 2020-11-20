package org.andronitysolo.week3.Adapter

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.cardviewmuseum.view.*
import org.andronitysolo.week3.Activity.MuseumDetailActivity
import org.andronitysolo.week3.Model.Batik.Museum.DataItem
import org.andronitysolo.week3.R


class MuseumAdapter(val activity: Activity) :   RecyclerView.Adapter<MuseumAdapter.MuseumViewHolder>() {
    private var mData : MutableList<DataItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumAdapter.MuseumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardviewmuseum, parent, false)
        return MuseumViewHolder(view)
    }

    override fun onBindViewHolder(holder: MuseumAdapter.MuseumViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int = mData.size

    inner class MuseumViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind (museum : DataItem){
         itemView.txt_name.text = museum.nama
         itemView.txt_asal.text = museum.propinsi

            itemView.card_viewMus.setOnClickListener {
                val movActivty = Intent(activity, MuseumDetailActivity::class.java)
                activity?.startActivity(movActivty)

            }

        }

    }

    fun setData(items: List<DataItem>) {
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